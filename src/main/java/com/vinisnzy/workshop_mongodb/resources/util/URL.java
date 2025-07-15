package com.vinisnzy.workshop_mongodb.resources.util;

public class URL {
    public static String decodeParam(String text) {
        return text.replace("+", " ");
    }

    public static String encodeParam(String text) {
        return text.replace(" ", "+");
    }
}
