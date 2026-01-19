package com.example.revision;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class revise {
    @GetMapping

    public String hello(){
        return "hello world";
    }

    @GetMapping("/north")
    public String ramram(){
        return "ram ram";
    }

    @GetMapping("/south")
    public String vanakkam(){
        return "vanakkam";
    }
}
