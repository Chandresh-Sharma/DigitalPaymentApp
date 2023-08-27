package com.example.digitalpaymentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize the UI components
        signOutButton = findViewById(R.id.signOutButton);

        // Set up listeners
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignOut();
            }
        });
    }

    private void handleSignOut() {
        // TODO: Here, you can handle any cleanup or logout logic such as clearing session tokens or other user data.

        // Redirect the user to the LoginActivity
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();  // Remove the dashboard from the back stack
    }
}
