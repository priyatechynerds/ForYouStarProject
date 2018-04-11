package com.example.priya.foryoustarproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutCompany extends AppCompatActivity {
ActionBar actionBar;
Toolbar toolbar;
CardView cardOne;
TextView title,description,descriptionHeading;
ImageView imageView;
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company);

        title=(TextView)findViewById(R.id.title);
        description=(TextView)findViewById(R.id.description);
        imageView=(ImageView) findViewById(R.id.imageView);

//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        toolbar.setBackgroundColor(Color.parseColor("#f8df7b11"));
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));
        actionBar.setTitle("                     ABOUT COMPANY");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        imageView.setImageResource(R.drawable.foryou_logo);
        title.setText("ABOUT US");
        description.setText("About FORYOU\n\n" +
                "Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n\n" +
                "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities.\n \n" +
                "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, “FORYOU” is your answer for a bright, secured future with a solid business plan.\n\n\n\n\n");

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        final String[] strings=new String[]{"ABOUT US","OUR MISSION, VISION & AMBITION","LEGALS","BANKS"};
       // recyclerView.setAdapter(new HorizontalAdapter(new String[]{"ABOUT US","OUR MISSION, VISION & AMBITION","LEGALS","BANKS"}));
        recyclerView.setAdapter(new HorizontalAdapter(strings));

        recyclerView.addOnItemTouchListener(new RecycleViewClickListener(this, new RecycleViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.foryou_logo);
//                    cardOne.setVisibility(View.VISIBLE);
                        title.setText("ABOUT US");
                        description.setText("About FORYOU\n\n" +
                                "Established in 2014, “FORYOU” is India’s one of the fastest growing MLM Organisation.\n\n" +
                                "We offer a platform, a system where you can perform business activities to create your own destiny with unlimited possibilities.\n \n" +
                                "Managed by a group of seasoned professionals from Marketing, Finance, General Management & Training, “FORYOU” is your answer for a bright, secured future with a solid business plan.\n\n\n\n\n");
                    break;
                    case 1:
                        imageView.setImageResource(R.drawable.foryou_logo);
                        title.setText("OUR MISSION, VISION & AMBITION");
                        description.setText("MISSION:-\n" +
                                "Our mission is to provide a platform where business activities can be created with no impossibilities.\n\n" +
                                "VISION:-\n" +
                                "FORYOU is already India's fastest growing organization and we would like to increase our FORYOU Family.\n\n" +
                                "AMBITION:-\n" +
                                "We desire to increase this business not only in terms of physical appearance but also in the hearts of our team members.\n\n\n");
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.foryou_logo);
                        title.setText("COMPANY LEGAL PAPERS");
                        description.setText("1. ISO \n\n" +
                                "2. CENTRAL BOARD OF EXCISE & CUSTOMS\n\n" +
                                "3. TRADE LICENSE\n\n" +
                                "4. CERTIFICATE OF ENROLLMENT\n\n" +
                                "5. PAN CARD\n\n" +
                                "6. TAN DETAILS\n\n" +
                                "7. MCA CERTIFICATE\n\n" +
                                "8. GST DETAILS\n\n\n");

//                        Intent intent=new Intent(AboutCompany.this,Legals.class);
//                        startActivity(intent);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.foryou_logo);
                        title.setText("BANKS");
                        description.setText("1. For minimum eligible payout you have to do 3 direct joining & must do 1st level complete.\n\n" +
                                "2. KYC (A. Passport Photo, B. Aadhar Cars/Voter ID/Driving License, C. Pan Card, D. Bank Account/Cancel Cheque) Must be uploaded in your id & after verification  payment will be transferred to your Bank Account.\n\n" +
                                "3. Maximum 4 joining can be done against one pan card.\n\n" +
                                "4. Admin Charges: 5%, TDS: 5% (Without Pan: 10%), & id upgradation charge for next level as mentioned above.\n\n" +
                                "5. Weekly cutoff every sunday night & payment will be transferred in your bank account within 48 hours. Minimum payout of Rs.300\n\n" +
                                "6. Payment released by N.E.F.T /Paytm Wallet/Airtel Bank Account.\n\n" +
                                "7. For recharge load you have to transfer mimimum amount of Rs.1000 & send all details of transfer amount & id number to Company Whatsapp: 9002955606 & recharge load tranfer to your ID within 6 Hours.\n\n" +
                                "8. Company is not responsible for any cash transaction to any third party other than Franchise Holder.\n\n" +
                                "9. After registration confirmed, product will be provided by company within 15 business days as per location basis.\n\n" +
                                "10. Delivery charges of Rs.100 will be applicable for individual product transfer.\n\n" +
                                "11. Recharge portal maintenence balance Rs. 20.\n\n" +
                                "12. Customer can generate joining pin from his income wallet instantly.\n\n" +
                                "13. After (A+B+C)'s 3 direct joining you will be eligible for 2nd-12th level payout.\n\n" +
                                "14. Upgrade is necessary for every member in their next 11th level to get eligible for payment.\n\n" +
                                "15. Only one person can join 3 people. If you join more than 3 direct people, then you have to put position ID where you want to put his/her ID.\n\n" +
                                "16. The company reserve the Right To Modify the Terms & Conditions, Product, Scheme and Business & Policies giving prior notice through website and it will bind all distributors, Members and Executives of the company.\n\n" +
                                "17. If any legal condition arises, the members may mutual the local judicial area with the company.\n\n" +
                                "18. Cont. No.: 7719138069, 7719138358 & WhatsApp: 8450002100");
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
