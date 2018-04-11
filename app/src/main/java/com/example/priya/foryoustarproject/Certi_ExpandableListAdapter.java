package com.example.priya.foryoustarproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PRIYA on 3/31/2018.
 */

public class Certi_ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Teams> teams;

    public Certi_ExpandableListAdapter(Context context,ArrayList<Teams> teams){
        this.context=context;
        this.teams=teams;
    }
    @Override
    public int getGroupCount() {
        return teams.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return teams.get(i).players.size();
    }

    @Override
    public Object getGroup(int i) {
        return teams.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
      //  ArrayList<Certificates_Child> chList=groups.get(i).getItems();
        return teams.get(i).players.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
      //  Certificates_Group group=(Certificates_Group)getGroup(i);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_header, null);
        }

        Teams t=(Teams)getGroup(i);
        TextView nameTv = (TextView) view.findViewById(R.id.textView1);
        ImageView img = (ImageView) view.findViewById(R.id.imageView1);

        String name=t.name;
        nameTv.setText(name);

//        if(name=="ISO")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="CENTRAL BOARD OF EXCISE & CUSTOMS")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="TRADE LICENSE")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="CERTIFICATE OF ENROLLMENT")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="PAN CARD")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="TAN DETAILS")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else if(name=="MCA CERTIFICATE")
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }else
//        {
//            img.setImageResource(R.drawable.foryou_logo);
//        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
      //  Certificates_Child child=(Certificates_Child)getChild(i,i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_childitems, null);
        }
        String child=(String)getChild(i,i1);
        TextView nameTv = (TextView) view.findViewById(R.id.textView1);
        ImageView img = (ImageView) view.findViewById(R.id.imageView1);

//        nameTv.setText(child);

        String teamName=getGroup(i).toString();

        if(teamName=="ISO")
        {
            img.setImageResource(R.drawable.iso);
        }
        else if(teamName=="CENTRAL BOARD OF EXCISE & CUSTOMS")
        {
            img.setImageResource(R.drawable.excise);
        }
        else if(teamName=="TRADE LICENSE")
        {
            img.setImageResource(R.drawable.trade);
        }
        else if(teamName=="CERTIFICATE OF ENROLLMENT")
        {
            img.setImageResource(R.drawable.enrollment);
        }
        else if(teamName=="PAN CARD")
        {
            img.setImageResource(R.drawable.pan_card);
        }
        else if(teamName=="TAN DETAILS")
        {
            img.setImageResource(R.drawable.tan_details);
        }
        else if(teamName=="MCA CERTIFICATE")
        {
            img.setImageResource(R.drawable.mca);
        }
        else
        {
            img.setImageResource(R.drawable.gst);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
