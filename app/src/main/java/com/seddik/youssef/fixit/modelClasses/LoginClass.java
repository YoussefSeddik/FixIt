package com.seddik.youssef.fixit.modelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by youssef on 16/7/2018.
 */

public class LoginClass {

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("response")
    private String response;

    public String get_Name() {
        return name;
    }

    public String get_Password() {
        return password;
    }

    public String get_Response() {
        return response;
    }

}
