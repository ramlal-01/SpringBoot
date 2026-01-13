package com.example.Day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/")
    public String  sayHello() {
        return "Hello World";
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Namaste";
    }

    @GetMapping("/braj")
    public String braj(){
        return "radhe radhe";
    }

    @GetMapping("/south")
    public String south(){
        return "vanakkam";
    }
}
