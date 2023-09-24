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

public class Vehicle extends AppCompatActivity {
    Button insert, delete, update;
    RecyclerView rv_vehicle;

    DBHelper db1;
    ArrayList<String> vehicleNo, vehicleModel, vehicleType, purchaseDate, ownerAadharNo;
    VehicleAdapter vehicleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        insert = findViewById(R.id.insert_btni);
        update = findViewById(R.id.update_btni);
        delete = findViewById(R.id.delete_btni);
        rv_vehicle = findViewById(R.id.rv_vehicle);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_insert = new Intent(Vehicle.this, InsertVehicle.class);
                startActivity(intent_insert);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_update = new Intent(Vehicle.this, EditVehicle.class);
                startActivity(intent_update);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_delete = new Intent(Vehicle.this, DeleteVehicle.class);
                startActivity(intent_delete);
            }
        });

        db1 = new DBHelper(Vehicle.this);
        vehicleNo = new ArrayList<>();
        vehicleModel = new ArrayList<>();
        vehicleType = new ArrayList<>();
        purchaseDate = new ArrayList<>();
        ownerAadharNo = new ArrayList<>();

        storeDataInArrays();

        vehicleAdapter = new VehicleAdapter(Vehicle.this, vehicleNo, vehicleModel, vehicleType, purchaseDate, ownerAadharNo);
        rv_vehicle.setAdapter(vehicleAdapter);
        rv_vehicle.setLayoutManager(new LinearLayoutManager(Vehicle.this));
    }

    void storeDataInArrays () {
        Cursor cursor = db1.readAllVehicle();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                vehicleNo.add(cursor.getString(0));
                vehicleModel.add(cursor.getString(1));
                vehicleType.add(cursor.getString(2));
                purchaseDate.add(cursor.getString(3));
                ownerAadharNo.add(cursor.getString(4));
            }
        }
    }
}