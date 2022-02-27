package com.example.demoweb.serialization;

import org.w3c.dom.Text;

import java.io.*;

public class JavaNativeSerialize implements SerializeTest {
    //Entity class need to implement Serializable
    //And need to have serialVersionUID
    public void serialize(User user, String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user);
        } catch (Exception ignored) {

        }
    }

    public User deserialize(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (User) objectInputStream.readObject();
        } catch (Exception ignored) {

        }
        return null;
    }

}
