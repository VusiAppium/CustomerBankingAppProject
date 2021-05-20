package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername,edtPassword;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.EdtUsername);
        edtPassword = (EditText) findViewById(R.id.EdtPassword);


    }

    public void login(View view)
    {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        Intent intent = new Intent(this,AddressDetailsActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
