package com.udacity.jwdnd.course1.cloudstorage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getHomePage(Model model) {
        return "home";
    }
}
