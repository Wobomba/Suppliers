package com.redtokens.rooms.supplier.ui.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;



import com.redtokens.rooms.supplier.R;

import java.util.ArrayList;

public class ClientFragment extends Fragment {
    private ArrayList<String> client_name = new ArrayList<String>();
    private ArrayList<String> item = new ArrayList<String>();
    private ArrayList<String> category = new ArrayList<String>();
    private ArrayList<String> destination = new ArrayList<String>();
    private ArrayList<String> status = new ArrayList<String>();
    TableLayout table;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_clients, container, false);
        return root;
    }
}