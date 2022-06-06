package com.example.evchargeufirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public static String fbDbName;
    public static String dbRName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        loadFirebaseDatabase();
//        loadDatabaseReference();


        goToLogin();

    }
//    public String loadFirebaseDatabase(){
//        firebaseDatabase = firebaseDatabase.getInstance();
//        fbDbName = firebaseDatabase.getReference().toString();
//        return fbDbName;
//    }
//
//    public String loadDatabaseReference(){
//        databaseReference = firebaseDatabase.getReference();
//        dbRName = databaseReference.getRef().toString();
//        return dbRName;
//    }

    private void goToLogin(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}