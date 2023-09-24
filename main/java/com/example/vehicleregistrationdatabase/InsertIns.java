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

public class InsertIns extends AppCompatActivity {
    EditText vNo, aadharNo, amt, expDate;
    Button insert_btnins, dpII;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_ins);
        vNo = findViewById(R.id.vNoUI);
        aadharNo = findViewById(R.id.ownerAadharUI);
        amt = findViewById(R.id.amt_UI);
        expDate = findViewById(R.id.expDateII);
        dpII = findViewById(R.id.dpII);
        insert_btnins = findViewById(R.id.update_btnIns);
        insert_btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(InsertIns.this);
                db.insertInsurance(Integer.parseInt(vNo.getText().toString()), Integer.parseInt(aadharNo.getText().toString()), Integer.parseInt(amt.getText().toString()), expDate.getText().toString());
            }
        });

        dpII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(InsertIns.this, new
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