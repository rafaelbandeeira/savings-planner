package org.config;

import java.util.Objects;

public abstract class App {
    private static final String DEV_SAVING_PLANNER = "http://qa-assignment.useorigin.com.s3-website-us-east-1.amazonaws.com/";
    private static final String PROD_SAVING_PLANNER = "";

    public static String getAppUrl() {
        if (Objects.equals(System.getenv("ENV"), "PROD"))
            return PROD_SAVING_PLANNER;
        return DEV_SAVING_PLANNER;
    }
}
