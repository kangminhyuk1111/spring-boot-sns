package com.fastcampus.sns.controller.request;

public class UserJoinRequest {

    String username;
    String password;

    public UserJoinRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
