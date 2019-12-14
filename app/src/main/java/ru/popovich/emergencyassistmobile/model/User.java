package ru.popovich.emergencyassistmobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class User {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("middlename")
    @Expose
    private String middlename;

    @SerializedName("lastname")
    @Expose
    private String lastname;

    @Expose
    private boolean enable = true;

    @SerializedName("email")
    @Expose
    private String email;

    public User() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
