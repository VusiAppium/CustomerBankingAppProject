package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.appium.java_client.android.StartsActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtIdNumber,edtUsername,edtPassword, edtName, edtSurname,edtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = (EditText) findViewById(R.id.EdtName);
        edtSurname = (EditText) findViewById(R.id.EdtSurname);
        edtEmail = (EditText) findViewById(R.id.EdtEmail);
        edtIdNumber = (EditText) findViewById(R.id.EdtIDNumber);
        edtUsername = (EditText) findViewById(R.id.EdtUsername);
        edtPassword = (EditText) findViewById(R.id.EdtPassword);

    }

    public void register(View view)
    {
        String name = edtName.getText().toString();
        String surname = edtSurname.getText().toString();
        String email = edtEmail.getText().toString();
        String idNumber = edtIdNumber.getText().toString();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
