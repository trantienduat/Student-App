package com.duatson.studentapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.duatson.studentapp.MainActivity;
import com.duatson.studentapp.NavigationHost;
import com.duatson.studentapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends Fragment {

    private NavigationHost navigationHost;
    private FragmentManager manager;

    public BottomNavigation() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bottom_navigation, container, false);

        BottomNavigationView navigationView = view.findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigationHost = (NavigationHost) getActivity();
        manager = getActivity().getSupportFragmentManager();

        return view;
    }

        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profile:
                        //toolbar.setTitle("Profile");
                        navigationHost.navigateTo(new ProfileFragment(), true);
                        return true;
                    case R.id.dashboard:
                        //toolbar.setTitle("Dashboard");
                        navigationHost.navigateTo(new DashboardFragment(), true);
                        return true;
                    case R.id.filter1:
                        navigationHost.navigateTo(new ServiceDetailFragment(), true);
                        return true;
                }

                return false;
            }
    };
}
