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

public class OwnerInsert extends AppCompatActivity {
    EditText aadharNo, name, sex, dob, address;
    Button insert_btno, datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        setContentView(R.layout.activity_owner_insert);
        aadharNo = findViewById(R.id.vNoUI);
        name = findViewById(R.id.vModelUV);
        sex = findViewById(R.id.vTypeUV);
        dob = findViewById(R.id.expDateUI);
        address = findViewById(R.id.addressUpdateo);
        insert_btno = findViewById(R.id.update_btnIns);
        datePicker = findViewById(R.id.datePicker);
        insert_btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db1 = new DBHelper(OwnerInsert.this);
                db1.insertOwner(Integer.parseInt(aadharNo.getText().toString()), name.getText().toString(), sex.getText().toString(), dob.getText().toString(), address.getText().toString());
            }
        });
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(OwnerInsert.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                dob.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                            }, year, month, day);
                dp.show();
            }
        });
    }
}