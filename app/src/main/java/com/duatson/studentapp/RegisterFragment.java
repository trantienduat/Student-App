package com.duatson.studentapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

//    private Toolbar toolbar;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_register, container, false);
        View view = inflater.inflate(R.layout.fragment_register, container, false);

//        setUpTopToolBar(view);

//        toolbar.setNavigationOnClickListener(onClickToBack);

        return view;
    }

//    private void setUpTopToolBar(View view) {
//        toolbar = view.findViewById(R.id.app_top_bar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        if (activity != null) {
//            activity.setSupportActionBar(toolbar);
//        }
//    }

//    private Toolbar.OnClickListener onClickToBack = new Toolbar.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            getActivity().getSupportFragmentManager().popBackStack();
//        }
//    };
}
