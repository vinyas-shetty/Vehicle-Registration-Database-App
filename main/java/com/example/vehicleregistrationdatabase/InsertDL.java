package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class InsertDL extends AppCompatActivity {
    EditText dlNo, aadhar_no_dl, expDate;
    Button insert_btndl, dpIDL;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_dl);
        dlNo = findViewById(R.id.vNoUI);
        aadhar_no_dl = findViewById(R.id.ownerAadharUI);
        expDate = findViewById(R.id.expDateIDL);
        insert_btndl = findViewById(R.id.update_btnIns);
        dpIDL = findViewById(R.id.dpIDL);
        insert_btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db1 = new DBHelper(InsertDL.this);
                db1.insertLicense(Integer.parseInt(dlNo.getText().toString()), Integer.parseInt(aadhar_no_dl.getText().toString()), expDate.getText().toString());
            }
        });

        dpIDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(InsertDL.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                expDate.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}