package com.pierre.api_rest_with_spring_3.controllers;


import com.pierre.api_rest_with_spring_3.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String tamplate = " Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(

            @RequestParam(value = "name", defaultValue = "Word")
            String name) {
    return new Greeting(counter.incrementAndGet(), String.format(tamplate, name));
    }
}
