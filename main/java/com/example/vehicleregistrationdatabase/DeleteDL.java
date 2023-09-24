package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteDL extends AppCompatActivity {
    EditText dlNoDDL;
    Button delete_btnDDL;
    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_dl);
        dlNoDDL = findViewById(R.id.dlNoDDL);
        delete_btnDDL = findViewById(R.id.delete_btnDDL);
        delete_btnDDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(DeleteDL.this);
                db.deleteLicense(Integer.parseInt(dlNoDDL.getText().toString()));
            }
        });
    }
}