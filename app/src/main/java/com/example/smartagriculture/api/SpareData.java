package com.example.smartagriculture.api;

import android.util.ArrayMap;

import java.util.Map;

/**
 * 存放临时数据和全局静态数据
 */
public class SpareData {

    public static final String USER_DATA = "user_data";
    public static final String USER_ID = "user_id";
    public static final String USER_PHONE = "user_phone";
    public static final String USER_PWD = "user_pwd";
    public static final String TOKEN = "token";
    public static final String POND_ID = "pond_id";
    public static final String INFO_TYPE = "type";

    private static Map<String, String> stringMap;
    private static Map<String, Integer> integerMap;
    private static Map<String, Object> objectMap;
    private static Map<String, Long> longMap;

    public static void putStringData(String key, String value){
        stringMap.put(key, value);
    }

    public static void putIntData(String key, int value){
        integerMap.put(key, value);
    }

    public static void putObjectData(String key, Object value){
        objectMap.put(key, value);
    }

    public static void putLongData(String key, long value){
        longMap.put(key, value);
    }

    public static String getStringData(String key){
        return stringMap.get(key);
    }

    public static Integer getIntData(String key){
        return integerMap.get(key);
    }

    public static Object getObjectData(String key){
        return objectMap.get(key);
    }

    public static Object getLongData(String key){
        return longMap.get(key);
    }

    public static void removeStringData(String value){
        stringMap.remove(value);
    }

    public static void removeIntData(String value){
        integerMap.remove(value);
    }

    public static void removeObjectData(String value){
        objectMap.remove(value);
    }

    public static void removeLongData(String value){
        longMap.remove(value);
    }

    public static void init(){
        stringMap = new ArrayMap<>();
        integerMap = new ArrayMap<>();
        objectMap = new ArrayMap<>();
        longMap = new ArrayMap<>();
    }

    public static void emptyMap(){
        stringMap.clear();
        integerMap.clear();
        objectMap.clear();
    }

    public static void destroy(){
        stringMap = null;
        integerMap = null;
        objectMap = null;
        longMap = null;
    }

}