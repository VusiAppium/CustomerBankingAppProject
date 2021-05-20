package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddressDetailsActivity extends AppCompatActivity {
    private EditText edtAddressLine1,edtAddressLine2,edtCity,edtProvince,edtPostalCode;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_details);

        edtAddressLine1 = (EditText) findViewById(R.id.edtAddressLine1);
        edtAddressLine2 = (EditText) findViewById(R.id.edtAddressLine2);
        edtCity = (EditText) findViewById(R.id.edtCity);
        edtProvince = (EditText) findViewById(R.id.edtProvince);
        edtPostalCode = (EditText) findViewById(R.id.edtPostalCode);
    }

    public void addressDetails(View view)
    {
        String addressLine1 = edtAddressLine1.getText().toString();
        String addressLine2 = edtAddressLine2.getText().toString();
        String city = edtCity.getText().toString();
        String province = edtProvince.getText().toString();
        String postalCode = edtPostalCode.getText().toString();

        Intent intent = new Intent(this,AddressDetailsActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
