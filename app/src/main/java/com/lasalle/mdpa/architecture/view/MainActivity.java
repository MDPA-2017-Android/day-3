package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.view.adapter.MovieListAdapter;
import com.lasalle.mdpa.architecture.view.adapter.TabAdapter;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LibraryViewModel libraryViewModel = ViewModelProviders.of(this).get(LibraryViewModel.class);
        libraryViewModel.setResources(getResources());

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
