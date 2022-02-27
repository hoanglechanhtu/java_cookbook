package com.example.demoweb.serialization;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GsonSerializeTest {
    SerializeTest gson = new GsonSerialize();
    @Test
    void test() {
        String path = "./native.txt";
        User friend = new User(2, "Timor",  List.of("Football", "Video game", "Manga"));
        User expected = new User(1, "Alex", List.of("Football", "Video game"), List.of(friend));
        gson.serialize(expected, path);
        User res = gson.deserialize(path);
        assertEquals(expected.id, res.id);
        assertEquals(expected.name, res.name);
        assertEquals(String.join("-", expected.habits), String.join("-", res.habits));
        System.out.println(res);
    }
}