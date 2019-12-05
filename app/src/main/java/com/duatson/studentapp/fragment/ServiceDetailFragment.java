package com.duatson.studentapp.fragment;


import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.duatson.studentapp.NavigationHost;
import com.duatson.studentapp.R;
import com.duatson.studentapp.RegisterFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceDetailFragment extends Fragment {


    private ListView lvContact;
    private MaterialButton btnRegister;
    private ImageView imgClose;

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

        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(registerCLicked);

        setLvContact(view);

        return view;
    }

    private void setLvContact(View view) {
    }

    private View.OnClickListener registerCLicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            NavigationHost navigationHost = (NavigationHost) getActivity();
//            navigationHost.navigateTo(new RegisterFragment(), true);

            //load dialog
            final Dialog registerDialog  = new Dialog(getContext());
            registerDialog.setContentView(R.layout.fragment_register);
            imgClose = registerDialog.findViewById(R.id.imgClose);
            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registerDialog.dismiss();
                }
            });

            registerDialog.show();
        }
    };

}
