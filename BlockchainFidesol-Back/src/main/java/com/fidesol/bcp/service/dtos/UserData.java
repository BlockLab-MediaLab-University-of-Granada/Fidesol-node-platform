package com.fidesol.bcp.service.dtos;

public class UserData {

    private String username;
    private String password;


    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserData() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
