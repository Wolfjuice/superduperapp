package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
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
    private CredentialService credentialService;

    public HomeController(UserService userService, NoteService noteService, CredentialService credentialService) {
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }
    @GetMapping()
    public String getHomePage(Model model) {
//        model.addAttribute("noteForm",new NoteForm());
//        model.addAttribute("credentialForm",new CredentialForm());
        return "home";
    }

    @PostMapping()
    public String sendData(Authentication authentication, NoteForm noteForm, CredentialForm credentialForm, Model model) {
        System.out.println(noteForm.getTitle());
        System.out.println(noteForm.getDescription());
        System.out.println(credentialForm.getUrl());
        System.out.println(credentialForm.getUsername());
        System.out.println(credentialForm.getPassword());
        if(noteForm.getDescription() != null || noteForm.getTitle() != null){
            Users targetuser = this.userService.getUser(authentication.getName());
            noteForm.setId(targetuser.getUserId());
            this.noteService.addNote(noteForm);
            noteForm.setTitle("");
            noteForm.setDescription("");
//        System.out.print(this.noteService.getNotes().size());
//        System.out.print("Sweet");
            System.out.println("Bitter");
            return "home";
        }
        if(credentialForm.getUrl() != null && credentialForm.getUsername() != null && credentialForm.getPassword() != null){
            Users targetuser = this.userService.getUser(authentication.getName());
            credentialForm.setId(targetuser.getUserId());
            this.credentialService.addCredential(credentialForm);
            credentialForm.setPassword("");
            credentialForm.setUsername("");
            credentialForm.setUrl("");
            System.out.println("Sweet");
            return "home";
        }
        return "home";

    }
    @ModelAttribute("credentialForm")
    public CredentialForm getCredentialForm(){
        return new CredentialForm();
    }
    @ModelAttribute("noteForm")
    public NoteForm getNoteForm(){
        return new NoteForm();
    }
}
