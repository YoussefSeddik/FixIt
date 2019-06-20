package com.seddik.youssef.fixit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by youssef on 16/7/2018.
 */

public class RetrofitInstance {

        public static  String  BASE_URL = "http://10.0.2.2/FixIt/";
        public static Retrofit retrofit = null;



        public static Retrofit getRetrofitInstance(){
            if(retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();


            }
            return retrofit;
        }


}
