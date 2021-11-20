package com.example.blooddonation;

public class Mainmodel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mainmodel(String name, String blood, String email) {
        this.name = name;
        this.blood = blood;
        this.email = email;
    }
Mainmodel(){}
    String name, blood, email;

}
