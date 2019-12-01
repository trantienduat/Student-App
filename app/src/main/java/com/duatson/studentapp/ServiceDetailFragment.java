package com.duatson.studentapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


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
        String[] name = {"Apple", "Banana", "Orange"};
        String[] info = {"Great", "Awesome", "Perfect"};
        Integer[] img = {R.drawable.ic_arrow_back, R.drawable.ic_menu, R.drawable.ic_send};

        CustomListAdapter customList = new CustomListAdapter(getActivity(), name, info, img);
        lvContact = view.findViewById(R.id.lvContact);
        lvContact.setAdapter(customList);
    }

}
