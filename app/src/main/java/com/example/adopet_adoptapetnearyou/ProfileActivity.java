package com.example.adopet_adoptapetnearyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adopet_adoptapetnearyou.Adapters.ImageAdapter;
import com.example.adopet_adoptapetnearyou.Model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    public static final String TAG = "my_ProfileActivity";

    String markerZuckyImg = "http://a4.files.biography.com/image/upload/c_fill,cs_srgb,dpr_1.0,g_face,h_300,q_80,w_300/MTIwNjA4NjMzNjg3ODAzNDA0.jpg";
    String coverImg = "https://lh3.googleusercontent.com/IQoInMEsZsucHLfyq5OVthg4E1LXER8xjoyxrEBfZYh20y1rcdLyV5K7qPxoWg0eqPG6=s926-fcrop64=1,1fff1fc4df94e03a";

    //UI
    ImageView profileImageView;
    ImageView coverImageView;
    TextView nameTextView;
    TextView ageTextView;
    TextView distanceTextView;
    TextView activeTextView;
    TextView aboutTextView;
    ListView photosListView;
    LinearLayout getTopWrapper;

    ImageAdapter mImageAdapter;
    ArrayList<Image> profileImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        profileImages = new ArrayList<>();

        profileImages.add(new Image(markerZuckyImg));
        profileImages.add(new Image(markerZuckyImg));
        profileImages.add(new Image(markerZuckyImg));
        profileImages.add(new Image(markerZuckyImg));
        profileImages.add(new Image(markerZuckyImg));
        profileImages.add(new Image(markerZuckyImg));

        declareUIObjects();

        mImageAdapter = new ImageAdapter(this, R.layout.single_image, profileImages);
        photosListView.setAdapter(mImageAdapter);

        Picasso.with(this).load(markerZuckyImg).transform(new CircleTransform()).into(profileImageView);
        Picasso.with(this).load(coverImg).transform(new BlurTransform(this)).into(coverImageView);

        nameTextView.setText("Keith");
        ageTextView.setText(", 21");
        distanceTextView.setText("12 kilometers away");
        activeTextView.setText("Active 13 minutes ago");
        aboutTextView.setText("I like pizza");

        int topWrapperHeight = getTopWrapper.getHeight();
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getTopWrapper.getLayoutParams();
//        lp.height = topWrapperHeight;
//        getTopWrapper.setLayoutParams(lp);
        setListViewHeightBasedOnChildren(photosListView);

        Log.d(TAG, "[" + String.valueOf(topWrapperHeight) + "]");

    }
}
