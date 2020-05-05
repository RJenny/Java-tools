package com.storm.json.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;

public class JsonMapperUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static  {
        objectMapper.
                //查找Java8相关模块
                findAndRegisterModules().
                //处理字段
                setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NONE).
                //日期友好输出
                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).
                //反序列化自动忽略多余字段
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * json字符串转对象
     * @param jsonString
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonString, Class<T> tClass){
        try {
            return objectMapper.readValue(jsonString, tClass);
        } catch (IOException e) {
            throw new RuntimeException("json (" + jsonString + ") to object(" + tClass.getName() + ") exception", e);
        }
    }

    /**
     * json字符串转list
     * @param jsonString
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String jsonString, Class<T> tClass){
        try {
            return objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, tClass));
        } catch (IOException e) {
            throw new RuntimeException("json(" + jsonString + ") to list(" + tClass.getName() + ") exception.", e);
        }
    }

    /**
     * 对象转json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("object(" + object + ") to json exception.", e);
        }
    }
}
