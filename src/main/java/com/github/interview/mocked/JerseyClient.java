package com.github.interview.mocked;

public class JerseyClient implements AutoCloseable {

    public WebTarget target(String baseUrl) {
        return new WebTarget();
    }

    @Override
    public void close() throws RuntimeException {
        // release resources
    }
}
