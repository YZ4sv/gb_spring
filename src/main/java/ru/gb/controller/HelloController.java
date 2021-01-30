package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        //model.addAttribute("test", "here one else string");
        return "index";
    }
}
