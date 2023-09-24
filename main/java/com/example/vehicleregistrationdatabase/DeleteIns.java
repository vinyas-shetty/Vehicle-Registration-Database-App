package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteIns extends AppCompatActivity {
    EditText insNoDI;
    Button delete_btnDI;

    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_ins);
        insNoDI = findViewById(R.id.insNoDI);
        delete_btnDI = findViewById(R.id.delete_btnDI);
        delete_btnDI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(DeleteIns.this);
                db.deleteInsurance(Integer.parseInt(insNoDI.getText().toString()));
            }
        });
    }
}