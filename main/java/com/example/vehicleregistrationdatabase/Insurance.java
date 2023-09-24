package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Insurance extends AppCompatActivity {
    Button insert_btni, update_btni, delete_btni;
    RecyclerView rv_insurance;

    DBHelper db1;
    ArrayList<String> insuranceNo, vehicleNo, ownerAadhar, amount, expDate;
    InsuranceAdapter insuranceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        insert_btni = findViewById(R.id.insert_btni);
        update_btni = findViewById(R.id.update_btni);
        delete_btni = findViewById(R.id.delete_btni);
        rv_insurance = findViewById(R.id.rv_insurance);
        insert_btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_insert = new Intent (Insurance.this, InsertIns.class);
                startActivity(intent_insert);
            }
        });
        update_btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_update = new Intent (Insurance.this, EditIns.class);
                startActivity(intent_update);
            }
        });
        delete_btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_delete = new Intent (Insurance.this, DeleteIns.class);
                startActivity(intent_delete);
            }
        });

        db1 = new DBHelper(Insurance.this);
        insuranceNo = new ArrayList<>();
        vehicleNo = new ArrayList<>();
        ownerAadhar = new ArrayList<>();
        amount = new ArrayList<>();
        expDate = new ArrayList<>();

        storeDataInArrays();

        insuranceAdapter = new InsuranceAdapter(Insurance.this, insuranceNo, vehicleNo, ownerAadhar, amount, expDate);
        rv_insurance.setAdapter(insuranceAdapter);
        rv_insurance.setLayoutManager(new LinearLayoutManager(Insurance.this));
    }

    void storeDataInArrays () {
        Cursor cursor = db1.readAllInsurance();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                insuranceNo.add(cursor.getString(0));
                vehicleNo.add(cursor.getString(1));
                ownerAadhar.add(cursor.getString(2));
                amount.add(cursor.getString(3));
                expDate.add(cursor.getString(4));
            }
        }
    }
}