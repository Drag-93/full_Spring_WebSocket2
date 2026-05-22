package org.spring.webSocket02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"","/index"})
    public String index(){
        return "index";
    }
//    @GetMapping("/chat")
//    public String chat(){
//        return "chat/index";
//    }
}
