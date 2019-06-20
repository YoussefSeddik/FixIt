package com.seddik.youssef.fixit.javaActivities;



import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.seddik.youssef.fixit.Apicall;
import com.seddik.youssef.fixit.R;
import com.seddik.youssef.fixit.RetrofitInstance;
import com.seddik.youssef.fixit.modelClasses.LoginClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_name, password;
    private Button btnLogin;
    private TextView btnReg, btnForget;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }
    private void init(){
        user_name = findViewById(R.id.login_user_name);
        password = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnReg = findViewById(R.id.btn_register);
        btnForget = findViewById(R.id.btn_forget_password);

        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);
        btnForget.setOnClickListener(this);

    }

    public void signUp() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);

    }


    public void logIn() {
        String name = user_name.getText().toString();
        String pass = password.getText().toString();
        if (name.equals("")) {
            user_name.setError("Enter Name");

        } else if (pass.equals("")) {
            password.setError("Enter Password");

        } else if (!name.equals(null) && !password.equals(null)) {
            if (name.matches("youssefseddik") && pass.matches("12341234")) {
                startActivity(new Intent(LoginActivity.this,WorkersList.class));
            }else {
                Toast.makeText(LoginActivity.this, "Not found", Toast.LENGTH_SHORT).show();

            }
        }
        }

//            Apicall retrofitInstance = RetrofitInstance.getRetrofitInstance().create(Apicall.class);
//
//            Call<LoginClass> call = retrofitInstance.getLoginStatus(name, pass);
//
//            call.enqueue(new Callback<LoginClass>() {
//                @Override
//                public void onResponse(Call<LoginClass> call, Response<LoginClass> response) {
//                    LoginClass loginClass = response.body();
//                    String respons = loginClass.get_Response();
//                    Toast.makeText(LoginActivity.this, "Response : " + respons, Toast.LENGTH_SHORT).show();
//                    if(respons.equals("login success")){
//                        startActivity(new Intent(LoginActivity.this,WorkersList.class));
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginClass> call, Throwable t) {
//
//                }
//            });
//
//        }




    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are You Sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.btn_forget_password) {
//            startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
//            finish();
//        } else
        if (v.getId() == R.id.btn_register) {
            signUp();
        }
        else if (v.getId() == R.id.btn_login) {
            logIn();
        }

    }
}