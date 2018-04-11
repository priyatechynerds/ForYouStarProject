package com.example.priya.foryoustarproject;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class JoiningForm extends AppCompatActivity {

    PDFView pdfView;
    long queueid;
    DownloadManager dm;
    ActionBar actionBar;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joining_form);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f8df7b11")));
        actionBar.setTitle("JOINING FORM");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("joining_form.pdf").load();

        //     download=(Button)findViewById(R.id.download);
        BroadcastReceiver receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action))
                {
                    DownloadManager.Query req_query=new DownloadManager.Query();
                    req_query.setFilterById(queueid);

                    Cursor c=dm.query(req_query);
                    if(c.moveToFirst())
                    {
                        int columnIndex=c.getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if(DownloadManager.STATUS_SUCCESSFUL==c.getInt(columnIndex))
                        {
                            String uri=c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                        }
                    }
                }
            }
        };
        registerReceiver(receiver,new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_download,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            this.finish();
        }
        if (id == R.id.menuDownload)
        {
            Download_Click();
            //  return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Download_Click()
    {
        dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("https://www.foryoustar.com/download/joining_form.pdf"));

        queueid=dm.enqueue(request);
    }
}
