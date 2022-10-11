package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEdt, userAgeEdt, userGenderEdt;
    private Button sendDatabtn;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    userInfo userInfo;
    public static final String EXTRA_NAME = " com.example.fitnessapp1.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEdt = findViewById(R.id.idEdtuserName);
        userAgeEdt = findViewById(R.id.idEdtuserAge);
        userGenderEdt = findViewById(R.id.idEdtuserGender);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("userInfo");

        userInfo = new userInfo();

        sendDatabtn = findViewById(R.id.idBtnSendData);

        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = userNameEdt.getText().toString();
                String age = userAgeEdt.getText().toString();
                String gender = userGenderEdt.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(age) && TextUtils.isEmpty(gender)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(MainActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(name, age, gender);
                }
            }
        });
    }
    public void openActivity(View v){
        EditText e1 = findViewById(R.id.idEdtuserName);
        Toast.makeText(this, "Welcome..", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity2.class);
        String nameText = e1.getText().toString();
        intent.putExtra(EXTRA_NAME,nameText);
        startActivity(intent);
    }

    private void addDatatoFirebase(String name, String age, String gender) {
        userInfo.setuserName(name);
        userInfo.setuserAge(age);
        userInfo.setuserGender(gender);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(userInfo);

                // after adding this data we are showing toast message.
                Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
