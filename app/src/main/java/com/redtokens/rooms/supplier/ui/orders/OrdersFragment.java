package com.redtokens.rooms.supplier.ui.orders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.redtokens.rooms.supplier.IncomingActivity;
import com.redtokens.rooms.supplier.OutgoingActivity;
import com.redtokens.rooms.supplier.R;

public class OrdersFragment extends Fragment {

    Button outt, inn;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_orders, container, false);
        inn = root.findViewById(R.id.incoming_btn);
        outt = root.findViewById(R.id.outgoing_btn);

        inn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IncomingActivity.class);
            startActivity(intent);
        });

        outt.setOnClickListener(v -> {
            Intent in = new Intent(getActivity(), OutgoingActivity.class);
            startActivity(in);
        });
        return root;
    }
}