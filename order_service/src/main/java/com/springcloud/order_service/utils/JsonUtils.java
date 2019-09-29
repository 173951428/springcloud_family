package com.springcloud.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    private  static final ObjectMapper objectMappper=new ObjectMapper();

    public  static JsonNode strToJsonNode(String str){
        try {
            return  objectMappper.readTree(str);
        } catch (IOException e) {
           return null;
        }
    }
}
