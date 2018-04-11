package com.example.priya.foryoustarproject;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyNextPage extends AppCompatActivity {
ActionBar actionBar;
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_next_page);
        actionBar=getSupportActionBar();
        actionBar.hide();

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        Intent i=getIntent();
        pos=i.getExtras().getInt("position");


        final CustomAdapter adapter=new CustomAdapter(this);
        final ImageView img=(ImageView)findViewById(R.id.imgid);
        final TextView name=(TextView)findViewById(R.id.MobileName);
        final TextView price=(TextView)findViewById(R.id.MobilePrice);

        //set data
        img.setImageResource(adapter.images[pos]);
        name.setText(adapter.names[pos]);
      //  price.setText(adapter.prices[pos]);
        price.setText("Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n \n" +
                "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities. \n\n" +
                "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, " +
                "“FORYOU” is your answer for a bright, secured future with a solid business plan.\n");


//        if(adapter.names[pos]=="ABOUT US")
//        {
//            price.setText(adapter.prices[pos]);
//            price.setText("Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n \n" +
//                "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities. \n\n" +
//                "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, " +
//                "“FORYOU” is your answer for a bright, secured future with a solid business plan.\n");
//        }else if(adapter.names[pos]=="OUR VISION, MISSION & AMBITION")
//        {
//            price.setText("mission");
//        }else if(adapter.names[pos]=="LEGALS")
//        {
//            price.setText("legals");
//        }else
//        {
//            price.setText("banks");
//        }

        Button btn=(Button)findViewById(R.id.btnnext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=pos+1;

                img.setImageResource(adapter.images[position]);
                name.setText("name:" +adapter.names[position]);
           //    price.setText("price:" +adapter.prices[position]);
                price.setText("Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n \n" +
                "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities. \n\n" +
                "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, " +
                "“FORYOU” is your answer for a bright, secured future with a solid business plan.\n");

//                if(adapter.names[pos]=="ABOUT US")
//                {
//                    price.setText(adapter.prices[pos]);
//                    price.setText("Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n \n" +
//                            "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities. \n\n" +
//                            "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, " +
//                            "“FORYOU” is your answer for a bright, secured future with a solid business plan.\n");
//                }else if(adapter.names[pos]=="OUR VISION, MISSION & AMBITION")
//                {
//                    price.setText("mission");
//                }else if(adapter.names[pos]=="LEGALS")
//                {
//                    price.setText("legals");
//                }else
//                {
//                    price.setText("banks");
//                }


                if(!(position>=adapter.getCount()-1)){
                    pos+=1;

                }else {
                    pos= -1;

                }
            }
        });

    }
}
