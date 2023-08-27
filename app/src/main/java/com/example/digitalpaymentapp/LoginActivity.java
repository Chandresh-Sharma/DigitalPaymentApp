package com.example.digitalpaymentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    // Shared preferences for simulating session management
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextEmailLogin);
        editTextPassword = findViewById(R.id.editTextPasswordLogin);
        buttonLogin = findViewById(R.id.buttonLogin);

        sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);

        // Check if user is already logged in
        if (sharedPreferences.getBoolean("logged_in", false)) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            finish();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    // In a real-world app, authenticate with a server. Here, we'll use hardcoded credentials for simplicity.
                    if (editTextUsername.getText().toString().equals("admin") &&
                            editTextPassword.getText().toString().equals("password")) {

                        // Using SharedPreferences to simulate session management
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("logged_in", true);
                        editor.apply();

                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isValid() {
        if (editTextUsername.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editTextPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
