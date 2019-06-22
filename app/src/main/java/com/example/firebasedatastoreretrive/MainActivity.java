package com.example.firebasedatastoreretrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button saveDataButton,loadDataButton;
    private EditText fullNameEditText,ageEditText;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("profiles");

        saveDataButton=findViewById(R.id.saveDataButtonId);
        loadDataButton=findViewById(R.id.loadDataButtonId);
        fullNameEditText=findViewById(R.id.fullNameEditText);
        ageEditText=findViewById(R.id.ageEditText);
        
        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
    }


    private void saveData() {
        String fullName=fullNameEditText.getText().toString().trim();
        String age=ageEditText.getText().toString().trim();

        String key=databaseReference.push().getKey();

        Profile profile=new Profile(fullName,age);
        databaseReference.child(key).setValue(profile);
        Toast.makeText(getApplicationContext(), "Profile info added successfully ", Toast.LENGTH_SHORT).show();
        fullNameEditText.setText("");
        ageEditText.setText("");
    }
}
