package com.example.Assiment_java5.session01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/say-hello")
    public String sayHello() {
        return "hello";
    }
}
