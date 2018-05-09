package com.example.a16_0128.resourcehub;

public class AddUser {
    private String name;
    private String email;
    private String major;
    private String password;

    public AddUser(){}

    public AddUser(String name, String email, String major, String password){
        this.name=name;
        this.email=email;
        this.major=major;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}


    //public void signRecord(final String name, final String email, final String major, final String password){}