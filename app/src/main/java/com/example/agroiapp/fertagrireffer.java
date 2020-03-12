package com.example.agroiapp;

public class fertagrireffer {
    String ferrstbuyid;
    String ferrtusrid;
    String ferrtname;
    String ferrtaddress;
    String ferrtpincode;
    String ferrtphno;
    String ferrtproid;

    public fertagrireffer() {

    }

    public fertagrireffer(String ferrstbuyid, String ferrtusrid, String ferrtname, String ferrtaddress, String ferrtpincode, String ferrtphno, String ferrtproid) {
        this.ferrstbuyid = ferrstbuyid;
        this.ferrtusrid = ferrtusrid;
        this.ferrtname = ferrtname;
        this.ferrtaddress = ferrtaddress;
        this.ferrtpincode = ferrtpincode;
        this.ferrtphno = ferrtphno;
        this.ferrtproid = ferrtproid;
    }

    public String getFerrstbuyid() {
        return ferrstbuyid;
    }

    public String getFerrtusrid() {
        return ferrtusrid;
    }

    public String getFerrtname() {
        return ferrtname;
    }

    public String getFerrtaddress() {
        return ferrtaddress;
    }

    public String getFerrtpincode() {
        return ferrtpincode;
    }

    public String getFerrtphno() {
        return ferrtphno;
    }

    public String getFerrtproid() {
        return ferrtproid;
    }
}