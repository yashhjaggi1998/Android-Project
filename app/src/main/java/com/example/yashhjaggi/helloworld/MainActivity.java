package com.example.yashhjaggi.helloworld;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener
{

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager(), tablayout.getTabCount());

        adapter.AddFragment(new Tab1(),"");
        adapter.AddFragment(new Tab2(),"");
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_format_italic_black_24dp);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_android_black_24dp);
        //remove shadow from action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.item1) {
                    Toast.makeText(MainActivity.this, "Item1", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.item2) {
                    Toast.makeText(MainActivity.this, "Item2", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.item3) {
                    Toast.makeText(MainActivity.this, "Item3", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


    }//end of oncreate method

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction (Uri uri)
    {

    }
}
