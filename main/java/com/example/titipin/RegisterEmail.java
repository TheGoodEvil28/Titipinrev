package com.example.titipin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterEmail extends AppCompatActivity {
  private EditText loginEmail;
    private EditText loginPassword;
    Button loginHome;
   private Button buttonRegister;
   private ProgressBar progressBar;

   private DatabaseReference dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);
        loginEmail = findViewById(R.id.login_Email);
        loginPassword = findViewById(R.id.login_password);
        buttonRegister = findViewById(R.id.button_Register);
        dataBase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://titipin-d3591-default-rtdb.firebaseio.com/");
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = loginEmail.getText().toString();
                String password =loginPassword.getText().toString();

                if (email.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete all the Required Data", Toast.LENGTH_SHORT).show();
                }else if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Must be more than 6", Toast.LENGTH_SHORT).show();
                }else {
                    dataBase = FirebaseDatabase.getInstance().getReference("users");
                    dataBase.child(email).child("email").setValue(email);
                    dataBase.child(email).child("password").setValue(password);
                    Toast.makeText(getApplicationContext(),"RegisterEmail Completed", Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), Home.class);
                    startActivity(register);

                }
            }
        });

//        progressBar = findViewById(R.id.login_progress_bar);
//
//        dataBase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://titipin-d3591-default-rtdb.firebaseio.com/");
//        buttonRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = loginEmail.getText().toString();
//                String password = loginPassword.getText().toString();
//
//                if (email.isEmpty()||password.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Complete all the Required Data", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        dataBase = FirebaseDatabase.getInstance().getReferenceFromUrl("users");
//                        dataBase.child(email).child("email").setValue(email);
//                        dataBase.child(email).child("password").setValue(password);
//                        Toast.makeText(getApplicationContext(),"RegisterEmail Completed", Toast.LENGTH_SHORT).show();
//                        Intent register =new Intent(getApplicationContext(), Waitroom.class);
//                        startActivity(register);
//                    }
//                }
//            });

    }
}