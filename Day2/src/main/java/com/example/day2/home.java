package com.example.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//is for html

//@RestController is for json data .
public class home {

    @GetMapping
    public String home(){
        return "index";
    }
}
