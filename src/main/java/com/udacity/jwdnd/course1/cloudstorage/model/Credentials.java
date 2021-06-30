package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credentials {
    private Integer noteid;
    private String notetitle;
    private String notedescription;
    private Integer userid;

    public Credentials(Integer noteid, String notetitle, String notedescription, Integer userid) {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }


    public Integer getNoteid(){
        return this.noteid;
    }
    public void setNoteid(Integer noteid) { this.noteid = noteid;}

    public String getNotetitle(){
        return this.notetitle;
    }
    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription(){
        return this.notedescription;
    }
    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public Integer getUserId(){
        return this.userid;
    }
    public void setUserId(Integer userid) {
        this.userid = userid;
    }
}
