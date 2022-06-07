package com.solvd.laba.hospital.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static {
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Integer POOL_SIZE;
    private static String DRIVER;

    private static void loadProperties() throws IOException {
        Properties properties = new Properties();
        File file = new File("src/main/resources/db.properties");
        FileReader reader = new FileReader(file);
        properties.load(reader);
        URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASSWORD = properties.getProperty("db.password");
        POOL_SIZE = Integer.valueOf(properties.getProperty("db.poolSize"));
        DRIVER = properties.getProperty("db.driver");
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        Config.URL = URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Config.USER = USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Config.PASSWORD = PASSWORD;
    }

    public static Integer getPoolSize() {
        return POOL_SIZE;
    }

    public static void setPoolSize(Integer poolSize) {
        POOL_SIZE = poolSize;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        Config.DRIVER = DRIVER;
    }
}
