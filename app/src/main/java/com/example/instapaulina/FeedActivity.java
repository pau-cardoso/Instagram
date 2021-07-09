package com.example.instapaulina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.instapaulina.Fragments.ComposeFragment;
import com.example.instapaulina.Fragments.FeedFragment;
import com.example.instapaulina.Fragments.ProfileFragment;
import com.example.instapaulina.Models.Post;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    public static final String TAG = "FeedActivity";

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigation = findViewById(R.id.bottomNavigation);

        // handle navigation selection
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                Toast.makeText(FeedActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                                fragment = new FeedFragment();
                                break;
                            case R.id.action_compose:
                                Toast.makeText(FeedActivity.this, "New post!", Toast.LENGTH_SHORT).show();
                                fragment = new ComposeFragment();
                                break;
                            case R.id.action_profile:
                            default:
                                Toast.makeText(FeedActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                                fragment = new ProfileFragment();
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigation.setSelectedItemId(R.id.action_home);
    }
}