package com.kevin.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logging")
    public String logging() {
        logger.info("INFO");
        logger.warn("WARN");
        return "hello logback";
    }
}
