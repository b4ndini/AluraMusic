package com.lfelipe.alura.music.util;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Converter {

    public static <T> T getObject(String data, Class<T> classType) {
        try {
            return Mapper.getInstance().readValue(data, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
