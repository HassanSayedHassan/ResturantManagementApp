package com.example.cateringplatform.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cateringplatform.R;
import com.example.cateringplatform.fragment.AccountFragment;
import com.example.cateringplatform.fragment.OrderHistoryFragment;
import com.example.cateringplatform.fragment.ResturantHomeFragment;
import com.example.cateringplatform.fragment.SearchFragment;

public class ResturantName extends AppCompatActivity {

    private FrameLayout fragmentContainer;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_name);

        fragmentContainer = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.nav_bottom);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ResturantHomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){

                    case R.id.nav_res_home:
                        selectedFragment = new ResturantHomeFragment();
                        break;

                    case R.id.nav_res_search:
                        selectedFragment = new SearchFragment();
                        break;

                    case R.id.nav_res_history:
                        selectedFragment = new OrderHistoryFragment();
                        break;

                    case R.id.nav_res_account:
                        selectedFragment = new AccountFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                return true;
            }
        });
    }
}
