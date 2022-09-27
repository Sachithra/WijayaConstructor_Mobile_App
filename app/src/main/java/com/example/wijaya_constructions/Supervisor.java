package com.example.wijaya_constructions;

import android.widget.TextView;

public class Supervisor {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String site;
    private String uname;

    public Supervisor(String firstname, String lastname, String email, String phone, String site, String uname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = phone;
        this.site = site;
        this.uname = uname;
    }

    public Supervisor(String username, String password) {

        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.password = "";
        this.site = "";
        this.uname = "";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
