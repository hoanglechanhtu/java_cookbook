package com.example.demoweb.serialization;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class User implements Serializable {
    public User() {
    }

    private static final long serialVersionUID = 1L;
    int id;
    String name;
    List<String>  habits;
    List<User> friends;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", habits=" + habits +
                ", friends=" + friends +
                ", position=" + position +
                '}';
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public User(int id, String name, List<String> habits, List<User> friends) {
        this.id = id;
        this.name = name;
        this.habits = habits;
        this.friends = friends;
        Random random = new Random();
        position = new Position(random.nextInt(100), random.nextInt(100));
    }

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

}
