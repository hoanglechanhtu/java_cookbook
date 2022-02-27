package com.example.demoweb.completable.future;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePageLinkSupplier implements Supplier<List<String>> {
    private static final String link = "some link";
    private LocalDate startDay;
    private int days;

    public GamePageLinkSupplier(LocalDate startDay, int days) {
        this.startDay = startDay;
        this.days = days;
    }

    public List<String> getGamePageLink(LocalDate localDate) {
        return List.of(localDate.toString() + "test 1", localDate.toString() + "test 2", localDate.toString() + "test 3");
    }
    @Override
    public List<String> get() {
        return Stream
                .iterate(startDay, d -> d.plusDays(1))
                .limit(days)
                .map(this::getGamePageLink)
                .flatMap(list -> list.isEmpty() ? Stream.empty() : list.stream())
                .collect(Collectors.toList());
    }
}
