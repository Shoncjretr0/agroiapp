package com.example.agroiapp;

public class valpass {
    String userid;

    public valpass(String userid){
        this.userid=userid;
    }

    public String getUserid() {
        if (userid!=null){
            return userid;
        }
        else {
            return userid="fg";
        }
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
