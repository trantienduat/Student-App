package com.duatson.studentapp.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.duatson.studentapp.NavigationHost;
import com.duatson.studentapp.R;
import com.duatson.studentapp.RegisterFragment;
import com.duatson.studentapp.adapter.ContactAdapter;
import com.duatson.studentapp.application.ExpandableHeightListView;
import com.duatson.studentapp.model.Service;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceDetailFragment extends Fragment {


    private ExpandableHeightListView lvContact;
    private MaterialButton btnRegister;

    private Service service;

    private BottomSheetBehavior bottomSheetBehavior;

    public ServiceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_service_detail, container, false);
        View view = inflater.inflate(R.layout.fragment_service_detail, container,false);
        lvContact = view.findViewById(R.id.lvContact);

        initServiceData(view);

        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(registerCLicked);


        setLvContact(view);

        return view;
    }

    private Service getDataFromClick() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            return (Service) bundle.getSerializable("service");
        }
        return null;
    }

    @SuppressLint("DefaultLocale")
    private void initServiceData(View view) {
        service = getDataFromClick();
        if (service != null) {
            TextView tvServiceTitle = view.findViewById(R.id.tvServiceTitle);
            tvServiceTitle.setText(service.getName());

            TextView tvServiceDescription = view.findViewById(R.id.tvServiceDescription);
            tvServiceDescription.setText(service.getDescription());

            TextView tvServiceFee = view.findViewById(R.id.tvServiceFee);
            tvServiceFee.setText(String.format("%.2f", service.getFee()));
        }
    }

    private void setLvContact(View view) {
        List<String> contacts = new ArrayList<>();
        contacts.add("helper@helper.com");
        contacts.add("1234567988");

        ContactAdapter contactAdapter = new ContactAdapter(getActivity(), contacts);
        lvContact.setAdapter(contactAdapter);
    }

    private View.OnClickListener registerCLicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NavigationHost navigationHost = (NavigationHost) getActivity();
            navigationHost.navigateTo(new RegisterFragment(), true);
        }
    };

}
