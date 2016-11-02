package com.example.xavier.projectvincentxavier;

/**
 * Created by Xavier on 30.10.2016.
 */

public class DataProviderUser {

    private String username;
    private String password;

    public DataProviderUser(){}

    public DataProviderUser(String username, String password){
        this.username=username;
        this.password=password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
