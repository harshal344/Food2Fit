package com.example.database;


import static com.example.database.MainActivity.EXTRA_NAME;
import static com.example.database.MainActivity.EXTRA_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1 = findViewById(R.id.textView7);
        Intent intent2 = getIntent();
        int sum = getIntent().getExtras().getInt(EXTRA_NAME);
        t1.setText("                   "+sum+ "cal.");
    }
}


