package com.enola.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.enola.myapps.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {
    private ActivityLogInBinding binding;
    private final String EMAIL = "test@gmail.com";
    private final String PASSWORD = "1234";
    private EditText etEmail, etPassword;
    private Button btLogin,btExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        initListener();

    }
    private void initUi(){

        etEmail= findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        btExit = findViewById(R.id.btExit);
    }

    private void initListener(){
        btLogin.setOnClickListener(v -> login());
        btExit.setOnClickListener(v -> exit());
    }
    private void exit(){
        finish();
    }
    private void login(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if(email.equals(EMAIL) && password.equals(PASSWORD)){
            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            if(!email.equals(EMAIL)){
                Toast.makeText(this,"Wrong Email",Toast.LENGTH_LONG).show();
            }
            if(!password.equals(PASSWORD)){
                Toast.makeText(this,"Wrong Password",Toast.LENGTH_LONG).show();
            }

        }
    }
}