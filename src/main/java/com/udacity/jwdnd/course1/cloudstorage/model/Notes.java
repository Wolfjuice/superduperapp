package com.udacity.jwdnd.course1.cloudstorage.model;

public class Notes {
    private Integer credentialid;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userid;

    public Notes(Integer credentialid, String url, String username, String key, String password, Integer userid) {
        this.credentialid = credentialid;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
        this.userid = userid;
    }
    public Integer getCredentialId(){
        return this.credentialid;
    }
    public void setCredentialId(Integer credentialid) {
        this.credentialid = credentialid;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getKey(){
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUserId(){
        return this.userid;
    }
    public void setUserId(Integer userid) {
        this.userid = userid;
    }

}
