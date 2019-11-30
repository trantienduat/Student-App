package com.duatson.studentapp;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duatson.studentapp.network.ServiceEntry;

import java.util.List;

public class ServiceCardRecyclerViewAdapter extends RecyclerView.Adapter<ServiceCardViewHolder> {

    private List<ServiceEntry> serviceEntryList;
    //private ImageRequester imageRequester;

    @NonNull
    @Override
    public ServiceCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceCardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
