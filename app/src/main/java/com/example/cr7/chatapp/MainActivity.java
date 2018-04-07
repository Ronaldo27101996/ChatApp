package com.example.cr7.chatapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cr7.adapter.AdapterConversation;
import com.example.cr7.model.Conversation;
import com.example.cr7.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Conversation> listConversation;
    private RecyclerView rvConversation;
    private AdapterConversation adapterConversation;
    ImageView imgAvatar;
    FloatingActionButton fab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        addControls();
        addEvents();
    }
    private void addEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditInfoActivity.class);
                intent.putExtra("user",new User("xuanhuong27101996@gmail.com","123", "To", "Huong", "27/10/1996", 1, "http://www.elle.vn/wp-content/uploads/2015/10/30/emma-stone.jpg"));
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        imgAvatar = findViewById(R.id.imgAvatar);
        rvConversation = findViewById(R.id.rvConversation);
        Glide.with(MainActivity.this)
                .load("http://www.elle.vn/wp-content/uploads/2015/10/30/emma-stone.jpg")
                .into(imgAvatar);
        listConversation = new ArrayList<Conversation>();
        listConversation.add(new Conversation("Huy Duy","Are you here?","http://cdni.condenast.co.uk/320x480/d_f/Emma-Watson-close-up-Vogue-28Aug15-Getty_b_320x480.jpg","53 phút",true));
        listConversation.add(new Conversation("Huong To","Are you ok?","http://www.elle.vn/wp-content/uploads/2015/10/30/emma-stone.jpg","12:12 AM",true));
        listConversation.add(new Conversation("Khoa Nguyen","Are you?","https://genknews.genkcdn.vn/k:thumb_w/640/2015/a-1436946541628/truyen-tranh-naruto-gaara-sasuke-hai-cuoc-doi-mot-noi-dau.png","Hôm Nay",true));
        listConversation.add(new Conversation("Tran Trinh","Are you ready?","https://cdn1.thr.com/sites/default/files/2017/03/chris_evans_captain_america_uk_getty_h_2016.jpg","7 thg 3",false));
        listConversation.add(new Conversation("Naruto","Are you sure?","https://pbs.twimg.com/media/DX1Rd1xUMAABmVm.jpg","3 thg 3",false));

        adapterConversation =new AdapterConversation(listConversation,MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvConversation.setLayoutManager(mLayoutManager);
        rvConversation.setAdapter(adapterConversation);
    }
}
