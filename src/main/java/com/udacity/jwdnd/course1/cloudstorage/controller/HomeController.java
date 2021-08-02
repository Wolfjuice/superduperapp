package com.udacity.jwdnd.course1.cloudstorage.controller;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private FileService fileService;
    private UserService userService;
    private NoteService noteService;
    private CredentialService credentialService;

    public HomeController(UserService userService, NoteService noteService, CredentialService credentialService, FileService fileService) {
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.fileService = fileService;
    }
    @GetMapping()
    public String getHomePage(Model model) {
//        model.addAttribute("noteForm",new NoteForm());
//        model.addAttribute("credentialForm",new CredentialForm());
        return "home";
    }

    @PostMapping()
    public String sendData(Authentication authentication, FileForm fileForm, NoteForm noteForm, CredentialForm credentialForm, Model model) {
        System.out.println(noteForm.getTitle());
        System.out.println(noteForm.getDescription());
        System.out.println(credentialForm.getUrl());
        System.out.println(credentialForm.getUsername());
        System.out.println(credentialForm.getPassword());
        if(noteForm.getDescription() != null || noteForm.getTitle() != null){
            if(noteForm.getId() == null){
                Users targetuser = this.userService.getUser(authentication.getName());
                noteForm.setUId(targetuser.getUserId());
                this.noteService.addNote(noteForm);
                noteForm.setTitle("");
                noteForm.setDescription("");
                model.addAttribute("noteList", this.noteService.getNotes());
                model.addAttribute("fileList", this.fileService.getFiles());
                model.addAttribute("credentialList", this.credentialService.getCredentials());
                System.out.println("Bitter");
                return "home";
            }
            else{
                // Note needs to be updated
                System.out.println("NOTE ID: " + noteForm.getId());
                System.out.println("NOTE TITLE: " + noteForm.getTitle());
                System.out.println("NOTE DESCRIPTION: " + noteForm.getDescription());
                Users targetuser = this.userService.getUser(authentication.getName());
                noteForm.setUId(targetuser.getUserId());
                this.noteService.updateNote(noteForm);
                noteForm.setTitle("");
                noteForm.setDescription("");
                model.addAttribute("noteList", this.noteService.getNotes());
                model.addAttribute("fileList", this.fileService.getFiles());
                model.addAttribute("credentialList", this.credentialService.getCredentials());
                return "home";
            }

        }
        if(credentialForm.getUrl() != null && credentialForm.getUsername() != null && credentialForm.getPassword() != null){
            if(credentialForm.getCId() == null){
                Users targetuser = this.userService.getUser(authentication.getName());
                credentialForm.setId(targetuser.getUserId());
                this.credentialService.addCredential(credentialForm);
                credentialForm.setPassword("");
                credentialForm.setUsername("");
                credentialForm.setUrl("");
                model.addAttribute("credentialList", this.credentialService.getCredentials());
                model.addAttribute("fileList", this.fileService.getFiles());
                model.addAttribute("noteList", this.noteService.getNotes());
                System.out.println("Sweet");
                return "home";
            }
            else{
                model.addAttribute("credentialList", this.credentialService.getCredentials());
                model.addAttribute("fileList", this.fileService.getFiles());
                model.addAttribute("noteList", this.noteService.getNotes());
                return "home";
            }


        }

        if(fileForm.getFileUpload() != null){
            try {
                String filename = fileForm.getFileUpload().getOriginalFilename();
                String contentType = fileForm.getFileUpload().getContentType();
                byte[] fileBytes = fileForm.getFileUpload().getBytes();
                String fileSize = String.valueOf(fileForm.getFileUpload().getSize());
                int userId = this.userService.getUser(authentication.getName()).getUserId();

                System.out.println("======= FILE INFO =======");
                System.out.println("FILENAME: " + filename);
                System.out.println("CONTENT-TYPE: " + contentType);
                System.out.println("FILE BYTES: " + fileBytes.length);
                System.out.println("FILE SIZE: " + fileSize);
                System.out.println("USER ID: " + userId);

                Files file = new Files(null, filename, contentType, fileSize, userId, fileBytes);
                this.fileService.addFile(file);
                System.out.println(fileBytes);
                model.addAttribute("fileList", this.fileService.getFiles());
                model.addAttribute("noteList", this.noteService.getNotes());
                model.addAttribute("credentialList", this.credentialService.getCredentials());

            } catch(IOException ioException){
                System.out.println(ioException.getMessage());
            }
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
    @ModelAttribute("fileForm")
    public FileForm getFileForm(){
        return new FileForm();
    }
    @ModelAttribute("oneFile")
    public Files getAFile(){
        return new Files();
    }

    @ModelAttribute("credentialList")
    public List<Credentials> CredList(){
        return this.credentialService.getCredentials();
    }

    @ModelAttribute("noteList")
    public List<Notes> NoteList(){
        return this.noteService.getNotes();
    }

    @ModelAttribute("fileList")
    public List<Files> FileList(){
        return this.fileService.getFiles();
    }
}
