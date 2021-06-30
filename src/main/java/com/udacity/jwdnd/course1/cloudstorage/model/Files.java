package com.udacity.jwdnd.course1.cloudstorage.model;

public class Files {
    private Integer fileid;
    private String filename;
    private String contenttype;
    private String filesize;
    private Integer userid;
    private String filedata; // BLOB


    public Files(Integer fileid, String filename, String contenttype, String filesize, Integer userid, String filedata) {
        this.fileid = fileid;
        this.filename = filename;
        this.contenttype = contenttype;
        this.filesize = filesize;
        this.userid = userid;
        this.filedata = filedata;
    }
    public Integer getFileid(){
        return this.fileid;
    }
    public void setFileid(Integer fileid) { this.fileid = fileid;}

    public String getFilename(){
        return this.filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContenttype(){
        return this.contenttype;
    }
    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getFilesize(){
        return this.filesize;
    }
    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public Integer getUserId(){
        return this.userid;
    }
    public void setUserId(Integer userid) {
        this.userid = userid;
    }

    public String getFiledata(){
        return this.filedata;
    }
    public void setFiledata(String filedata) {
        this.filedata = filedata;
    }

}
