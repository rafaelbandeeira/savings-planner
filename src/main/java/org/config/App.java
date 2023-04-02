package org.config;

import java.util.Objects;

public abstract class Application {
    public static final String DEV_SAVING_PLANNER = "http://qa-assignment.useorigin.com.s3-website-us-east-1.amazonaws.com/";
    public static final String PROD_SAVING_PLANNER = "";

    public static String getEnvApp() {
        if (Objects.equals(System.getenv("ENV"), "PROD"))
            return PROD_SAVING_PLANNER;
        return DEV_SAVING_PLANNER;
    }
}
