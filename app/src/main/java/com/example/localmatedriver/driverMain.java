package com.example.localmatedriver;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.localmatedriver.DriverFragments.driverHomeFragment;
import com.example.localmatedriver.DriverFragments.driverNotificationFragment;
import com.example.localmatedriver.DriverFragments.driverProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class driverMain extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);

        bottomNavigationView=findViewById(R.id.driver_bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.driver_container, new driverHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod= new
            BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment driverFragment=null;
                    switch  (menuItem.getItemId())
                    {
                        case R.id.driver_home:
                            driverFragment=new driverHomeFragment();
                            break;

                        case R.id.driver_profile:
                            driverFragment=new driverProfileFragment();
                            break;

                        case R.id.driver_notification:
                            driverFragment=new driverNotificationFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.driver_container, driverFragment).commit();
                    return true;
                }
            };

}

