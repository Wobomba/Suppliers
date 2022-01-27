package com.redtokens.rooms.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText sign_email, sign_password;
    Button login_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sign_email = findViewById(R.id.Login_email);
        sign_password = findViewById(R.id.Login_password);
        login_sign = findViewById(R.id.sign_in);

        login_sign.setOnClickListener(v -> validate());
    }
    private void validate() {
        if(sign_email.getText().toString().isEmpty()){
            Toast t = Toast.makeText(this, "Enter an email address", Toast.LENGTH_SHORT);
            t.show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(sign_email.getText().toString()).matches()){
            sign_email.setError(getResources().getString(R.string.error_invalid_email));
        }
        else if(sign_password.getText().toString().isEmpty()){
            sign_password.setError("Missing password");
        }
        else if(sign_password.getText().length()<6){
            sign_password.setError(getResources().getString(R.string.error_invalid_password));
        }
        else{
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Successful",Toast.LENGTH_SHORT).show();
        }
    }
}