package com.example.agroiapp;

public class pestagriref {

    String pesstbuyid;
    String pesstusrid;
    String pesstname;
    String pesstaddress;
    String pesstpincode;
    String pesstphno;
    String pestproid;

    public pestagriref(){

    }

    public pestagriref(String pesstbuyid,String pesstusrid, String pesstname, String pesstaddress, String pesstpincode, String pesstphno,String pestproid) {
        this.pesstbuyid=pesstbuyid;
        this.pesstusrid = pesstusrid;
        this.pesstname = pesstname;
        this.pesstaddress = pesstaddress;
        this.pesstpincode = pesstpincode;
        this.pesstphno = pesstphno;
        this.pestproid=pestproid;
    }

    public String getPesstbuyid(){
        return pesstbuyid;
    }

    public String getPesstusrid() {
        return pesstusrid;
    }

    public String getPesstname() {
        return pesstname;
    }

    public String getPesstaddress() {
        return pesstaddress;
    }

    public String getPesstpincode() {
        return pesstpincode;
    }

    public String getPesstphno() {
        return pesstphno;
    }

    public String getPestproid(){
        return pestproid;
    }
}
