package com.example.demoweb.serialization;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonSerializeTest {
    SerializeTest jackson = new JacksonSerialize();

    @Test
    void serialize() {
        String path = "./native.txt";
        User friend = new User(2, "Timor",  List.of("Football", "Video game", "Manga"));
        User expected = new User(1, "Alex", List.of("Football", "Video game"), List.of(friend));
        jackson.serialize(expected, path);
        User res = jackson.deserialize(path);
        assertEquals(expected.id, res.id);
        assertEquals(expected.name, res.name);
        assertEquals(String.join("-", expected.habits), String.join("-", res.habits));
        System.out.println(res);
    }
}