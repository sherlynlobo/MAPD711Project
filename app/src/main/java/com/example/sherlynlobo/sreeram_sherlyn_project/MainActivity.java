package com.example.sherlynlobo.sreeram_sherlyn_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sherlynlobo.sreeram_sherlyn_project.dao.CustomerDAO;
import com.example.sherlynlobo.sreeram_sherlyn_project.model.Customer;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ClickRegister(View view){
        Intent i2 = new Intent(MainActivity.this, Register.class);
        startActivity(i2);
    }
    //for login button
    public void ClickLogin(View view){
        Intent i3 = new Intent(MainActivity.this, Home.class);
        startActivity(i3);
    }



}




