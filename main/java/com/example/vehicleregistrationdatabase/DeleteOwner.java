package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteOwner extends AppCompatActivity {
    EditText ownerNoDO;
    Button delete_btnDO;

    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_owner);
        ownerNoDO = findViewById(R.id.ownerNoDO);
        delete_btnDO = findViewById(R.id.delete_btnDO);
        delete_btnDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DBHelper(DeleteOwner.this);
                db.deleteOwner(Integer.parseInt(ownerNoDO.getText().toString()));
            }
        });
    }
}