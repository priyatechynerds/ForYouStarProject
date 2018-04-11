package com.example.priya.foryoustarproject;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar,progressBar1;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.hide();

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

     //   gifImageView=(GifImageView)findViewById(R.id.gif) ;
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
//        progressBar=(ProgressBar)findViewById(R.id.bar) ;
//        progressBar.setVisibility(progressBar.VISIBLE);
        progressBar1=(ProgressBar)findViewById(R.id.progressBar) ;
        progressBar1.setVisibility(progressBar.VISIBLE);

//        try{
//            InputStream inputStream=getAssets().open("star.gif");
//            byte[] bytes= IOUtils.toByteArray(inputStream);
//            gifImageView.setBytes(bytes);
//            gifImageView.startAnimation();
//        }catch(Exception ex)
//        {
//
//        }

        //after waiting for 4 sec
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i=new Intent(MainActivity.this,WelcomeActivity.class);
//                startActivity(i);
//                finish();
//            }
//        },4000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();

    }

    private void doWork(){
        for(int progress=0;progress<100;progress+=10){
            try{
                Thread.sleep(1000);
                progressBar1.setProgress(progress);
            }catch (Exception e)
            {
                e.getMessage();
            }
        }
    }

    private void startApp(){
        Intent i=new Intent(MainActivity.this,WelcomeActivity.class);
        startActivity(i);
    }
}
