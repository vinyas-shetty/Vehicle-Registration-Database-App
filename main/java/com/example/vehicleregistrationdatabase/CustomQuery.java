package com.example.vehicleregistrationdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomQuery extends AppCompatActivity {
    EditText attributes, tables, conditions;
    Button enter_btn;
    ArrayList<String> att, tab, con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_query);
        attributes = findViewById(R.id.attributes);
        tables = findViewById(R.id.tables);
        conditions = findViewById(R.id.conditions);
        enter_btn = findViewById(R.id.enter_btn);
//        att = new ArrayList<String>();
//        tab = new ArrayList<String>();
//        con = new ArrayList<String>();
        enter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                att.addAll(Arrays.asList(attributes.getText().toString().split(",")));
//                tab.addAll(Arrays.asList(tables.getText().toString().split(",")));
//                con.addAll(Arrays.asList(conditions.getText().toString().split(",")));
                Toast.makeText(CustomQuery.this, attributes.getText().toString(), Toast.LENGTH_SHORT).show();;
                Toast.makeText(CustomQuery.this, tables.getText().toString(), Toast.LENGTH_SHORT).show();;
                Toast.makeText(CustomQuery.this, conditions.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}