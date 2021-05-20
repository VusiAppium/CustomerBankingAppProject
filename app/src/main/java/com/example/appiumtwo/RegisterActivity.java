package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.appium.java_client.android.StartsActivity;

public class RegisterActivity extends AppCompatActivity {

    Context context;
    private EditText edtIdNumber,edtUsername,edtConfirmPassword,edtPassword, edtName, edtSurname,edtEmail;


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
        edtConfirmPassword = (EditText) findViewById(R.id.EdtConfirmPassword);

    }

    public void register(View view)
    {
        String name = edtName.getText().toString();
        String surname = edtSurname.getText().toString();
        String email = edtEmail.getText().toString();
        String idNumber = edtIdNumber.getText().toString();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtPassword.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
