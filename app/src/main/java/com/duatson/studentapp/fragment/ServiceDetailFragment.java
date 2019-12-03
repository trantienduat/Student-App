package com.duatson.studentapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.duatson.studentapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceDetailFragment extends Fragment {


    ListView lvContact;

    public ServiceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_service_detail, container, false);
        View view = inflater.inflate(R.layout.fragment_service_detail, container,false);

        setLvContact(view);

        return view;
    }

    private void setLvContact(View view) {
    }

}
