package com.duatson.studentapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.duatson.studentapp.R;
import com.duatson.studentapp.model.Request;
import com.duatson.studentapp.model.Service;
import com.duatson.studentapp.network.FirebaseDb;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RequestListAdapter extends ArrayAdapter<Request> {
    private Activity context;
    private List<Request> requests;

    private DatabaseReference firebaseDb = FirebaseDb.makeDbRef();

    private Query query;

    public RequestListAdapter(Activity context, List<Request> requests) {
        super(context, R.layout.request_list_item, requests);
        this.context = context;
        this.requests = requests;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(R.layout.request_list_item, null, true);
        final Request request = requests.get(position);

        final ImageView requestItemIcon = view.findViewById(R.id.requestItemIcon);
        query = firebaseDb.child("Services").getRef().orderByChild(request.getServiceId()).equalTo(request.getServiceId());

        System.out.println(query);

        TextView tvRequestItemStatus = view.findViewById(R.id.tvRequestItemStatus);
        tvRequestItemStatus.setText(request.getStatus());

        TextView tvRequestItemTime = view.findViewById(R.id.tvRequestItemTime);
        tvRequestItemTime.setText(request.getTime());

        return view;
    }
}
