package com.example.wijaya_constructions;

public class Attendance {
    private String username;
    private String present;
    private String absent;

    public Attendance(String username, String present, String absent) {
        this.username = username;
        this.present = present;
        this.absent = absent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }
}
