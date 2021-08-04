package com.key.value.store.util;

public class StringUtils {
    /*
        Utility to remove new line characters from json string
     */
    public static String sanitize(String str){
        return str.replaceAll("[\\n\\r]", "");
    }
}
