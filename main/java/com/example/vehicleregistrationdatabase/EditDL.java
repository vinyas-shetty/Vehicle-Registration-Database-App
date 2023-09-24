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

public class EditDL extends AppCompatActivity {
    EditText dlNoUL, ownerAadharUDL, expDateUDL;
    Button update_btndl, dpUDL;

    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dl);
        dlNoUL = findViewById(R.id.vNoUI);
        ownerAadharUDL = findViewById(R.id.ownerAadharUI);
        expDateUDL = findViewById(R.id.expDateUDL);
        update_btndl = findViewById(R.id.update_btnIns);
        dpUDL = findViewById(R.id.dpUDL);
        update_btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(EditDL.this);
                db.updateLicense(Integer.parseInt(dlNoUL.getText().toString()), Integer.parseInt(ownerAadharUDL.getText().toString()), expDateUDL.getText().toString());
            }
        });

        dpUDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(EditDL.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                expDateUDL.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}