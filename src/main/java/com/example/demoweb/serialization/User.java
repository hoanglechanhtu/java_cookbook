package com.example.demoweb.serialization;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    List<String>  habits;
    Position position;
    public List<String> getHabits() {
        return habits;
    }

    public void setHabits(List<String> habits) {
        this.habits = habits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, String name, List<String> habits) {
        this.id = id;
        this.name = name;
        this.habits = habits;
        Random random = new Random();
        position = new Position(random.nextInt(100), random.nextInt(100));
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", habits=" + habits +
                ", position=" + position +
                '}';
    }
}
