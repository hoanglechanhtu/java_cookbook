package com.example.demoweb.serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaNativeSerializeTest {
    SerializeTest javaNativeSerialize = new JavaNativeSerialize();
    @Test
    void test() {
        String path = "./native.txt";
        User expected = new User(1, "Alex");
        javaNativeSerialize.serialize(expected, path);
        User res = javaNativeSerialize.deserialize(path);
        assertEquals(expected.id, res.id);
        assertEquals(expected.name, res.name);
    }
}