package com.example.AppForPractice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinuxController {
    @GetMapping("/linux")
    public String WelcomeMsg(){
     return "Welcome to my application";
}
}
