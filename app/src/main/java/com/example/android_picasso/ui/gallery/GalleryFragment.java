package com.example.android_picasso.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.android_picasso.R;
import com.example.android_picasso.utilities.GalleryAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//OnScrollListener -> helps us events to hook when a user starts scrolling
public class GalleryFragment extends Fragment implements AbsListView.OnScrollListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery,container,false);
        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("bag.jpg");
        imageUrls.add("beans.jpg");
        imageUrls.add("granola.jpg");
        imageUrls.add("ground.jpg");
        imageUrls.add("bagel.jpg");
        imageUrls.add("table.jpg");
        imageUrls.add("trail.jpg");
        imageUrls.add("coffee.jpg");

        GridView gridGallery = view.findViewById(R.id.grid_gallery);
        GalleryAdapter gridAdapter = new GalleryAdapter(getContext(),R.layout.gallery_item_layout,imageUrls);
        gridGallery.setAdapter(gridAdapter);
        gridGallery.setOnScrollListener(this);

        return view;

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_TOUCH_SCROLL){
            Picasso.with(getContext()).resumeTag("gallery");
        }else {
            //only we sent request if the user stops scrolling
            Picasso.with(getContext()).pauseTag("gallery");
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
