package com.example.evchargeufirebase;


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

public class Billing extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView billInfo;
    TextView username;
    Button btnPay;

//    String user = "JuanArango";
//    String registeredUsers = "registeredusers";

    String path = "Accounts";
    String account = "id01";
    String name = "Name";
//    String password = "Password";
//    String username = "Username";
    String bill = "bill";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        username = findViewById(R.id.username);
        billInfo = findViewById(R.id.simpledata);
        btnPay = findViewById(R.id.btnPay);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               username.setText(snapshot.child(path).child(account).child(name).getValue().toString());
               billInfo.setText("Your bill is: "+ snapshot.child(path).child(account).child(bill).getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Billing.this, "Payment to be processed!", Toast.LENGTH_SHORT).show();
                Toast.makeText(Billing.this, "Payment to be processed!", Toast.LENGTH_SHORT).show();
            }
        })
        ;

    }
}
