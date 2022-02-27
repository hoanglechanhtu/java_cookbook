package com.example.demoweb.completable.future;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class CompletableFutureEx {
    private Map<Integer, Product> cache = new HashMap<>();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Product getLocal(int id) {
        return cache.get(id);
    }

    private Product getRemote(int id) {
        try {
            Thread.sleep(100);
            if (id == 666) {
                throw new RuntimeException("Evil request");
            }
        } catch (InterruptedException ignored) {

        }
        return new Product(id, "name");
    }

    public CompletableFuture<Product> getProduct(int id) {
        try {
            Product product = getLocal(id);
            if (product != null) {
                logger.info("get local with id=" + id);
                return CompletableFuture.completedFuture(product);
            } else {
                logger.info("get remote with id=" + id);
                return CompletableFuture.supplyAsync(() -> {
                    Product p = getRemote(id);
                    cache.put(id, p);
                    return p;
                });
            }
        } catch (Exception e) {
            logger.info("get product throw exception");
            CompletableFuture<Product> future = new CompletableFuture<>();
            future.completeExceptionally(e);
            return future;
        }
    }

    void saveResultList(List<Result> list) {
        list.parallelStream().forEach(this::saveResult2File);
    }
    Gson gson = new Gson();
    public static final String dir = ".";
    void saveResult2File(Result result) {
        String fileName = result.result;
        try {
            File file = new File(dir + "/" + fileName);
            Files.write(file.toPath().toAbsolutePath(), gson.toJson(result).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OptionalInt getMaxScore(List<Result> results) {
        return  results.stream().mapToInt(Result::getScore).max();
    }

    public Optional<Result> getMaxGame(List<Result> results) {
        return results.stream().max(Comparator.comparingInt(Result::getScore));
    }

    public void printGames(LocalDate localDate, int days) {
        CompletableFuture<List<Result>> future =
                CompletableFuture.supplyAsync(new GamePageLinkSupplier(localDate, days))
                .thenApply(new BoxscoreRetriever());
        CompletableFuture<Void> futureWrite =
                future.thenAcceptAsync(this::saveResultList)
                        .exceptionally(ex -> {
                            ex.printStackTrace();
                            return null;
                        });
        CompletableFuture<OptionalInt> futureMaxScore = future.thenApplyAsync(this::getMaxScore);
        CompletableFuture<Optional<Result>> futureMaxGame = future.thenApplyAsync(this::getMaxGame);
        CompletableFuture<String> futureMax = futureMaxGame.thenCombineAsync(futureMaxScore, (game, score) -> String.format("Highest score: %d, Max game: %s", score.orElse(0), game.orElse(null)));
        CompletableFuture.allOf(futureWrite, futureMax).join();
        future.join().forEach(System.out::println);
        System.out.println(futureMax.join());

    }

}
