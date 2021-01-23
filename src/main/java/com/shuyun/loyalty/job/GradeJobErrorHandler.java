package com.shuyun.loyalty.job;

import java.util.Properties;

public class GradeJobErrorHandler {
    public void handleException(String s, Throwable throwable) {
        throwable.printStackTrace();
    }

    public void init(Properties properties) {
    }

    public String getType() {
        return "LOG";
    }

    public void close() {

    }
}
