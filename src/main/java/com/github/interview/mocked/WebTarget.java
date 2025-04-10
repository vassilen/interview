package com.github.interview.mocked;

public class WebTarget {

    public WebTarget path(String path) {
        return this;
    }

    public WebTarget queryParam(String var1, Object... var2) {
        return this;
    }

    public InvocationBuilder request(String... var1) {
        return new InvocationBuilder();
    }
}
