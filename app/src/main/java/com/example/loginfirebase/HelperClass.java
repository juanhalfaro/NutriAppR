package com.example.loginfirebase;

public class HelperClass {
    String name, email, username, password;

    public String getName(){
        return name;
    }

    public String setName(){
        this.name = name;
        return null;
    }

    public String getEmail(){
        return email;
    }

    public String setEmail(){
        this.email = email;
        return null;
    }

    public String getUsername(){
        return username;
    }

    public String setUsername(){
        this.username = username;
        return null;
    }

    public String getPassword(){
        return password;
    }

    public String setPassword(){
        this.password = password;
        return null;
    }

    public HelperClass(String name, String email, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public HelperClass(){

    }
}
