package com.seddik.youssef.fixit.javaActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.seddik.youssef.fixit.Apicall;
import com.seddik.youssef.fixit.R;
import com.seddik.youssef.fixit.RetrofitInstance;
import com.seddik.youssef.fixit.modelClasses.RegisterClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText user_name, user_email , user_password , user_confirm_pass , user_phone;
    private Button btnSignUp;
    Spinner spinner_prof , spinner_city , spinner_area;
    String name,email,unconferm_passowrd,conferm_password,phone,city,area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        init();

    }
    private void init(){

        spinner_area = findViewById(R.id.sp_area);
        spinner_city = findViewById(R.id.sp_city);
        user_name = findViewById(R.id.user_name);
        btnSignUp = findViewById(R.id.btn_signup);
        user_email = findViewById(R.id.email);
        user_password = findViewById(R.id.password);
        user_confirm_pass = findViewById(R.id.confirm_password);
        user_phone = findViewById(R.id.phone_number);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void signup(View view) {


        name = user_name.getText().toString().trim();
        unconferm_passowrd = user_password.getText().toString().trim();
        email = user_email.getText().toString().trim();
        conferm_password = user_confirm_pass.getText().toString().trim();
        phone = user_phone.getText().toString().trim();
        city = spinner_city.getSelectedItem().toString().trim();
        area = spinner_area.getSelectedItem().toString().trim();
//
//
        if (TextUtils.isEmpty(name)) {
            user_name.setError("Enter user name!");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            user_email.setError("Enter email address!");
            return;
        }
        if (! (email.contains("@") && email.contains("."))) {
            user_email.setError("Email formate is wrong!");
            return;
        }
        if (TextUtils.isEmpty(unconferm_passowrd)) {
            user_password.setError("Enter password!");
            return;
        }
        if (unconferm_passowrd.length() < 8) {
            user_password.setError("Password too short, enter minimum 8 characters!");
            return;
        }
        if (TextUtils.isEmpty(conferm_password)) {
            user_confirm_pass.setError("Enter confirmation password!");
            return;
        }
        if (!unconferm_passowrd.equals(conferm_password)) {
            user_confirm_pass.setError("Reset confirmation password!");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            user_phone.setError("Enter phone number!");
            return;
        }
        if (city.equals("Select Country")) {
            Toast.makeText(this,"Choose your city!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (area.equals("Select Area")) {
            Toast.makeText(this,"Choose your area!",Toast.LENGTH_SHORT).show();
            return;
        }

        Apicall retrofitInstance = RetrofitInstance.getRetrofitInstance().create(Apicall.class);

        Call<RegisterClass> call = retrofitInstance.getRegStatus(name,email,conferm_password,phone,city,area);

        call.enqueue(new Callback<RegisterClass>() {
            @Override
            public void onResponse(Call<RegisterClass> call, Response<RegisterClass> response) {
                RegisterClass registerClass = response.body();
                String respons  =registerClass.get_response();
                Toast.makeText(RegisterActivity.this, "Response : " + respons, Toast.LENGTH_SHORT).show();
                if(respons.equals("register success")){
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
            }

            @Override
            public void onFailure(Call<RegisterClass> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Failer"+t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}
