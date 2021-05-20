package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WorkDetailsActivity extends AppCompatActivity {
    private EditText edtEmploymentLevel,edtPosition,edtCompanyName,edtEmploymentStartDate;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details);

        edtEmploymentLevel = (EditText) findViewById(R.id.edtEmploymentLevel);
        edtPosition = (EditText) findViewById(R.id.edtPosition);
        edtCompanyName = (EditText) findViewById(R.id.edtCompanyName);
        edtEmploymentStartDate = (EditText) findViewById(R.id.edtEmploymentStartDate);
    }
    public void workDetails(View view)
    {
        String employmentLevel = edtEmploymentLevel.getText().toString();
        String position = edtPosition.getText().toString();
        String companyName = edtCompanyName.getText().toString();
        String employmentStartDate = edtEmploymentStartDate.getText().toString();

        Intent intent = new Intent(this,WorkDetailsActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
