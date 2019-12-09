package com.duatson.studentapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.duatson.studentapp.MainActivity;
import com.duatson.studentapp.NavigationHost;
import com.duatson.studentapp.R;
import com.duatson.studentapp.RequestDetailFragment;
import com.duatson.studentapp.adapter.CategoryGridAdapter;
import com.duatson.studentapp.adapter.RequestListAdapter;
import com.duatson.studentapp.application.ExpandableHeightGridView;
import com.duatson.studentapp.application.ExpandableHeightListView;
import com.duatson.studentapp.model.Request;
import com.duatson.studentapp.model.Service;
import com.duatson.studentapp.network.FirebaseDb;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {
    private DatabaseReference firebaseDb;
    private ExpandableHeightGridView gvServices;
    private TextView tvSearch;

    private List<Service> servicesCatDocs;

    // code cua SONPH
    private ExpandableHeightListView lvRequestListDashboard;
    private List<Request> requests;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }
//
//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.top_app_bar_menu_dashboard, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//            if (id == R.id.icNotification) {
//                NotificationFragment notificationFragment = new NotificationFragment();
//                ((NavigationHost) getActivity()).navigateTo(notificationFragment, true);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        setHasOptionsMenu(true);
        tvSearch = view.findViewById(R.id.tvSearch);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServicesListFragment servicesListFragment = new ServicesListFragment();
                ((NavigationHost) getActivity()).navigateTo(servicesListFragment, true);
            }
        });

        // Connect to firebase
        firebaseDb = FirebaseDb.makeDbRef("Services/learns");

        gvServices = view.findViewById(R.id.gvServices);
        gvServices.setOnItemClickListener(serviceItemCLickDocs);

        setUpRequestList(view);

        return view;
    }

    private GridView.OnItemClickListener serviceItemCLickDocs = new GridView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Service service = servicesCatDocs.get(position);

            Bundle bundle = new Bundle();
            bundle.putSerializable("service", service);

            ServiceDetailFragment serviceDetailFragment = new ServiceDetailFragment();
            serviceDetailFragment.setArguments(bundle);

            // move to service_detail_fragment
            ((NavigationHost) getActivity()).navigateTo(serviceDetailFragment, true);
        }
    };

    @Override
    public void onStart() {
        super.onStart();

        initServiceData();
    }

    private void initServiceData() {
//        lvServicesList = view.findViewById(R.id.lvServicesList);
        servicesCatDocs = new ArrayList<Service>();

        firebaseDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                servicesCatDocs.clear(); // clear all data

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Service service = snapshot.getValue(Service.class);
                    // Add to list
                    servicesCatDocs.add(service);
                    //System.out.println(snapshot.getValue());
                }

                CategoryGridAdapter categoryDocsGridAdapter = new CategoryGridAdapter(getActivity(), servicesCatDocs);
                gvServices.setAdapter(categoryDocsGridAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // do something
            }
        });
    }

    private void setUpRequestList(View view) {
        lvRequestListDashboard = view.findViewById(R.id.lvRequestListDashboard);
        lvRequestListDashboard.setOnItemClickListener(requestItemClick);
        // init list
        requests = new ArrayList<>();

        requests.add(new Request("1", "CB9WNML10", "25/12/2019", "Pending", "Note something", null));
        requests.add(new Request("1", "CB9WNML10", "25/12/2019", "Pending", "Note something", null));
        requests.add(new Request("1", "CB9WNML6", "25/12/2019", "Pending", "Note something", null));

        RequestListAdapter adapter = new RequestListAdapter(getActivity(), requests);
        lvRequestListDashboard.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener requestItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //
        }
    };

}
