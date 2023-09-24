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

public class EditVehicle extends AppCompatActivity {
    EditText vNoUV, vTypeUV, vModelUV, datePurchaseUV, ownerAadharUV;
    Button update_btnv, dpUV;
    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vehicle);
        vNoUV = findViewById(R.id.vNoUV);
        vModelUV = findViewById(R.id.vModelUV);
        vTypeUV = findViewById(R.id.vTypeUV);
        datePurchaseUV = findViewById(R.id.purchaseDateUV);
        ownerAadharUV = findViewById(R.id.vNoUI);
        update_btnv = findViewById(R.id.update_btnIns);
        dpUV = findViewById(R.id.dpUV);
        update_btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(EditVehicle.this);
                db.updateVehicle(Integer.parseInt(vNoUV.getText().toString()), vModelUV.getText().toString(), vTypeUV.getText().toString(), datePurchaseUV.getText().toString(), Integer.parseInt(ownerAadharUV.getText().toString()));
            }
        });

        dpUV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(EditVehicle.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                datePurchaseUV.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}