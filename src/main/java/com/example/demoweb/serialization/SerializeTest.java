package com.example.demoweb.serialization;

public interface SerializeTest {
    void serialize(User user, String path);
    User deserialize(String path);
}
