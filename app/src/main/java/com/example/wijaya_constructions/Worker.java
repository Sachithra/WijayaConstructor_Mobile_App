package com.example.wijaya_constructions;

public class Worker {
    private String firstname;
    private String lastname;
    private String phone;
    private String site;
    private String id;
    private String username;

    public Worker(String firstname, String lastname, String phone, String site, String id, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.site = site;
        this.id = id;
        this.username = username;
    }

    public Worker() {
        this.firstname = "";
        this.lastname = "";
        this.phone = "";
        this.site = "";
        this.id = "";
        this.username = "";

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
