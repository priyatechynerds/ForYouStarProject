package com.example.priya.foryoustarproject;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class Certificates extends AppCompatActivity {
    private Certi_ExpandableListAdapter expandableListAdapter;
    private ArrayList<Teams> team=getData();
    private ExpandableListView elv;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificates);

        elv=(ExpandableListView)findViewById(R.id.expandableListView);
        //expListItems=SetStandardGroups();
        expandableListAdapter=new Certi_ExpandableListAdapter(Certificates.this,team);
        elv.setAdapter(expandableListAdapter);

//        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                return false;
//            }
//        });

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));
        actionBar.setTitle("                     CERTIFICATES");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }
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

    public ArrayList<Teams> getData(){
        Teams t1=new Teams("ISO");
        t1.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t1.players.add("TRADE LICENSE");
//        t1.players.add("CERTIFICATE OF ENROLLMENT");
//        t1.players.add("PAN CARD");
//        t1.players.add("TAN DETAILS");
//        t1.players.add("MCA CERTIFICATE");
//        t1.players.add("GST DETAILS");

        Teams t2=new Teams("CENTRAL BOARD OF EXCISE & CUSTOMS");
        t2.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t2.players.add("TRADE LICENSE");
//        t2.players.add("CERTIFICATE OF ENROLLMENT");
//        t2.players.add("PAN CARD");
//        t2.players.add("TAN DETAILS");
//        t2.players.add("MCA CERTIFICATE");
//        t2.players.add("GST DETAILS");

        Teams t3=new Teams("TRADE LICENSE");
        t3.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t3.players.add("TRADE LICENSE");
//        t3.players.add("CERTIFICATE OF ENROLLMENT");
//        t3.players.add("PAN CARD");
//        t3.players.add("TAN DETAILS");
//        t3.players.add("MCA CERTIFICATE");
//        t3.players.add("GST DETAILS");

        Teams t4=new Teams("CERTIFICATE OF ENROLLMENT");
        t4.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t4.players.add("TRADE LICENSE");
//        t4.players.add("CERTIFICATE OF ENROLLMENT");
//        t4.players.add("PAN CARD");
//        t4.players.add("TAN DETAILS");
//        t4.players.add("MCA CERTIFICATE");
//        t4.players.add("GST DETAILS");

        Teams t5=new Teams("PAN CARD");
        t5.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t5.players.add("TRADE LICENSE");
//        t5.players.add("CERTIFICATE OF ENROLLMENT");
//        t5.players.add("PAN CARD");
//        t5.players.add("TAN DETAILS");
//        t5.players.add("MCA CERTIFICATE");
//        t5.players.add("GST DETAILS");

        Teams t6=new Teams("TAN DETAILS");
        t6.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t6.players.add("TRADE LICENSE");
//        t6.players.add("CERTIFICATE OF ENROLLMENT");
//        t6.players.add("PAN CARD");
//        t6.players.add("TAN DETAILS");
//        t6.players.add("MCA CERTIFICATE");
//        t6.players.add("GST DETAILS");

        Teams t7=new Teams("MCA CERTIFICATE");
        t7.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t7.players.add("TRADE LICENSE");
//        t7.players.add("CERTIFICATE OF ENROLLMENT");
//        t7.players.add("PAN CARD");
//        t7.players.add("TAN DETAILS");
//        t7.players.add("MCA CERTIFICATE");
//        t7.players.add("GST DETAILS");

        Teams t8=new Teams("GST DETAILS");
        t8.players.add("CENTRAL BOARD OF EXCISE & CUSTOMS");
//        t8.players.add("TRADE LICENSE");
//        t8.players.add("CERTIFICATE OF ENROLLMENT");
//        t8.players.add("PAN CARD");
//        t8.players.add("TAN DETAILS");
//        t8.players.add("MCA CERTIFICATE");
//        t8.players.add("GST DETAILS");

        ArrayList<Teams> allteams=new ArrayList<Teams>();
        allteams.add(t1);
        allteams.add(t2);
        allteams.add(t3);
        allteams.add(t4);
        allteams.add(t5);
        allteams.add(t6);
        allteams.add(t7);
        allteams.add(t8);

        return  allteams;
    }
}
