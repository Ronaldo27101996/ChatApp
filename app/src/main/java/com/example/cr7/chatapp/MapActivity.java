package com.example.cr7.chatapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cr7.adapter.CustomInforAdapter;
import com.example.cr7.model.Conversation;
import com.example.cr7.model.UserPosition;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    public static int PERMISSION_ALL = 1;
    ArrayList<UserPosition> arrPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().hide();
        String[] PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void addControls() {
        arrPos= new ArrayList<>();
        arrPos.add(new UserPosition(10.847588, 106.775818,"Huy Duy","http://cdni.condenast.co.uk/320x480/d_f/Emma-Watson-close-up-Vogue-28Aug15-Getty_b_320x480.jpg","0.6 km"));
        arrPos.add(new UserPosition(10.845834, 106.779672, "Huong To","http://www.elle.vn/wp-content/uploads/2015/10/30/emma-stone.jpg","1 km"));
        arrPos.add(new UserPosition(10.844752, 106.785445,"Khoa Nguyen","https://genknews.genkcdn.vn/k:thumb_w/640/2015/a-1436946541628/truyen-tranh-naruto-gaara-sasuke-hai-cuoc-doi-mot-noi-dau.png","0.2km"));
        arrPos.add(new UserPosition(10.849431, 106.775127,"Tran Trinh","https://cdn1.thr.com/sites/default/files/2017/03/chris_evans_captain_america_uk_getty_h_2016.jpg","0.9 km"));
        arrPos.add(new UserPosition(10.846609, 106.773093,"Naruto","https://pbs.twimg.com/media/DX1Rd1xUMAABmVm.jpg","6.9 km"));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // Add a marker in Sydney and move the camera
        for (UserPosition user : arrPos){
            LatLng myPos = new LatLng(user.getLat(), user.getLon());
            Marker marker =mMap.addMarker(new MarkerOptions()
                    .position(myPos)
                    .title(user.getName())
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPos, 15));
            mMap.setInfoWindowAdapter(new CustomInforAdapter(MapActivity.this, user));
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return false;
            }
        });
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);




    }
}
