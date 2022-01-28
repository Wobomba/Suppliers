package com.redtokens.rooms.supplier.ui.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.redtokens.rooms.supplier.AddClientActivity;
import com.redtokens.rooms.supplier.HomeActivity;
import com.redtokens.rooms.supplier.R;

import java.util.ArrayList;

public class ClientFragment extends Fragment {
   private BusinessAdapter businessAdapter;
   private Business[] businesses;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_clients, container, false);
        //getting the data from AddClientActivity
        this.businesses = new Business[]{
          new Business(1L,  " ",  " ",  " "),
                new Business(2L,  " ",  " ",  " "),
                new Business(3L,  " ",  " ",  " "),
                new Business(4L,  " ",  " ",  " "),
                new Business(4L,  " ",  " ",  " "),
                new Business(5L,  " ",  " ",  " "),
                new Business(6L,  " ",  " ",  " "),
                new Business(7L,  " ",  " ",  " "),
                new Business(8L,  " ",  " ",  " "),
                new Business(9L,  " ",  " ",  " "),
                new Business(10L,  "Fill in this data",  " ",  " "),
                new Business(11L,  " ",  " ",  " ")
        };
        this.businessAdapter = new BusinessAdapter(this.businesses, this.requireActivity());

        RecyclerView recyclerView = root.findViewById(R.id.list_businesses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));
        recyclerView.setAdapter(this.businessAdapter);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), AddClientActivity.class);
                intent.putExtra("id",0L)
                        .putExtra("name",  "")
                        .putExtra("location", "")
                        .putExtra("contacts", "");
                startActivityForResult(intent, 200);
            }
        });

        return root;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200 && resultCode == Activity.RESULT_OK){
            Toast.makeText(this.requireContext(),
                    "Results gotten"+data.getStringExtra("name"),
                    Toast.LENGTH_SHORT ).show();
        }
    }

    public static class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.ViewHolder> {
        // RecyclerView recyclerView;
        private Business[] listdata;
        private FragmentActivity activity;

        public BusinessAdapter(Business[] listdata, FragmentActivity activity) {
            this.listdata = listdata;
            this.activity = activity;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_clients, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Business myListData = listdata[position];
            holder.businessName.setText(listdata[position].getBusiness_name());
            holder.businessContacts.setText(listdata[position].getBusiness_contacts());
            holder.businessLocation.setText(listdata[position].getBusiness_location());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.startActivityForResult(
                            new Intent()
                            .putExtra("id", myListData.getBusiness_id())
                                    .putExtra("name", myListData.getBusiness_name())
                                    .putExtra("location", myListData.getBusiness_location())
                                    .putExtra("contacts", myListData.getBusiness_contacts()) ,

                            200
                    );
                     }
            });
        }

        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView businessName;
            public TextView businessContacts;
            public TextView businessLocation;

            public ViewHolder(View itemView) {
                super(itemView);
                this.businessName = (TextView) itemView.findViewById(R.id.business_name);
                this.businessContacts = (TextView) itemView.findViewById(R.id.contacts);
                businessLocation = (TextView) itemView.findViewById(R.id.location);
            }
        }
    }

   public class Business{
        Long business_id;
        String business_name;
        String business_contacts;
        String business_location;

        public Business(Long business_id, String business_name, String business_contacts, String business_location) {
            this.business_id = business_id;
            this.business_name = business_name;
            this.business_contacts = business_contacts;
            this.business_location = business_location;
        }

        public Long getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(Long business_id) {
            this.business_id = business_id;
        }

        public String getBusiness_name() {
            return business_name;
        }

        public void setBusiness_name(String business_name) {
            this.business_name = business_name;
        }

        public String getBusiness_contacts() {
            return business_contacts;
        }

        public void setBusiness_contacts(String business_contacts) {
            this.business_contacts = business_contacts;
        }

        public String getBusiness_location() {
            return business_location;
        }

        public void setBusiness_location(String business_location) {
            this.business_location = business_location;
        }
    }
}