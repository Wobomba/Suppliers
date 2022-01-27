package com.redtokens.rooms.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launch_Activity extends AppCompatActivity {
    Button sign_up, reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_);
        sign_up = findViewById(R.id.login_btn);
        reg = findViewById(R.id.Register_btn);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Launch_Activity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Launch_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}