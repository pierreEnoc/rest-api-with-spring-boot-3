package com.pierre.api_rest_with_spring_3.controllers;


import com.pierre.api_rest_with_spring_3.serices.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestLogs {
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @GetMapping("/test")
    public String testlog() {
        logger.debug("this is an DEBUG log");
        logger.info("this is an INFO log");
        logger.warn("this is an WARN log");
        logger.error("this is an ERROR log");

        return "Logd genarated successfuly";
    }
}
