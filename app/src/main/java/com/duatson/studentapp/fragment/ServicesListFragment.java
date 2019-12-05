package com.duatson.studentapp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.duatson.studentapp.R;
import com.duatson.studentapp.adapter.CategoryGridAdapter;
import com.duatson.studentapp.adapter.ServiceListAdapter;
import com.duatson.studentapp.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesListFragment extends Fragment {

    // private ListView lvServicesList;
    private GridView gvCatDocs;
    private GridView gvCatLearn;

    private List<Service> services;

    public ServicesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_services_list, container, false);
        View view = inflater.inflate(R.layout.fragment_services_list, container, false);

        gvCatDocs = view.findViewById(R.id.gvCatDocs);
        gvCatLearn = view.findViewById(R.id.gvCatLearn);
        services = new ArrayList<>();

        initServiceData(view);

        gvCatDocs.setOnItemClickListener(serviceItemCLickDocs);

        return view;
    }

    private void initServiceData(View view) {
//        lvServicesList = view.findViewById(R.id.lvServicesList);

        services.add(new Service("1", "Service 123", "This is description", 1, "https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678134-sign-check-512.png", null));
        services.add(new Service("12344", "Service 2", "", 0, "https://cdn4.iconfinder.com/data/icons/small-n-flat/24/pencil-512.png", null));



        CategoryGridAdapter categoryDocsGridAdapter = new CategoryGridAdapter(getActivity(), services);
        gvCatDocs.setAdapter(categoryDocsGridAdapter);

        gvCatLearn.setAdapter(categoryDocsGridAdapter);

    }

    private GridView.OnItemClickListener serviceItemCLickDocs = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Service service = services.get(position);
            Toast.makeText(getContext(), "You Clicked " + service.getName(), Toast.LENGTH_SHORT).show();
        }
    };
}
