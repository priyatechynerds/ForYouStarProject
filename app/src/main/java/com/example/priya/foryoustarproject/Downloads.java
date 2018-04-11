package com.example.priya.foryoustarproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class Downloads extends AppCompatActivity {

    ActionBar actionBar;
    RecyclerView recyclerView;
    TextView description, descriptionHeading;
    PDFView pdfView;
    CardView cardView, cardView1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);

        actionBar = getSupportActionBar();
        actionBar.setTitle("                            PLANS");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        description = (TextView) findViewById(R.id.description);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        cardView=(CardView)findViewById(R.id.business);
        cardView1=(CardView)findViewById(R.id.joining);
//        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
//        setSingleEvent(mainGrid);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        final String[] strings = new String[]{"             BUSINESS PLAN            ", "        JOINING FORM        "};
//        // recyclerView.setAdapter(new HorizontalAdapter(new String[]{"ABOUT US","OUR MISSION, VISION & AMBITION","LEGALS","BANKS"}));
//        recyclerView.setAdapter(new HorizontalAdapter(strings));

//        recyclerView.addOnItemTouchListener(new RecycleViewClickListener(this, new RecycleViewClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent i;
//                String url;
//                switch (position) {
//
//            }
//        }));


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Downloads.this,PDFViewer.class));
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Downloads.this,JoiningForm.class));
            }
        });

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
