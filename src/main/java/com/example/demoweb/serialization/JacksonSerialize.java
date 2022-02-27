package com.example.demoweb.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonSerialize implements SerializeTest{
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(User user, String path) {
        File file = new File(path);
        try {
            objectMapper.writeValue(file, user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User deserialize(String path) {
        try {
            return objectMapper.readValue(new File(path), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
