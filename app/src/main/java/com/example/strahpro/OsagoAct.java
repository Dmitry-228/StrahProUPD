package com.example.strahpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OsagoAct extends AppCompatActivity {
    Spinner categ, stage, region;
    Button rachet;
    TextView summa;
    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
    Map<Integer, String> categories = new HashMap<Integer, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osago1);
        categ = (Spinner) findViewById(R.id.categAutoSpin);
        stage = (Spinner) findViewById(R.id.stageAutoSpin);
        region = (Spinner) findViewById(R.id.regionSpin);
        summa = (TextView) findViewById(R.id.itog);
        rachet = (Button) findViewById(R.id.rachet);
        categories.put(1036, "A - motocicles");
        categories.put(3433, "B - motocicles");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,  countries);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        categ.setAdapter(adapter);

    }
}