package com.example.evchargeufirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView billInfo;
    TextView username;
    Button btnPay;

    String user = "JuanArango";
    String registeredUsers = "registeredusers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        username = findViewById(R.id.username);
        billInfo = findViewById(R.id.simpledata);
        btnPay = findViewById(R.id.btnPay);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                simpleText.setText(snapshot.child("names").child("user1").getValue(String.class));
//                simpleText.setText(snapshot.child("names").child("user4").child("yeah").getValue(String.class));
                username.setText(snapshot.child(registeredUsers).child(user).getKey());
                billInfo.setText("Your bill is: "+ snapshot.child(registeredUsers).child(user).child("bill").getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Payment to be processed!", Toast.LENGTH_SHORT).show();
//                openActivity2();

            }
        })
        ;

    }
//    public void openActivity2(){
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }
}