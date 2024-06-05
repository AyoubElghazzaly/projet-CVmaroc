package com.example.cvmaroc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;


public class mycvActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button menu;
    LinearLayout pagehome, pageads, pagelanges, sharepage, aboutpage;

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();
    static int testtt = 0;

    private DuoDrawerLayout duoDrawerLayout;
    private Button openmenudrawer;

    private LinearLayout closemenuduo;
    CardView mycardview;
    View mainContentview;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.homemycv);

        // Initialize views
        pagehome = findViewById(R.id.homepage);
        pagelanges = findViewById(R.id.traslatepage);
        pageads = findViewById(R.id.remouveads);
        sharepage = findViewById(R.id.share);
        aboutpage  = findViewById(R.id.info);

        duoDrawerLayout = findViewById(R.id.drawer_layout);
        openmenudrawer = findViewById(R.id.menu);

        mycardview = findViewById(R.id.mainContentCardView);
        closemenuduo = findViewById(R.id.btnclose_menu);
        mainContentview = findViewById(R.id.mainContentView);
        mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }});

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




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
                duoDrawerLayout.closeDrawer();
            }
        });

        pageads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mycvActivity.this, adsActivity.class);
                startActivity(intent);
            }
        });
        pagelanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mycvActivity.this, langue_Activity.class);
                startActivity(intent);            }
        });

        sharepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mycvActivity.this, ShareActivity.class);
                startActivity(intent);
            }
        });

        aboutpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mycvActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });



        viewPager2 = findViewById(R.id.viewpagerImageSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.cv1));
        sliderItems.add(new SliderItem(R.drawable.cv2));
        sliderItems.add(new SliderItem(R.drawable.namecv));
        sliderItems.add(new SliderItem(R.drawable.cv3));
        sliderItems.add(new SliderItem(R.drawable.cv4));
        sliderItems.add(new SliderItem(R.drawable.cv5));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderItems, viewPager2);
        viewPager2.setAdapter(sliderAdapter);
//        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2 ));


        sliderAdapter.setOnItemClickListener(this::onItemClick);


        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });


    }




    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }


    public void onItemClick(int position) {

//position == 0 || position == 1 || position == 2 || position == 3|| position == 4 || position == 5 || position == 6 || position == 7 || position == 8 || position == 9|| position == 10|| position == 11 || position == 12 || position == 13 || position == 14 || position == 15|| position == 16|| position == 17 || position == 18 || position == 19 || position == 20 || position == 21|| position == 22|| position == 22
        if (position != -1) {
            Intent intent = new Intent(mycvActivity.this, Home_form.class);
            startActivity(intent);
            testtt = position;
        }

    }



}

