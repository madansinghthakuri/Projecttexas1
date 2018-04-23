package com.example.ironman.projecttexas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.Settings.Secure;


import com.example.ironman.projecttexas.Service.Api;
import com.example.ironman.projecttexas.Service.ApiClient;
import com.example.ironman.projecttexas.model.LoginDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText mUsername, mPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Define Component
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);

    }

    public void login(View view) {
        String deviceId = "hjggjhh";
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();


        LoginDto loginDto = new LoginDto(username, password, deviceId);


        //Calling Api using Retrofit for Login
        Api apiService =
                ApiClient.getClient().create(Api.class);
        Call<LoginDto> call = apiService.sendUsernameAndPassword(loginDto);
        ApiClient.getClient().create(Api.class);


        call.enqueue(new Callback<LoginDto>() {
            @Override
            public void onResponse(Call<LoginDto> call, Response<LoginDto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Login.this, "Login Sucessful", Toast.LENGTH_SHORT).show();

                    Intent welcomeActivity = new Intent(Login.this, Welcome.class);
                    finish();
                    startActivity(welcomeActivity);


                } else {
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginDto> call, Throwable t) {
                Toast.makeText(Login.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        /*call.enqueue(new Callback<LoginDto>() {
            @Override
            public void onResponse(Call<LoginDto> call, Response<LoginDto> response) {

                //Executed when Response is Success
                if (response.isSuccessful()) {


                } else {

                }
            }

            @Override
            public void onFailure(Call<LoginDto> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

}
