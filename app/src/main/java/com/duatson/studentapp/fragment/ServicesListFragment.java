package com.duatson.studentapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.duatson.studentapp.R;
import com.duatson.studentapp.adapter.ServiceListAdapter;
import com.duatson.studentapp.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesListFragment extends Fragment {

    ListView lvServicesList;

    public ServicesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_services_list, container, false);
        View view = inflater.inflate(R.layout.fragment_services_list, container, false);

        lvServicesList = view.findViewById(R.id.lvServicesList);

        List<Service> services = new ArrayList<>();
        services.add(new Service("1234", "Service 1"));
        services.add(new Service("12344", "Service 2"));

        ServiceListAdapter serviceListAdapter = new ServiceListAdapter(this.getActivity(), services);
        lvServicesList.setAdapter(serviceListAdapter);

        return view;
    }

}
