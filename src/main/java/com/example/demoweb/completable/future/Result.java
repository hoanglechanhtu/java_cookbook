package com.example.demoweb.completable.future;

public class Result {
    String result;
    int score;
    public Result(String result, int score) {
        this.result = result;
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("Game %s %d", result, score);
    }
}
