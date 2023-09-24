package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteVehicle extends AppCompatActivity {
    EditText vNoDV;
    Button delete_btnDV;
    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_vehicle);
        vNoDV = findViewById(R.id.vNoDV);
        delete_btnDV = findViewById(R.id.delete_btnDV);
        delete_btnDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(DeleteVehicle.this);
                db.deleteVehicle(Integer.parseInt(vNoDV.getText().toString()));
            }
        });
    }
}