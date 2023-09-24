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

public class InsertVehicle extends AppCompatActivity {
    EditText v_model, v_type, purchaseDateIV, Veh_no;
    Button btn_insert_details, dpIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vehicle);
        v_model = findViewById(R.id.vModelUV);
        v_type = findViewById(R.id.vTypeUV);
        purchaseDateIV = findViewById(R.id.purchaseDateIV);
        Veh_no = findViewById(R.id.vNoUI);
        dpIV = findViewById(R.id.dpIV);
        btn_insert_details = findViewById(R.id.update_btnIns);
        btn_insert_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(InsertVehicle.this);
                db.insertVehicle(v_model.getText().toString(), v_type.getText().toString(), purchaseDateIV.getText().toString(), Integer.parseInt(Veh_no.getText().toString()));
            }
        });

        dpIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(InsertVehicle.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                purchaseDateIV.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}