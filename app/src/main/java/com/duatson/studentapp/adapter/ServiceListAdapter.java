package com.duatson.studentapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duatson.studentapp.R;
import com.duatson.studentapp.model.Service;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ServiceListAdapter extends ArrayAdapter<Service> {
    private Activity context;
    private List<Service> services;

    public ServiceListAdapter(Activity context, List<Service> services) {
        super(context, R.layout.service_list_item, services);
        this.context = context;
        this.services = services;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.service_list_item, null, true);

//        MaterialCardView cvSurface = viewItem.findViewById(R.id.serviceItemSurface);
//        TextView tvServiceItemTitle = viewItem.findViewById(R.id.tvServiceItemTitle);
//        TextView tvServiceItemDescription = viewItem.findViewById(R.id.tvServiceItemDescription);
//
//        Service service = services.get(position);
//        tvServiceItemTitle.setText(service.getName());
//        tvServiceItemDescription.setText(service.getDesctiption());

        return viewItem;
    }
}
