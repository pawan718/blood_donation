package com.example.blooddonation.attributes;

public class Users {
    public Users(String name, String email, String phone_no, String password, String address, String bloodgroup, String city, String pan) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
        this.address = address;
        this.bloodgroup = bloodgroup;
        this.city = city;

    }
public  Users(){}

    public Users(String name, String email, String phone_no, String password,String address, String bloodgroup, String city) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
       this.address = address;
       this.bloodgroup = bloodgroup;
       this.city = city;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   public String getBloodgroup() { return bloodgroup;}
   public void setBloodgroup() { this.bloodgroup = bloodgroup;}

   public String getCity(){return city;}
   public void setCity(){ this.city = city;}

    String name , email , phone_no, password, address,bloodgroup, city ,pan;
}
