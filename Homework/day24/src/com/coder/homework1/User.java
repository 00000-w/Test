package com.coder.homework1;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -864179356325008833L;
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
