package com.example.demoweb.completable.future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CompletableFutureExTest {
    CompletableFutureEx demo = new CompletableFutureEx();
    @Test
    void getProduct() throws ExecutionException, InterruptedException {
        Assertions.assertThrows(ExecutionException.class,() ->  demo.getProduct(666).get());
    }

    @Test
    public void testExceptionWithCause() throws Exception {
        try {
            demo.getProduct(666).get();
            fail("Houston, we have a problem...");
        } catch (ExecutionException e) {
            assertEquals(ExecutionException.class, e.getClass());
            assertEquals(RuntimeException.class, e.getCause().getClass());
        }
    }
    @Test
    public void testFutureGameLink() {
        demo.printGames(LocalDate.of(2022,1, 10), 3);
    }
}