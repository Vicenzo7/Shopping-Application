package com.vicenzo.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.sf.json.JSONObject;

import java.text.SimpleDateFormat;

public class JsonResponse {

    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static JSONObject setResponse(String status, Object ob,String message,String objectName) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",status);
        if (ob != null){
            jsonObject.put(objectName,toJson(ob));
        } else {
            jsonObject.put("message",message);
        }
        return jsonObject;
    }

    public static JSONObject setResponse(String status, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", message);

        return jsonObject;
    }

    public static String toJson(Object obj) throws  JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // Date formatter
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(new SimpleDateFormat(TIMESTAMP_FORMAT));

        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

        return mapper.writeValueAsString(obj);
    }
}
