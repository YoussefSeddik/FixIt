package com.seddik.youssef.fixit.modelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by youssef on 16/7/2018.
 */

public class RegisterClass {
    @SerializedName("name")
    private String name;

    public String get_Name() {
        return name;
    }

    public String get_Email() {
        return email;
    }

    public String get_Password() {
        return password;
    }

    public String get_Phone() {
        return phone;
    }

    public String get_City() {
        return city;
    }

    public String get_Area() {
        return area;
    }

    public String get_response() {
        return response;
    }

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("phone")
    private String phone;

    @SerializedName("city")
    private String city;

    @SerializedName("area")
    private String area;

    @SerializedName("response")
    private String response;

}
