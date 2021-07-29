package com.udacity.jwdnd.course1.cloudstorage.services;
import java.util.List;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private FileMapper fileMapper;
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void addFile(Files file){
        fileMapper.insert(file);
        System.out.println("File is Submitted File is Submitted File is Submitted File is Submitted File is Submitted ");
    }
    public List<Files> getFiles(){ return fileMapper.getFile();}
}
