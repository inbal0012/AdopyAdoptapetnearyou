package com.example.adopet_adoptapetnearyou.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adopet_adoptapetnearyou.Model.Image;
import com.example.adopet_adoptapetnearyou.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends ArrayList<Image> {
    Context context;
    int layoutResourceId;
    ArrayList<Image> data = new ArrayList<Image>();

    public ImageAdapter(Context context, int layoutResourceId, ArrayList<Image> data) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        UserHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new UserHolder();

            holder.image1 = row.findViewById(R.id.image1);

            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        Image singleImage = data.get(position);


        Picasso.get().load(singleImage.getUrl()).into(holder.image1);


        return row;
    }
    static class UserHolder{
        ImageView image1;
    }
}
