package com.example.android.idaayuanila_1202150280_modul6;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
public static String uid;
public static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid().toString();
        email = user.getEmail().toString();

        //untuk button floating action
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Upload.class));
            }
        });
        //memberikan nama ditab nya
        tabLayout=(TabLayout)findViewById((R.id.tabLayout));
        tabLayout.addTab(tabLayout.newTab().setText("Timeline"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //untuk membuat adapter supaya fragment nya jalan
        final ViewPager viewPager=(ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter= new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        //untuk memilih tab yang ada
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            //ini kalau dipillih
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            //ini kalau tidak dipilih
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            //ini untuk mengulang memilih
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override

    //untuk tampilan signout pada pojok kanan atas
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);

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
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(this, Login.class);
            startActivity(i);


            return true;

        }

        return super.onOptionsItemSelected(item);

    }
}
