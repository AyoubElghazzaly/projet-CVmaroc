package com.example.cvmaroc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class AboutActivity extends AppCompatActivity {

    private DuoDrawerLayout duoDrawerLayout;
    LinearLayout pagehome, pageads, pagelanges, sharepage, aboutpage;
    private Button openmenudrawer;
    private LinearLayout closemenuduo;

    CardView mycardview;

    View mainContentview;



    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.about_page);

        duoDrawerLayout = findViewById(R.id.drawer_layout);
        openmenudrawer = findViewById(R.id.menu);

        pagehome = findViewById(R.id.homepage);
        pagelanges = findViewById(R.id.traslatepage);
        pageads = findViewById(R.id.remouveads);
        sharepage = findViewById(R.id.share);
        aboutpage  = findViewById(R.id.info);
        mycardview = findViewById(R.id.mainContentCardView);
        closemenuduo = findViewById(R.id.btnclose_menu);
        mainContentview = findViewById(R.id.mainContentView);


        // Set OnClickListener for open_menu ImageView
        openmenudrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the DuoMenuView
                duoDrawerLayout.openDrawer();
            }
        });
// Set up DuoDrawerToggle to handle drawer open/close events
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this, duoDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        duoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

        // Set up listener for drawer open/close events
        duoDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Slide offset is from 0 to 1, indicating the position of the drawer



                // Adjust the scale of the main content view
                float scale = 1 - 0.1f * slideOffset; // Adjust the scale factor as needed
                mainContentview.setScaleX(scale);
                mainContentview.setScaleY(scale);


                // Adjust the corner radius based on the slide offset

                float cornerRadius = slideOffset * getResources().getDimensionPixelSize(R.dimen.max_corner_radius);
                mycardview.setRadius(cornerRadius);
            }
        });
        closemenuduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                duoDrawerLayout.closeDrawer();
            }
        });


        pagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, mycvActivity.class);
                startActivity(intent);            }
        });

        pageads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, adsActivity.class);
                startActivity(intent);
            }
        });
        pagelanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, langue_Activity.class);
                startActivity(intent);       }
        });

        sharepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this, ShareActivity.class);
                startActivity(intent);          }
        });

        aboutpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duoDrawerLayout.openDrawer();
            }
        });



    }

}
