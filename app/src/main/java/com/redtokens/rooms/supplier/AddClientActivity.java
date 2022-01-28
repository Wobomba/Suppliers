package com.redtokens.rooms.supplier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.redtokens.rooms.supplier.ui.client.ClientFragment;

public class AddClientActivity extends AppCompatActivity {
    EditText client_name, bname, location, amt, itname;
    Button comp, rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        client_name = findViewById(R.id.Client_name);
        bname = findViewById(R.id.Business_name);
        itname = findViewById(R.id.item_name);
        location = findViewById(R.id.Destination_name);
        amt = findViewById(R.id.Amount_outgoing);
        comp = findViewById(R.id.add_btn);
        rel = findViewById(R.id.clear_btn);

        client_name.setText(getIntent().getStringExtra("name"));
        bname.setText(getIntent().getStringExtra("name"));
        location.setText(getIntent().getStringExtra("location"));
        amt.setText(getIntent().getStringExtra("contacts"));

        //the rel(clear) button clears whatever the user just input
        rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client_name.setText(" ");
                bname.setText(" ");
                location.setText(" ");
                amt.setText(" ");
            }
        });

        //enables a user store details of the client on the client fragment and redirects to the clientFragment
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", bname.getText().toString().trim());
                intent.putExtra("contact", amt.getText().toString().trim());
                intent.putExtra("location", location.getText().toString().trim());
                intent.putExtra("id", getIntent().getLongExtra("íd", 0L) == 0L ?
                        System.currentTimeMillis(): getIntent().getLongExtra("íd", 0L) );
                setResult(Activity.RESULT_OK, intent);
               finish();
            }
        });
    }
}