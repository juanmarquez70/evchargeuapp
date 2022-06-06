package com.example.evchargeufirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        TextView loginUsername = (TextView) findViewById(R.id.loginUsername);
        TextView loginPassword = (TextView) findViewById(R.id.loginPassword);

        Button loginBtn = (Button) findViewById(R.id.loginButton);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginUsername.getText().toString().equals("admin") && loginPassword.getText().toString().equals("admin")){
                    //Successful login
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

                    goToBilling();

                }else
                    //Incorrect login
                Toast.makeText(LoginActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void goToBilling(){
        Intent intent = new Intent(LoginActivity.this, Billing.class);
        startActivity(intent);
        finish();
    }
}
