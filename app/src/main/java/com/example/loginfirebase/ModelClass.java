package com.example.loginfirebase;

import android.graphics.Bitmap;
public class ModelClass {
    private String name, email;
    private Bitmap image;

    public ModelClass(String name, String email, Bitmap image){
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }

    public Bitmap getImage(){
        return image;
    }
    public void setImage(){
        this.image = image;
    }

}
