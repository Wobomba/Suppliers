package com.redtokens.rooms.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.redtokens.rooms.supplier.ui.orders.OrdersFragment;

public class IncomingActivity extends AppCompatActivity {
    EditText Cat,Bname,Dest,Amount,P_Status;
    Button acc, decl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming);

        Cat = findViewById(R.id.Category_Outgoing);
        Bname = findViewById(R.id.Cat_Outgoing);
        Dest = findViewById(R.id.Outgoing_name);
        Amount = findViewById(R.id.Amount_outgoing);
        P_Status = findViewById(R.id.Destination_outgoing);
        acc = findViewById(R.id.accept_btn);
        decl = findViewById(R.id.decline_btn);

        decl.setOnClickListener(view -> {
            Intent intent = new Intent(IncomingActivity.this,FeedbackActivity.class);
            startActivity(intent);
            finish();
        });

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IncomingActivity.this, OrdersFragment.class);
                startActivity(i);
                finish();
            }
        });
    }
}