package com.example.cvmaroc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.cvmaroc.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Locale;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class langue_Activity extends AppCompatActivity {

    private DuoDrawerLayout duoDrawerLayout;
    LinearLayout pagehome, pageads, pagelanges, sharepage, aboutpage;
    Button openmenudrawer,select;
    private LinearLayout closemenuduo;

    CardView mycardview;

    View mainContentview;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langue_page);


        duoDrawerLayout = findViewById(R.id.drawer_layout);
        // Initialisation des vues
        radioGroup = findViewById(R.id.rdgrp);

        select = findViewById(R.id.select);

        openmenudrawer = findViewById(R.id.menu);

        pagehome = findViewById(R.id.homepage);
        pagelanges = findViewById(R.id.traslatepage);
        pageads = findViewById(R.id.remouveads);
        sharepage = findViewById(R.id.share);
        aboutpage  = findViewById(R.id.info);
        mycardview = findViewById(R.id.mainContentCardView);
        closemenuduo = findViewById(R.id.btnclose_menu);
        mainContentview = findViewById(R.id.mainContentView);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String languageToLoad = Locale.getDefault().getLanguage();

                // Utilisation de if-else pour gérer les sélections
                if (selectedId == R.id.eng) {
                    languageToLoad = "en";
                } else if (selectedId == R.id.ar) {
                    languageToLoad = "ar";
                } else if (selectedId == R.id.fr) {
                    languageToLoad = "fr";
                }

                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                // Refresh your activity
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

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
                Intent intent = new Intent(langue_Activity.this, mycvActivity.class);
                startActivity(intent);            }
        });

        pageads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(langue_Activity.this, adsActivity.class);
                startActivity(intent);
            }
        });
        pagelanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duoDrawerLayout.closeDrawer();          }
        });

        sharepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(langue_Activity.this, ShareActivity.class);
                startActivity(intent);
            }
        });

        aboutpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(langue_Activity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }


}
