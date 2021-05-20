package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IncomeDetailsActivity extends AppCompatActivity {
    private EditText edtNetSalary,edtGrossSalary,edtPaymentDate;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_details);

        edtNetSalary = (EditText) findViewById(R.id.edtNetSalary);
        edtGrossSalary = (EditText) findViewById(R.id.edtGrossSalary);
        edtPaymentDate = (EditText) findViewById(R.id.edtPaymentDay);
    }

    public void addressDetails(View view)
    {
        String netSalary = edtNetSalary.getText().toString();
        String grossSalary = edtGrossSalary.getText().toString();
        String payment = edtPaymentDate.getText().toString();

        Intent intent = new Intent(this,IncomeDetailsActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
