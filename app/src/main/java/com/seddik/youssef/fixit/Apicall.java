package com.seddik.youssef.fixit;

import com.seddik.youssef.fixit.modelClasses.LoginClass;
import com.seddik.youssef.fixit.modelClasses.RegisterClass;
import com.seddik.youssef.fixit.modelClasses.WorkerClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by youssef on 16/7/2018.
 */

public interface Apicall {


    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterClass> getRegStatus(@Field("name") String name, @Field("email") String email , @Field("password") String password, @Field("phone") String phone, @Field("city") String city, @Field("area") String area);

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginClass> getLoginStatus(@Field("name") String name, @Field("password") String password);


    @POST("read_workers.php")
    Call<List<WorkerClass>>  getWorkers();

   }
