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

public class Register extends AppCompatActivity {

    private EditText customerUserName;
    private EditText customerpostalCode;
    private EditText customerCity;
    private EditText customerAddress;
    private EditText customerPassword;
    private EditText customerLastName;
    private EditText customerFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        customerUserName = findViewById(R.id.editsuname);
        customerPassword =  findViewById(R.id.editsupwd);
        customerFirstName =  findViewById(R.id.editText5);
        customerLastName =  findViewById(R.id.editText6);
        customerAddress =  findViewById(R.id.editText7);
        customerCity =  findViewById(R.id.editText8);
        customerpostalCode =  findViewById(R.id.editText9);
    }

    public void customer_signUp(View view) {
        boolean formValid = true;
        CustomerDAO customerDAO = new CustomerDAO(this);
        Customer customer = new Customer();
        // Validate all the required fields in the form
        if (TextUtils.isEmpty(customerUserName.getText().toString().trim())) {
            customerUserName.setError("User name is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerAddress.getText().toString().trim())) {
            customerAddress.setError("Address is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerpostalCode.getText().toString().trim())) {
            customerpostalCode.setError("Postal code is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerCity.getText().toString().trim())) {
            customerCity.setError("City is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerPassword.getText().toString().trim())) {
            customerPassword.setError("Password is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerLastName.getText().toString().trim())) {
            customerLastName.setError("Last name is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(customerFirstName.getText().toString().trim())) {
            customerFirstName.setError("First name is required!");
            formValid = false;
        }

        if (formValid) {
            customer.setUserName(customerUserName.getText().toString());
            customer.setPostalCode(customerpostalCode.getText().toString());
            customer.setCity(customerCity.getText().toString());
            customer.setAddress(customerAddress.getText().toString());
            customer.setPassword(customerPassword.getText().toString());
            customer.setLastName(customerLastName.getText().toString());
            customer.setFirstName(customerFirstName.getText().toString());
            customerDAO.insert(customer);

            Intent i1 = new Intent(Register.this, MainActivity.class);

            Toast.makeText(Register.this, "You have successfully registered", Toast.LENGTH_LONG).show();


            startActivity(i1);
        }
    }
}
