package com.example.database;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    EditText editText1;
    EditText editText2;
    Button bt1;
    public static final String EXTRA_NAME = " com.example.myapplication1.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView4);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        textView.setText("Welcome "+name);
        Spinner s1 = findViewById(R.id.spinner1);
        Spinner s2 = findViewById(R.id.spinner2);
        Spinner s3 = findViewById(R.id.spinner3);
        Button bt1 = findViewById(R.id.button2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(myAdapter);
        ArrayAdapter<String> yourAdapter = new ArrayAdapter<String>(MainActivity2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.mealNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(yourAdapter);
        ArrayAdapter<String> yourAdapter2 = new ArrayAdapter<String>(MainActivity2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.secondMealNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(yourAdapter2);

    }
    public void openActivity2(View v){
        Toast.makeText(this, "total calories..", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
        EditText editText1 = findViewById(R.id.editTextNumber2);
        EditText editText2 = findViewById(R.id.editTextNumber3);
        int num1;
        int num2;
        num1 = Integer.parseInt(editText1.getText().toString());
        num2 = Integer.parseInt(editText2.getText().toString());
        int sum = num1+num2;

        intent2.putExtra(EXTRA_NAME,sum);

        startActivity(intent2);
    }
}
