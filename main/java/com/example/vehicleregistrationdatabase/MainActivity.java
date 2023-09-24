package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_vehicle, btn_owner, btn_license, btn_insurance;
//            customQueryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_vehicle = findViewById(R.id.btn_vehicle);
        btn_owner = findViewById(R.id.btn_owner);
        btn_license = findViewById(R.id.btn_license);
        btn_insurance = findViewById(R.id.btn_insurance);
//        customQueryBtn = findViewById(R.id.customQueryBtn);
        btn_vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Vehicle.class);
                startActivity(intent);
            }
        });
        btn_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Owner.class);
                startActivity(intent);
            }
        });
        btn_license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, DriversLicense.class);
                startActivity(intent);
            }
        });
        btn_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Insurance.class);
                startActivity(intent);
            }
        });

//        customQueryBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, CustomQuery.class);
//                startActivity(intent);
//            }
//        });
    }
}