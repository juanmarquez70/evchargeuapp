package com.example.evchargeufirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity extends AppCompatActivity {

    TextView userSign;
    TextView passwordSign;
    TextView passwordConfirmSign;

    Button firstSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userSign = findViewById(R.id.signUpUsername);
        passwordSign = (TextView) findViewById(R.id.signUpPassword);
        passwordConfirmSign = (TextView) findViewById(R.id.signUpConfirmPassword);
        firstSignUpBtn = (Button) findViewById(R.id.buttonSignUp);

        firstSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userSign.getText().toString().equals("example") && passwordSign.getText().toString().equals("123") && passwordSign.getText().toString().equals(passwordConfirmSign.getText().toString())){
                    //Successful login
                    Toast.makeText(SignUpActivity.this, "USER SUCCESSFULLY CREATED", Toast.LENGTH_SHORT).show();

                    goToBilling();

                }
            }
        });
    }
    private void goToBilling(){
        Intent intent = new Intent(SignUpActivity.this, Billing.class);
        startActivity(intent);
        finish();
    }

}
