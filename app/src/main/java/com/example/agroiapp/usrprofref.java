package com.example.agroiapp;

public class usrprofref {
    String usrproid;
    String usrproname;
    String usrproaddr;
    String usrproemail;
    String usrpropincd;
    String usrprophno;
    String usrprousertyp;
    String usrpicurl;

    public usrprofref(){

    }

    public usrprofref(String usrproid,String usrproname, String usrproaddr, String usrproemail, String usrpropincd, String usrprophno, String usrprousertyp,String usrpicurl) {
        this.usrproid= usrproid;
        this.usrproname = usrproname;
        this.usrproaddr = usrproaddr;
        this.usrproemail = usrproemail;
        this.usrpropincd = usrpropincd;
        this.usrprophno = usrprophno;
        this.usrprousertyp = usrprousertyp;
        this.usrpicurl=usrpicurl;
    }
    public String getUsrproid() {
        return usrproid;
    }


    public String getUsrproname() {
        return usrproname;
    }

    public String getUsrproaddr() {
        return usrproaddr;
    }

    public String getUsrproemail() {
        return usrproemail;
    }

    public String getUsrpropincd() {
        return usrpropincd;
    }

    public String getUsrprophno() {
        return usrprophno;
    }

    public String getUsrprousertyp() {
        return usrprousertyp;
    }
    public String getUsrpicurl() {
        return usrpicurl;
    }
}
