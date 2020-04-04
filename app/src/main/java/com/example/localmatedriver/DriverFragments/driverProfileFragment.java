package com.example.localmatedriver.DriverFragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.localmatedriver.R;
import com.example.localmatedriver.SessionManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class driverProfileFragment extends Fragment implements View.OnClickListener {

    public driverProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_driver_profile, container, false);
        final Button DriverLogout = (Button) v.findViewById(R.id.driver_logout);

        TextView fname = (TextView) v.findViewById(R.id.d_name);
        TextView uEmail = (TextView) v.findViewById(R.id.d_email);
        TextView uPhone = (TextView) v.findViewById(R.id.d_phone);
        TextView uDob = (TextView) v.findViewById(R.id.d_dob);
        DriverLogout.setOnClickListener(this);

        //Getting the drivers data from SharedPreferences SessionManager class
        SharedPreferences sm = getActivity().getSharedPreferences(SessionManager.SHARED_PREF_NAME , Context.MODE_PRIVATE);
        String name = sm.getString( SessionManager.KEY_USERNAME, "user_name");
        fname.setText(name);
        String email = sm.getString(SessionManager.KEY_EMAIL, "user_email");
        uEmail.setText(email);
        String phone = sm.getString(SessionManager.KEY_PHONENO, "user_phone");
        uPhone.setText(phone);
        String dob = sm.getString(SessionManager.KEY_DOB, "user_dob");
        uDob.setText(dob);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.driver_logout:
                SessionManager.getInstance(getContext()).logout();
        }
    }
}
