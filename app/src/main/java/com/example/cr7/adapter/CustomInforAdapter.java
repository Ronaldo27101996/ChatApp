package com.example.cr7.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cr7.chatapp.R;
import com.example.cr7.model.UserPosition;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by CR7 on 3/12/2018.
 */

public class CustomInforAdapter implements GoogleMap.InfoWindowAdapter {
    Activity context;
    UserPosition userPos;

    public CustomInforAdapter(Activity context, UserPosition userPos) {
        this.context = context;
        this.userPos = userPos;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(R.layout.item_usermap,null);
        ImageView imgAva= row.findViewById(R.id.imgAvatar);
        Glide.with(context)
                .load(userPos.getImage())
                .into(imgAva);
        return row;
    }
}
