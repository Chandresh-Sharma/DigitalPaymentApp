package com.example.digitalpaymentapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;

    // Shared preferences for storing registered user details (just for this example)
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignup);

        sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    // In a real-world app, you'd send these details to a server. Here, we'll save them in SharedPreferences for simplicity.
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", editTextUsername.getText().toString().trim());
                    editor.putString("email", editTextEmail.getText().toString().trim());
                    editor.putString("password", editTextPassword.getText().toString().trim());
                    editor.apply();

                    Toast.makeText(SignupActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                    finish();  // Returns to previous activity (usually the LoginActivity)
                }
            }
        });
    }

    private boolean isValid() {
        if (editTextUsername.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editTextEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editTextPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
