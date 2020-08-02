package com.example.android_picasso.ui.company;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.android_picasso.R;
import com.squareup.picasso.Picasso;

public class CompanyFragment extends Fragment {

    private CompanyViewModel mCompanyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_company,container,false);
        ImageView imageBanner = view.findViewById(R.id.image_banner);
        Picasso.with(getContext()).load(R.drawable.beans).fit().centerCrop().into(imageBanner);

        ImageView imgAboutOne = view.findViewById(R.id.image_about_one);
        ImageView imgAboutTwo = view.findViewById(R.id.image_about_two);
        ImageView imgAboutThree = view.findViewById(R.id.image_about_three);

        Picasso.with(getContext()).load(R.drawable.ic_check).resize(96,96).placeholder(R.drawable.ic_check).into(imgAboutOne);
        Picasso.with(getContext()).load(R.drawable.ic_check).placeholder(R.drawable.ic_check).into(imgAboutTwo);
        Picasso.with(getContext()).load(R.drawable.ic_check).placeholder(R.drawable.ic_check).into(imgAboutThree);

        Button btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });




        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri imgUri = data.getData();
        ImageView imgPreview = getActivity().findViewById(R.id.image_submission);
        Picasso.with(getContext()).load(imgUri).into(imgPreview);
    }
}
