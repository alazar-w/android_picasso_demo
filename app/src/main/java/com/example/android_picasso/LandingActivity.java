package com.example.android_picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android_picasso.utilities.UrlHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class LandingActivity extends AppCompatActivity {
    private Target mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        final ImageView landingLogo = findViewById(R.id.image_logo);

        mTarget = new Target() {
            //when image is retrieved successfully
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                landingLogo.setImageBitmap(bitmap);
            }

            //called when the request fails,it's more like the .error() method except instead of just giving
            //placeholder image we can run any logic we'd like.
            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(getApplicationContext(),"Your internet connection needs more espresso",Toast.LENGTH_LONG).show();

            }
            //runs before the image is loaded
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };


        //enabling picasso cache indicators
        Picasso.with(this).setIndicatorsEnabled(true);
        //enabling picasso logging
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).load("https://www.blogpreston.co.uk/wp-content/uploads/2012/06/DSCF0724-670x488.jpg").fit().centerCrop().into(mTarget);

        String[] urls = new String[]{
                "ground.jpg",
                "table.jpg",
                "beans.jpg",
                "granola.jpg",
                "bag.jpg"
        };
        //preloading images with Fetch(pre caching)
        //while the user is reading the landing activity content,picasso will secretly be caching for them ahead of time
        for (String url : urls){
            Picasso.with(this).load(UrlHelper.BaseUrl + url).fetch();
        }


    }

    public void getStarted(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
