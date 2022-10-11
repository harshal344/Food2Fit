package com.example.database;

public class userInfo {

    private String userName;

    private String userAge;

    private String userGender;

    public userInfo() {

    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setuserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setuserGender(String userGender) {
        this.userGender = userGender;
    }
}

