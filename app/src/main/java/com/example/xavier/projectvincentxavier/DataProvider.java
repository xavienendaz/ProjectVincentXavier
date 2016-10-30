package com.example.xavier.projectvincentxavier;

/**
 * Created by Xavier on 30.10.2016.
 */

public class DataProvider {

    private String username;
    private String password;

    public DataProvider(String username, String password){
        this.username=username;
        this.password=password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
