package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DriversLicense extends AppCompatActivity {
    Button insert_btndl, edit_btndl, delete_btndl;
    RecyclerView rv_license;

    DBHelper db1;
    ArrayList<String> licenseNo, ownerAadhar, expDate;
    LicenseAdapter licenseAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_license);
        insert_btndl = findViewById(R.id.insert_btni);
        edit_btndl = findViewById(R.id.update_btni);
        delete_btndl = findViewById(R.id.delete_btni);
        rv_license = findViewById(R.id.rv_license);
        insert_btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_insert = new Intent (DriversLicense.this, InsertDL.class);
                startActivity(intent_insert);
            }
        });
        edit_btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_update = new Intent (DriversLicense.this, EditDL.class);
                startActivity(intent_update);
            }
        });
        delete_btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_delete = new Intent (DriversLicense.this, DeleteDL.class);
                startActivity(intent_delete);
            }
        });

        db1 = new DBHelper(DriversLicense.this);
        licenseNo = new ArrayList<>();
        ownerAadhar = new ArrayList<>();
        expDate = new ArrayList<>();

        storeDataInArrays();

        licenseAdapter = new LicenseAdapter(DriversLicense.this, licenseNo, ownerAadhar, expDate);
        rv_license.setAdapter(licenseAdapter);
        rv_license.setLayoutManager(new LinearLayoutManager(DriversLicense.this));
    }

    void storeDataInArrays () {
        Cursor cursor = db1.readAllLicense();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                licenseNo.add(cursor.getString(0));
                ownerAadhar.add(cursor.getString(1));
                expDate.add(cursor.getString(2));
            }
        }
    }
}