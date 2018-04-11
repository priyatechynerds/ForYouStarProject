package com.example.priya.foryoustarproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Support extends AppCompatActivity {

    ActionBar actionBar;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        actionBar=getSupportActionBar();
        actionBar.setTitle("                         SUPPORT");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        final String[] strings=new String[]{"FAQ","BLOGS","FACEBOOK","WHATSAPP GROUP","BENGALI PLAN VIDEO","HINDI PLAN VIDEO"};
        // recyclerView.setAdapter(new HorizontalAdapter(new String[]{"ABOUT US","OUR MISSION, VISION & AMBITION","LEGALS","BANKS"}));
        recyclerView.setAdapter(new HorizontalAdapter(strings));

//        Intent i;
        recyclerView.addOnItemTouchListener(new RecycleViewClickListener(this, new RecycleViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i;
                String url;
                switch (position)
                {
                    case 0:
                        break;
                    case 1:
                        url="https://teamforyoustar.blogspot.in/";
                        i=new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url="https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2Fgroups%2Fforyou.2016";
                        i=new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url="https://chat.whatsapp.com/invite/4THEG15NrEn2qGGZQC03zM";
                        i=new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 4:
                        url="https://www.youtube.com/watch?v=W-95sk3Sfu4&feature=youtu.be";
                        i=new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 5:
                        url="https://www.youtube.com/watch?v=G3hPGUxHQGU&feature=youtu.be";
                        i=new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
