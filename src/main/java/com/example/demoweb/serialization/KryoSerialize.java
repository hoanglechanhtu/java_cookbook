package com.example.demoweb.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class KryoSerialize implements SerializeTest {
    Kryo kryo;

    public KryoSerialize() {
        kryo = new Kryo();
        kryo.register(User.class);
    }

    @Override
    public void serialize(User user, String path) {
        try (Output output = new Output(new FileOutputStream(path))) {
            kryo.writeObject(output, user);
        } catch (Exception ignored) {

        }
    }

    @Override
    public User deserialize(String path) {
        try (Input input = new Input(new FileInputStream(path))) {
            return kryo.readObject(input, User.class);
        } catch (Exception ignored) {

        }
        return null;
    }
}
