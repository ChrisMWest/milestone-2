package com.chriswestmilestone2.milestone2.example.controller;

import com.chriswestmilestone2.milestone2.example.dto.ExampleDTO;
import com.chriswestmilestone2.milestone2.example.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @ResponseBody
    @GetMapping("/example")
    public String example() {
        log.info("Accessing /example");
        return "Hello World";
    }

    @ResponseBody
    @GetMapping("/example/param/{name}")
    public String exampleWithRequestParam(@PathVariable String name) {
        log.info("accessing /example/param");
        return exampleService.handleExampleWithRequestParam(name);
    }

    @ResponseBody
    @GetMapping("/example/body")
    public ResponseEntity<?> exampleWithBodyEndpoint(@RequestBody ExampleDTO exampleDTO) {
        log.info("accessing /example/body");
        Map<String, String> map = exampleService.handleExampleWithBody(exampleDTO);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
