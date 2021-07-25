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
        credential.setUserId(cform.getId());
        credentialMapper.insert(credential);
        System.out.println("Credential is Submitted, Credential is Submitted, Credential is Submitted, Credential is Submitted, Credential is Submitted");
    }

    public List<Credentials> getCredentials() {
        return credentialMapper.getCredentials();
    }
}
