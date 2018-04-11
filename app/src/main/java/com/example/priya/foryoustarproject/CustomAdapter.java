package com.example.priya.foryoustarproject;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PRIYA on 3/20/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    String[] names={"ABOUT US","OUR VISION, MISSION & AMBITION","LEGALS","BANKS"};
    String[] prices={"Touch to see","Touch to see","Touch to see","Touch to see"};
    int [] images={ R.drawable.foryou_logo,
                    R.drawable.ic_file_download,
                    R.drawable.foryou_logo,
                    R.drawable.ic_file_download};

    public CustomAdapter(Context ctx)
    {
        this.c=ctx;

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int pos) {
        return names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertview, ViewGroup viewGroup) {
        if(convertview==null)
        {
            LayoutInflater inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflater.inflate(R.layout.about_company,null);
        }

        //get view
        TextView name=(TextView)convertview.findViewById(R.id.name);
        TextView price=(TextView)convertview.findViewById(R.id.price);
        ImageView imgid=(ImageView) convertview.findViewById(R.id.imgid);

        //set data
        name.setText(names[pos]);
        price.setText(prices[pos]);
        imgid.setImageResource(images[pos]);

        return convertview;
    }
}
