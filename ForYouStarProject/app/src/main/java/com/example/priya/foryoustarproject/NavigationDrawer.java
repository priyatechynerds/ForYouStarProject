package com.example.priya.foryoustarproject;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.Toast;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridLayout mainGrid;
    CardView cardView,cardView1;
    android.support.v7.app.ActionBar actionBar;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar));
        }

        actionBar=getSupportActionBar();
        actionBar.setTitle("");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
//        ViewPager pager=(ViewPager)findViewById(R.id.viewpager);
//
//        TabPagerAdapter tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
//        pager.setAdapter(tabPagerAdapter);
//        tabLayout.setupWithViewPager(pager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.foryou_logo);


        mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
   //     setToggleEvent(mainGrid);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    Intent intent;

//    private void setToggleEvent(GridLayout mainGrid)
//    {
//
//        for(i=0;i<mainGrid.getChildCount();i++)
//        {
//            final CardView cardView=(CardView)mainGrid.getChildAt(i);
//            final int final1=i;
//
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(final1==0 && cardView.getCardBackgroundColor().getDefaultColor()==-1)
//                    {
//                        cardView.setCardBackgroundColor(Color.parseColor("#f8df7b11"));
//                        intent=new Intent(NavigationDrawer.this,AboutCompany.class);
//                        startActivity(intent);
//                    }else if(final1==1 && cardView.getCardBackgroundColor().getDefaultColor()==-1){
//                        cardView.setCardBackgroundColor(Color.parseColor("#f8df7b11"));
//                        intent=new Intent(NavigationDrawer.this,Support.class);
//                        startActivity(intent);
//                        //cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
//                    }
//                    else{
//                        cardView.setCardBackgroundColor(Color.parseColor("#f8df7b11"));
//                        intent=new Intent(NavigationDrawer.this,AboutCompany.class);
//                        startActivity(intent);
//                       // cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
//                    }
//                    if(final1==0){
//                        if(cardView.getCardBackgroundColor().getDefaultColor()==-1){
//                            cardView.setCardBackgroundColor(Color.parseColor("#f8df7b11"));
//                            intent=new Intent(NavigationDrawer.this,Main2Activity.class);
//                            startActivity(intent);
//                            cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
//                        }
//                    }
  //              }
 //           });

//         }
//    }



    private void setSingleEvent(GridLayout mainGrid){
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            cardView=(CardView)mainGrid.getChildAt(i);
            cardView1=(CardView)mainGrid.getChildAt(i);
            final int final1=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  //  Toast.makeText(NavigationDrawer.this,"clicked "+final1,Toast.LENGTH_SHORT).show();
                    if(final1==0)
                    {
                        Intent intent=new Intent(NavigationDrawer.this,AboutCompany.class);
                        startActivity(intent);
                    }
                    else if(final1==1 ){
                        intent=new Intent(NavigationDrawer.this,Support.class);
                        startActivity(intent);
                    }
                    else{
                        intent=new Intent(NavigationDrawer.this,Downloads.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
//        MenuItem item=menu.findItem(R.id.menuSearch);
//        SearchView searchView=(SearchView)item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.o1) {
           // Handle the camera action

        } else if (id == R.id.o2) {


        }else if (id == R.id.certificates) {
            startActivity(new Intent(NavigationDrawer.this,Certificates.class));

        }else if(id == R.id.blogs){
            url="https://teamforyoustar.blogspot.in/";
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

        }else if(id == R.id.website){
            url="https://www.foryoustar.com/";
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
            
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
 }

    }