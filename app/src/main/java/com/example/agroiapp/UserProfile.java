package com.example.agroiapp;

public class UserProfile {
            public String userpincd;
            public String userEmail;
            public String userName;
            public String useraddr;
            public String userphno;

            public UserProfile(){
            }

            public UserProfile(String userpincd, String userEmail, String userName,String useraddr,String userphno ) {
                this.userpincd = userpincd;
                this.userEmail = userEmail;
                this.userName = userName;
                this.useraddr = useraddr;
                this.userphno = userphno;

            }

            public String getuserpincd() {
                return userpincd;
            }

            public void setuserpincd(String userpincd) {
                this.userpincd = userpincd;
            }

            public String getuserEmail() {
                return userEmail;
            }

            public void setuserEmail(String userEmail) {
                this.userEmail = userEmail;
            }

            public String getuseraddr() {
                return getuseraddr();
            }

            public void setuseraddr(String userName)
            {
                this.useraddr = useraddr;
            }

            public String getuserName() {

                return userName;

            }


            public void setuserName(String userName) {

                this.userName = userName;

            }
             public String getUserphno() {

             return userphno;

            }

            public void setUserphno(String userName) {
                this.userphno = userphno;


            }


        }

