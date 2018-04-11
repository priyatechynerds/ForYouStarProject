package com.example.priya.foryoustarproject;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class BankDetails extends AppCompatActivity {

    TextView bank1,bank2,bank3,bank4,bank5,bank6,bank7;
    TextView d_idbi,d_sbi,d_andhra,d_boi,d_bandhan,d_paytm,d_airtel;
    ImageView idbi,sbi,andhra,boi,bandhan,paytm,airtel;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));
        actionBar.setTitle("                     BANK DETAILS");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        bank1=(TextView)findViewById(R.id.bank1);
        bank2=(TextView)findViewById(R.id.bank2);
        bank3=(TextView)findViewById(R.id.bank3);
        bank4=(TextView)findViewById(R.id.bank4);
        bank5=(TextView)findViewById(R.id.bank5);
        bank6=(TextView)findViewById(R.id.bank6);
        bank7=(TextView)findViewById(R.id.bank7);

        d_idbi=(TextView)findViewById(R.id.d_idbi);
        d_sbi=(TextView)findViewById(R.id.d_sbi);
        d_andhra=(TextView)findViewById(R.id.d_andhra);
        d_boi=(TextView)findViewById(R.id.d_boi);
        d_bandhan=(TextView)findViewById(R.id.d_bandhan);
        d_paytm=(TextView)findViewById(R.id.d_paytm);
        d_airtel=(TextView)findViewById(R.id.d_airtel);

        idbi=(ImageView)findViewById(R.id.idbi);
        sbi=(ImageView)findViewById(R.id.sbi);
        andhra=(ImageView)findViewById(R.id.andhra);
        boi=(ImageView)findViewById(R.id.boi);
        bandhan=(ImageView)findViewById(R.id.bandhan);
        paytm=(ImageView)findViewById(R.id.paytm);
        airtel=(ImageView)findViewById(R.id.airtel);

        bank1.setText("1. IDBI BANK");
        idbi.setImageResource(R.drawable.idbi);
        d_idbi.setText("1. A/C NO:- 0420102000010991\n" +
                "2. A/C NAME:- FOR YOU\n" +
                "3. IFSC CODE:- IBKL0000420\n");

        bank2.setText("2. STATE BANK OF INDIA");
        sbi.setImageResource(R.drawable.sbi);
        d_sbi.setText("1. A/C NO:- 35346027442\n" +
                "2. A/C NAME:- STRIKING ONLINE SERVICE & SHOPPING PVT. LTD.\n" +
                "3. IFSC CODE:- SBIN0014097\n");

        bank3.setText("3. ANDHRA BANK");
        andhra.setImageResource(R.drawable.andhra);
        d_andhra.setText("1. A/C NO:- 214211100000885\n" +
                "2. A/C NAME:- STRIKING ONLINE SERVICE & SHOPPING PVT. LTD.\n" +
                "3. IFSC CODE:- ANDB0002142\n");

        bank4.setText("4. BANK OF INDIA");
        boi.setImageResource(R.drawable.boi);
        d_boi.setText("1. A/C NO:- 431020110000249\n" +
                "2. A/C NAME:- STRIKING ONLINE SERVICE & SHOPPING PVT. LTD.\n" +
                "3. IFSC CODE:- BKID0004310\n");

        bank5.setText("5. BANDHAN BANK");
        bandhan.setImageResource(R.drawable.bandhan);
        d_bandhan.setText("1. A/C NO:- 10160006173520\n" +
                "2. A/C NAME:- FOR YOU\n" +
                "3. IFSC CODE:- BDBL0001044\n");

        bank6.setText("6. PAYTM PAYMENTS BANK");
        paytm.setImageResource(R.drawable.paytm);
        d_paytm.setText("1. A/C NO:- 919609021662\n" +
                "2. IFSC CODE:- PYTM0123456\n");

        bank7.setText("7. AIRTEL PAYMENTS BANK");
        airtel.setImageResource(R.drawable.airtel);
        d_airtel.setText("1. A/C NO:- 9002955606\n" +
                "2. IFSC CODE:- AIRP0000001\n");
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
