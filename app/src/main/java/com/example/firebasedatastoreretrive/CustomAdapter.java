package com.example.firebasedatastoreretrive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Profile> {

    private Activity context;
    private List<Profile> profileList;

    public CustomAdapter(Activity context, List<Profile> profileList) {
        super(context, R.layout.sample_layout, profileList);
        this.context = context;
        this.profileList = profileList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        Profile profile=profileList.get(position);
        TextView t1=view.findViewById(R.id.fullNameTextEditId);
        TextView t2=view.findViewById(R.id.ageTextEditId);

        t1.setText("Full Name: "+profile.getName());
        t2.setText("Age: "+profile.getAge());

        return view;
    }
}
