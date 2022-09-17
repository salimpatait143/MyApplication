package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailid,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailid=findViewById(R.id.Email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=emailid.getText().toString();
                String Pass=password.getText().toString();
                if ( Patterns.EMAIL_ADDRESS.matcher(Email).matches() || (Email.length()==10 && Email.matches("(.*[0-9].*)")&& Email.startsWith("9")||Email.startsWith("8")||Email.startsWith("7")||Email.startsWith("6"))  && (Pass.length() >= 6 && Pass.matches("(.*[0-9].*)")
                        && Pass.matches("(.*[A-Z].*)") && Pass.matches("^(?=.*[_.()$&@]).*$"))) {
                    Toast.makeText(MainActivity.this, "Email and Password is valid ", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}