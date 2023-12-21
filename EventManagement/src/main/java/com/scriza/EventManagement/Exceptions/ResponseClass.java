package com.scriza.EventManagement.Exceptions;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseClass {
    public static ResponseEntity<Map<String, Object>> response(String message) {
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("message", message);
        successResponse.put("success", true);
        successResponse.put("status", "OK");
        return ResponseEntity.ok(successResponse);
    }

}
