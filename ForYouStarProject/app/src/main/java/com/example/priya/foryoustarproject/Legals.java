package com.example.priya.foryoustarproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Legals extends AppCompatActivity {
    HashMap<String, List<String>> myHeader;
    List<String> myChild;
    private int []images=new int[]{R.drawable.foryou_logo,R.drawable.ic_file_download,
            R.drawable.foryou_logo,R.drawable.ic_file_download,
            R.drawable.foryou_logo,R.drawable.ic_file_download,
            R.drawable.foryou_logo,R.drawable.ic_file_download};
    ExpandableListView expList;
    MyAdapter adapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legals);

       // expList = (ExpandableListView) findViewById(R.id.idListView);
        myHeader = MyAdapter.DataProvider.getInfo();
        myChild = new ArrayList<String>(myHeader.keySet());
        adapter = new MyAdapter(this, myHeader, myChild);
//        expList.setAdapter(adapter);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));
        actionBar.setTitle("                      CERTIFICATES");

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
}
    class MyAdapter extends BaseExpandableListAdapter {

        private Context ctx;
        private HashMap<String, List<String>> ChildTitles;
        private List<String> HeaderTitles;

        MyAdapter(Context ctx, HashMap<String, List<String>> ChildTitles, List<String> HeaderTitles) {
            this.ctx = ctx;
            this.ChildTitles = ChildTitles;
            this.HeaderTitles = HeaderTitles;

        }

        @Override
        public int getGroupCount() {
            return HeaderTitles.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return ChildTitles.get(HeaderTitles.get(i)).size();
        }

        @Override
        public Object getGroup(int i) {
            return HeaderTitles.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return ChildTitles.get(HeaderTitles.get(i)).get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            String title = (String) this.getGroup(i);
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_header, null);
            }
//        //    TextView txt = (TextView) view.findViewById(R.id.idTitle);
//            txt.setTypeface(null, Typeface.BOLD);
//            txt.setText(title);
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            String title = (String) this.getChild(i, i1);
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_childitems, null);
            }
//            TextView txt = (TextView) view.findViewById(R.id.idChild);
//            txt.setText(title);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.ic_file_download);
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

        public static class DataProvider {
            public static HashMap<String, List<String>> getInfo() {
                HashMap<String, List<String>> HeaderDetails = new HashMap<String, List<String>>();
                List<String> ChildDetails1 = new ArrayList<String>();
                ChildDetails1.add("kjzsdcbksj");


                List<String> ChildDetails2 = new ArrayList<String>();
                ChildDetails2.add("kjzsdcbksj");

                List<String> ChildDetails3 = new ArrayList<String>();
                ChildDetails3.add("kjzsdcbksj");

                List<String> ChildDetails4 = new ArrayList<String>();
                ChildDetails4.add("kjzsdcbksj");

                List<String> ChildDetails5 = new ArrayList<String>();
                ChildDetails5.add("kjzsdcbksj");

                List<String> ChildDetails6 = new ArrayList<String>();
                ChildDetails6.add("kjzsdcbksj");

                List<String> ChildDetails7 = new ArrayList<String>();
                ChildDetails7.add("kjzsdcbksj");

                List<String> ChildDetails8 = new ArrayList<String>();
                ChildDetails8.add("kjzsdcbksj");

                HeaderDetails.put("ISO ", ChildDetails1);
                HeaderDetails.put("CENTRAL BOARD OF EXCISE & CUSTOMS", ChildDetails2);
                HeaderDetails.put("TRADE LICENSE", ChildDetails3);
                HeaderDetails.put("CERTIFICATE OF ENROLLMENT", ChildDetails4);
                HeaderDetails.put("PAN CARD", ChildDetails5);
                HeaderDetails.put("TAN DETAILS", ChildDetails6);
                HeaderDetails.put("MCA CERTIFICATE", ChildDetails7);
                HeaderDetails.put("GST DETAILS", ChildDetails8);

                return HeaderDetails;
            }
        }

    }