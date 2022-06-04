package com.example.evchargeufirebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView loginUsername = (TextView) findViewById(R.id.loginUsername);
        TextView loginPassword = (TextView) findViewById(R.id.loginPassword);

        Button loginBtn = (Button) findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginUsername.getText().toString().equals("admin") && loginPassword.getText().toString().equals("admin")){
                    //Successful login
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }else
                    //Incorrect login
                Toast.makeText(LoginActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
