package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/home")
public class HomeController {
    private UserService userService;
    private NoteService noteService;
    public HomeController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }
    @GetMapping()
    public String getHomePage(Model model) {
        model.addAttribute("noteForm",new NoteForm());
        model.addAttribute("credentialForm",new CredentialForm());
        return "home";
    }

    @PostMapping()
    public String sendData(Authentication authentication, NoteForm noteForm, Model model) {
        Users targetuser = this.userService.getUser(authentication.getName());
        noteForm.setId(targetuser.getUserId());
        this.noteService.addNote(noteForm);
        return "home";
    }
}
