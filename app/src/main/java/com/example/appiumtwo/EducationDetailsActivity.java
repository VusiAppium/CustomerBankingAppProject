package com.example.appiumtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EducationDetailsActivity extends AppCompatActivity {
    private EditText edtQualification,edtTertiaryInstitution,edtProvinceObtained,edtYearObtained;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);

        edtQualification = (EditText) findViewById(R.id.edtQualificationObtained);
        edtTertiaryInstitution = (EditText) findViewById(R.id.edtTertiary);
        edtYearObtained = (EditText) findViewById(R.id.edtYearObtained);
        edtProvinceObtained = (EditText) findViewById(R.id.edtProvince);
    }

    public void addressDetails(View view)
    {
        String qualification = edtQualification.getText().toString();
        String tertiary = edtTertiaryInstitution.getText().toString();
        String year = edtYearObtained.getText().toString();
        String province = edtProvinceObtained.getText().toString();


        Intent intent = new Intent(this,EducationDetailsActivity.class);
        startActivity(intent);

        Toast.makeText(context,"Loading....",Toast.LENGTH_SHORT).show();
    }
}
