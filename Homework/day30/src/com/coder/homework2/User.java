package com.coder.homework2;

public class User {
    @Login("userAdmin")
    String userName;
    @Login("1314520")
    String pwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
