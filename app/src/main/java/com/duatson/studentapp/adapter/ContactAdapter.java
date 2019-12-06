package com.duatson.studentapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duatson.studentapp.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter {

    private Activity context;
    private List<String> contacts;

    public ContactAdapter(Activity context, List<String> contacts) {
        super(context, R.layout.contact_item_service_detail, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.contact_item_service_detail, null, true);

        TextView title = viewItem.findViewById(R.id.contactTitle);
        title.setText(contacts.get(position));

        return viewItem;
        //return super.getView(position, convertView, parent);
    }
}
