package com.example.clock.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController {
    
    @GetMapping("/time")
    public String getCurrentTime() {
        return  LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
