package com.example.cr7.model;

import java.io.Serializable;

/**
 * Created by huong.tx on 1/23/2018.
 */
public class User  implements Serializable {

    private String idUser;


    private String pass;


    private String fName;


    private String lName;

    private String birthday;

    private int gender;


    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", pass='" + pass + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    private String avatar;

    public User(String id, String pass, String fName, String lName, String birthday, int gender, String avatar) {
        this.idUser = id;
        this.pass = pass;
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User() {
        super();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

