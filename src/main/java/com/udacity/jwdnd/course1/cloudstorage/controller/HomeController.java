package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping()
    public String getHomePage(Model model) {
        return "home";
    }

    @PostMapping()
    public String sendData(Authentication authentication, NoteForm noteForm, Model model) {
        noteForm.setUsername(authentication.getName());

        return "home";
    }
}
