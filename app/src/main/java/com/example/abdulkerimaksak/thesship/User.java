package com.example.abdulkerimaksak.thesship;

public class User {

    public String ID;
    public String userName;
    public String userSurname;
    public String userUniversity;
    public String userSection;
    public String userClass;
    public String userMail;
    public String userPassword;
    public String Onaylama;

    public User(){

    }

    public User(String userName, String userSurname, String userUniversity, String userSection, String userClass, String userMail, String userPassword) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userUniversity = userUniversity;
        this.userSection = userSection;
        this.userClass = userClass;
        this.userMail = userMail;
        this.userPassword = userPassword;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        ID = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserUniversity() {
        return userUniversity;
    }

    public void setUserUniversity(String userUniversity) {
        this.userUniversity = userUniversity;
    }

    public String getUserSection() {
        return userSection;
    }

    public void setUserSection(String userSection) {
        this.userSection = userSection;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOnaylama() {
        return Onaylama;
    }

    public void setOnaylama(String onaylama) {
        Onaylama = onaylama;
    }

}
