package com.example.demoweb.serialization;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaNativeSerializeTest {
    SerializeTest javaNativeSerialize = new JavaNativeSerialize();
    @Test
    void test() {
        String path = "./native.txt";
        User expected = new User(1, "Alex", List.of("Football", "Video game"));
        javaNativeSerialize.serialize(expected, path);
        User res = javaNativeSerialize.deserialize(path);
        assertEquals(expected.id, res.id);
        assertEquals(expected.name, res.name);
        assertEquals(String.join("-", expected.habits), String.join("-", res.habits));
        System.out.println(res);
    }
}