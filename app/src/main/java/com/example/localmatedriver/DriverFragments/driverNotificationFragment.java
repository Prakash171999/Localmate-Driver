package com.example.localmatedriver.DriverFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.localmatedriver.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class driverNotificationFragment extends Fragment {

    public driverNotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver_notification, container, false);
    }
}
