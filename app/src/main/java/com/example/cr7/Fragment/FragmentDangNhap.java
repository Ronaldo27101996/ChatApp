package com.example.cr7.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cr7.chatapp.DrawerActivity;
import com.example.cr7.chatapp.R;

/**
 * Created by vinhtruong on 3/18/2018.
 */

public class FragmentDangNhap extends Fragment {
    Button btnDangNhap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment_dangnhap,container,false);
        addControls(view);
        addEvents();
        return view;
    }

    private void addEvents() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), DrawerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls(View view) {
        btnDangNhap = view.findViewById(R.id.btnDangNhap);

    }
}
