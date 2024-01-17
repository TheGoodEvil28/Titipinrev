package com.example.titipin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Waitroom extends AppCompatActivity {
    Button Login,Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waitroom);
        Login = findViewById(R.id.button_Login);
        Register = findViewById(R.id.button_Register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Waitroom.this, com.example.titipin.Login.class));
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Waitroom.this, RegisterPhoneNumberActivity.class));
            }
        });
    }
}