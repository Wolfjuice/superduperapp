package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    private CredentialMapper credentialMapper;
    public CredentialService(CredentialMapper credentialMapper){this.credentialMapper = credentialMapper;}

    public void addCredential(CredentialForm cform){
        Credentials credential = new Credentials();
        credential.setKey("abc");
        credential.setUrl(cform.getUrl());
        credential.setUsername(cform.getUsername());
        credential.setPassword(cform.getPassword());
        credential.setUserId(cform.getUserId());
        credentialMapper.insert(credential);
    }
    public void updateCredential(CredentialForm cform){
        Credentials credential = new Credentials();
        credential.setKey("abc");
        credential.setUrl(cform.getUrl());
        credential.setUsername(cform.getUsername());
        credential.setPassword(cform.getPassword());
        credential.setUserId(cform.getUserId());
        credential.setCredentialid(cform.getId());
        credentialMapper.update(credential);
        System.out.println("Credential is updated");
    }

    public List<Credentials> getCredentials() {
        return credentialMapper.getCredentials();
    }
}
