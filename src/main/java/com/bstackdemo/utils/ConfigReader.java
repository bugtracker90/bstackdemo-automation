package com.bstackdemo.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {

        try {

            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                System.out.println("config.properties file NOT found");
            } else {
                prop.load(input);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {

        String value = prop.getProperty(key);

        if (value == null) {
            System.out.println("Property not found: " + key);
        }

        return value;
    }
}