package com.lasalle.mdpa.architecture.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;

import java.util.List;

public class TvShowsFragment extends Fragment {

    private LibraryViewModel libraryViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        libraryViewModel = ViewModelProviders.of(getActivity()).get(LibraryViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tvshow_fragment, container, false);

        setupListView(view);

        return view;
    }

    private void populateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

    private void setupListView(View view) {
        libraryViewModel.getTvShowTitleList().observe(this, tvShowList -> {
            ListView tvShowListView = (ListView) view.findViewById(R.id.shows_list);
            populateListView(tvShowListView, tvShowList);
        });
    }
}
