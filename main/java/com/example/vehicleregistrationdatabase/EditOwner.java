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

public class EditOwner extends AppCompatActivity {
    EditText ownerIDupdateo, aadharNoUpdateo, nameUpdateo, sexUpdateo, dobUpdateo, addressUpdateo;
    Button update_btno, dpUO;

    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_owner);
        ownerIDupdateo = findViewById(R.id.ownerIDupdateo);
        aadharNoUpdateo = findViewById(R.id.vNoUI);
        nameUpdateo = findViewById(R.id.vModelUV);
        sexUpdateo = findViewById(R.id.vTypeUV);
        dobUpdateo = findViewById(R.id.dobUO);
        addressUpdateo = findViewById(R.id.addressUpdateo);
        update_btno = findViewById(R.id.update_btnIns);
        dpUO = findViewById(R.id.dpUO);
        update_btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(EditOwner.this);
                db.updateOwner(Integer.parseInt(ownerIDupdateo.getText().toString()), Integer.parseInt(aadharNoUpdateo.getText().toString()), nameUpdateo.getText().toString(), sexUpdateo.getText().toString(), dobUpdateo.getText().toString(), addressUpdateo.getText().toString());
            }
        });

        dpUO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(EditOwner.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                dobUpdateo.setText(i2 + "/" + (i1 + 1) + "/" + i);
                            }
                        }, year, month, day);
                dp.show();
            }
        });
    }
}