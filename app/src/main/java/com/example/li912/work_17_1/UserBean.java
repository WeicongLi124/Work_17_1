package com.example.li912.work_17_1;

public class UserBean {
    public static UserBean user;
    private String name = "";
    private String mobile = "";
    private String userName = "";
    private String password = "";

    static {
        user = new UserBean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
