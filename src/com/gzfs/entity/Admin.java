package com.gzfs.entity;

public class Admin {
    private Integer id;
    private String username;
    private String passowrd;

    public Admin(Integer id, String username, String passowrd) {
        this.id = id;
        this.username = username;
        this.passowrd = passowrd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
