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

public class Owner extends AppCompatActivity {
    Button insert_btno, edit_btno, delete_btno;
    RecyclerView rv_owner;

    DBHelper db;
    ArrayList<String> owner_ID, aadhar_no, name, sex, date_of_birth, address;
    CustomAdapter customAdapter;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        insert_btno = findViewById(R.id.insert_btni);
        edit_btno = findViewById(R.id.update_btni);
        delete_btno = findViewById(R.id.delete_btni);
        rv_owner = findViewById(R.id.rv_owner);
        insert_btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_insert = new Intent(Owner.this, OwnerInsert.class);
                startActivity(intent_insert);
            }
        });
        edit_btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_update = new Intent(Owner.this, EditOwner.class);
                startActivity(intent_update);
            }
        });
        delete_btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_delete = new Intent(Owner.this, DeleteOwner.class);
                startActivity(intent_delete);
            }
        });

        db = new DBHelper(Owner.this);
        owner_ID = new ArrayList<>();
        aadhar_no = new ArrayList<>();
        name = new ArrayList<>();
        sex = new ArrayList<>();
        date_of_birth = new ArrayList<>();
        address = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(Owner.this, owner_ID, aadhar_no, name, sex, date_of_birth, address);
        rv_owner.setAdapter(customAdapter);
        rv_owner.setLayoutManager(new LinearLayoutManager(Owner.this));
    }

    void storeDataInArrays () {
        Cursor cursor = db.readAllOwner();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                owner_ID.add(cursor.getString(0));
                aadhar_no.add(cursor.getString(1));
                name.add(cursor.getString(2));
                sex.add(cursor.getString(3));
                date_of_birth.add(cursor.getString(4));
                address.add(cursor.getString(5));
            }
        }
    }
}