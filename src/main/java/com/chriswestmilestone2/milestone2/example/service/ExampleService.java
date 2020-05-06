package com.chriswestmilestone2.milestone2.example.service;

import com.chriswestmilestone2.milestone2.example.dto.ExampleDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExampleService {

    public String handleExampleWithRequestParam(String param) {
        return "Hello " + param;
    }

    // This just combines the request body and returns it as a map
    public HashMap<String, String> handleExampleWithBody(ExampleDTO exampleDTO) {
        String result = exampleDTO.getName()+exampleDTO.getMessage()+exampleDTO.getSomeNumber();
        HashMap<String, String> map = new HashMap<>();
        map.put("value", result);
        return map;
    }
}
