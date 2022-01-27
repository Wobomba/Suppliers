package com.redtokens.rooms.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText reg_email, reg_password, reg_businessname;
    Button reg_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        reg_email = findViewById(R.id.Registration_email);
        reg_password = findViewById(R.id.Registration_password);
        reg_businessname = findViewById(R.id.Registration_businessname);
        reg_signup = findViewById(R.id.sign_up);

        reg_signup.setOnClickListener(v -> validatingData());

    }
    private void validatingData() {
        if(reg_email.getText().toString().isEmpty()){
            Toast t = Toast.makeText(this, "Enter an email address", Toast.LENGTH_SHORT);
            t.show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(reg_email.getText().toString()).matches()){
            reg_email.setError(getResources().getString(R.string.error_invalid_email));
        }

        else if(reg_password.getText().toString().isEmpty()){
            reg_password.setError("Missing password");
        }

        else if(reg_password.getText().length()<6){
            reg_password.setError(getResources().getString(R.string.error_invalid_password));
        }

        else if(reg_businessname.getText().toString().isEmpty()){
            reg_businessname.setError("Missing a business name");
        }
        else{
            Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Successful",Toast.LENGTH_SHORT).show();
        }
    }
}