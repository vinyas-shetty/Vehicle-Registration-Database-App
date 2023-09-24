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

public class EditIns extends AppCompatActivity {
    EditText insNoUI, vNoUI, ownerAadharUI, amtUI, expDateUI;
    Button update_btnIns, dpUI;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ins);
        insNoUI = findViewById(R.id.insNoUI);
        vNoUI = findViewById(R.id.vNoUI);
        ownerAadharUI = findViewById(R.id.ownerAadharUI);
        amtUI = findViewById(R.id.amt_UI);
        expDateUI = findViewById(R.id.expDateUI);
        update_btnIns = findViewById(R.id.update_btnIns);
        dpUI = findViewById(R.id.dpUI);
        update_btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(EditIns.this);
                db.updateInsurance(Integer.parseInt(insNoUI.getText().toString()), Integer.parseInt(vNoUI.getText().toString()), Integer.parseInt(ownerAadharUI.getText().toString()), Integer.parseInt(amtUI.getText().toString()), expDateUI.getText().toString());
            }
        });

        dpUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(EditIns.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                expDateUI.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}