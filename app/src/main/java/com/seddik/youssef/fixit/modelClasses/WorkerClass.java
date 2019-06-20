package com.seddik.youssef.fixit.modelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by youssef on 17/7/2018.
 */

public class WorkerClass {


    @SerializedName("name")
    private String name;

    public String get_Name() {
        return name;
    }

    public String get_Prof() {
        return prof;
    }

    public String get_Path() {
        return path;
    }

    @SerializedName("prof")
    private String prof;


    @SerializedName("path")
    private String path;
}
