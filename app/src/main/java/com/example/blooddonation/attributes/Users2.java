package com.example.blooddonation.attributes;

public class Users2 {
    public Users2(String name, String blood, String phoneno ,String email,String message, String no){
        this.name = name;
        this.blood = blood;
        this.phoneno = phoneno;
        this.email = email;
        this.message = message;



    }
    public Users2(){}
    public Users2(String name, String blood, String phoneno,String email, String message){
        this.name = name;
        this.blood = blood;

        this.phoneno = phoneno;
        this.email = email;
        this.message = message;

    }

    public String getBlood(){
        return blood;
    }
    public void setBlood(){
        this.blood = blood;
    }
public String getMessage(){
        return message;
}
public void setMessage(){
        this.message = message;
}
    public String getphoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
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








    String blood;
    String message;
    String phoneno;
    String name;
    String email;


}
