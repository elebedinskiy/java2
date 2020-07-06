package ru.elebedinskiy.java2.client;

@FunctionalInterface
public interface Callback {
    void callback(Object... args);
}