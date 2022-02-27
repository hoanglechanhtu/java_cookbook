package com.example.demoweb.completable.future;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BoxscoreRetriever implements Function<List<String>, List<Result>> {
    Logger logger = Logger.getLogger(this.getClass().getName());
    public Optional<Result> gamePattern2Result(String pattern) {
        try {
            logger.info(String.format("Get result for %s", pattern));
            Thread.sleep(100);
            Random random = new Random();
            logger.info(String.format("Finish get result for %s", pattern));
            return Optional.of(new Result(pattern, random.nextInt(100)));
        } catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Result> apply(List<String> list) {
        return list.parallelStream()
                .map(this::gamePattern2Result)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
