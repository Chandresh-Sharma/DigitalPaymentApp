package com.example.digitalpaymentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public class FirstPageActivity extends AppCompatActivity {

    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("First page","Entered in onClickfunction opening login page");
                openLoginPage();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupPage();
            }
        });
    }

    private void openLoginPage() {
        Intent intent = new Intent(FirstPageActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void openSignupPage() {
        Intent intent = new Intent(FirstPageActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
