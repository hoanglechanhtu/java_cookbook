package com.example.demoweb.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class GsonSerialize implements SerializeTest{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void serialize(User user, String path) {
        try(Writer writer = new FileWriter(path)) {
            gson.toJson(user, writer);
        } catch (Exception ignored) {

        }
    }

    @Override
    public User deserialize(String path) {
        try(Reader reader = new FileReader(path)) {
            return gson.fromJson(reader, User.class);
        } catch (Exception ignored) {

        }
        return null;
    }
}
