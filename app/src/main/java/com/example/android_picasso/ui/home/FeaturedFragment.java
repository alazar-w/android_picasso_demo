package com.example.android_picasso.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_picasso.R;
import com.example.android_picasso.utilities.FeaturedAdapter;
import com.example.android_picasso.utilities.FeaturedItem;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);


        mRecyclerView = view.findViewById(R.id.recycler_featured);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<FeaturedItem> images = new ArrayList<>();
        images.add(new FeaturedItem("ground.jpg", "The Best Coffee", "It simply doesn't get any better."));
        images.add(new FeaturedItem("table.jpg", "Stay for a While", "Have a seat and stay a while to study, read, or ponder the universe."));
        images.add(new FeaturedItem("beans.jpg", "Freshly Roasted", "Every Morning. Every Time."));
        images.add(new FeaturedItem("granola.jpg", "Healthy Bites", "Start your morning off with a healthy snack."));
        images.add(new FeaturedItem("bag.jpg", "Smells to Go", "Take home some of our best beans."));

        mAdapter = new FeaturedAdapter(getContext(), images);
        mRecyclerView.setAdapter(mAdapter);


        return view;

    }
}
