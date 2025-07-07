package com.lfelipe.alura.music.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {

    private static final ObjectMapper INSTANCE = new ObjectMapper();

    private Mapper() {}

    public static ObjectMapper getInstance() {
        return INSTANCE;
    }

}
