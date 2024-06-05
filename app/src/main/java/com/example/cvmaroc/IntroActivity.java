package com.example.cvmaroc;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.LENGTH_LONG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;

public class IntroActivity extends AppCompatActivity {
    private RewardedAd rewardedAd;
    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        MobileAds.initialize(this, initializationStatus -> {
        });
        loadRed();
        Button button = (Button) findViewById(R.id.button); // Trouver le bouton par son id
        // Définir un écouteur pour le bouton
        button.setOnClickListener(v -> {


            if (rewardedAd != null) {
                rewardedAd.show(IntroActivity.this, rewardItem -> {
                    // Handle reward earned by the user.
                    Log.d(TAG, "The user earned the reward.");



                });
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdClicked() {
                        // Called when a click is recorded for an ad.

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        // Set the ad reference to null so you don't show the ad a second time.

                        Intent intent = new Intent(IntroActivity.this, mycvActivity.class);
                        // You can handle the case where the ad isn't ready yet, maybe by showing a message to the user.
                        startActivity(intent);
                        loadRed();


                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        // Called when ad fails to show.

                        rewardedAd=null;
                        Intent intent = new Intent(IntroActivity.this, mycvActivity.class);
                        // You can handle the case where the ad isn't ready yet, maybe by showing a message to the user.
                        startActivity(intent);


                    }

                    @Override
                    public void onAdImpression() {
                        // Called when an impression is recorded for an ad.
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when ad is shown.


                    }
                });
            } else {

                Intent intent = new Intent(IntroActivity.this, mycvActivity.class);
                // You can handle the case where the ad isn't ready yet, maybe by showing a message to the user.
                startActivity(intent);
            }
        });

    }



    public void loadRed(){
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        rewardedAd=null;

                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                        ServerSideVerificationOptions options = new ServerSideVerificationOptions
                                .Builder()
                                .setCustomData("SAMPLE_CUSTOM_DATA_STRING")
                                .build();
                        rewardedAd.setServerSideVerificationOptions(options);
                    }
                });

    }

}
