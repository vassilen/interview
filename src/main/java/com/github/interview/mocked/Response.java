package com.github.interview.mocked;

public class Response implements AutoCloseable {

    public <T> T readEntity(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Throwable ignored) {
            return null;
        }
    }

    @Override
    public void close() throws RuntimeException {

    }
}
