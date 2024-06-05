package com.example.cvmaroc;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

public class Other_Info extends AppCompatActivity {
    Button component5, component6, component7, component8, retour, addbtn, addbtn2, pass, btnhobise;
    EditText rectangle1;
    TextView textView11, textView12;
    LinearLayout layout1, layout2, layout3, layout12, skilled, langues3, l_hobisse;
    Spinner levellang, levellang2, levellang3;
    EditText lg1, lg2, lg3;
    private InterstitialAd mInterstitialAd;
    EditText aboutEdit;
    Button btnsave;

    MyDataUser dtUserOther;
    public static int keytestlg = 1;
    public static int nbrskills = 0;
    public static int COMPTEUR_SK = 1 ;
    public static int COMPTEUR_Ho = 1 ;

//    public static boolean TST_CV_VIEW = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_others);

        dtUserOther = new MyDataUser(this, "dataUserInfo", null, 8);


        component5 = (Button) findViewById(R.id.component_5);
        component6 = (Button) findViewById(R.id.component_6);
        component7 = (Button) findViewById(R.id.component_7);
        component8 = (Button) findViewById(R.id.component_8);
        pass = (Button) findViewById(R.id.other_experience);
        rectangle1 = (EditText) findViewById(R.id.rectangle_1);
        retour = (Button) findViewById(R.id.retour3);
        addbtn = (Button) findViewById(R.id.addbtn);
        addbtn2 = (Button) findViewById(R.id.addbtn2);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        layout12 = (LinearLayout) findViewById(R.id.layout22);
        skilled = (LinearLayout) findViewById(R.id.skilled);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        levellang = findViewById(R.id.levellang);
        levellang2 = findViewById(R.id.levellang2);
        levellang3 = findViewById(R.id.levellang3);
        langues3 = findViewById(R.id.langues3);
        btnhobise = findViewById(R.id.component_hs);
        l_hobisse = findViewById(R.id.hobisse);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
//
        String str =dtUserOther.GetUserEducation().size()+" "+
                dtUserOther.GetUserWork().size()+" "+
                dtUserOther.GetUserAbout().size()+" "+
                dtUserOther.GetUserHobby().size()+" "+
                dtUserOther.GetUserSkills().size()+" "+
                dtUserOther.GetLanguesUser().size();

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
//        if (Education_activiter.keytest == 2){
//            Toast.makeText(this, "2222222222222", Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(this,String.valueOf(dtUserOther.GetUserInfo().size()) , Toast.LENGTH_SHORT).show();
//
//        TextView nametv = findViewById(R.id.create_new_);
//
//        nametv.setText(dtUserOther.GetUserInfo().get(dtUserOther.GetUserInfo().size() - 1).name + " " + dtUserOther.GetUserInfo().get(dtUserOther.GetUserInfo().size() - 1).surname);

        Button addOther = findViewById(R.id.component_7);
        addOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                component6.setVisibility(View.VISIBLE);
                addbtn2.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.VISIBLE);
                addOther.setVisibility(View.GONE);
            }
        });



        component8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Retrieve the text from the EditText
                LinearLayout newLayout = new LinearLayout(Other_Info.this);
                newLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                newLayout.setOrientation(LinearLayout.VERTICAL);
                newLayout.setGravity(Gravity.CENTER);

                // Create a new TextView
                TextView textView = new TextView(Other_Info.this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(182, LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER);
                textView.setText("Skill "+COMPTEUR_SK);
                textView.setTextAppearance(Other_Info.this, R.style.company_nam);

                // Create a new EditText
                EditText editText = new EditText(Other_Info.this);
                editText.setLayoutParams(new LinearLayout.LayoutParams(850, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText.setEms(10);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                editText.setBackgroundResource(R.drawable.component_9); // Replace with the color or drawable you want


                // Add the TextView and EditText to the new layout
                newLayout.addView(textView);
                newLayout.addView(editText);

                // Add the new layout to the parent layout
                skilled.addView(newLayout);

                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!TextUtils.isEmpty(editText.getText().toString())) {
                            dtUserOther.AjouterSkills(editText.getText().toString());
                        }
                    }
                });



                COMPTEUR_SK++ ;


            }
        });


        ArrayList<String> mySkills = new ArrayList<>();

        btnhobise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Retrieve the text from the EditText
                LinearLayout newLayout = new LinearLayout(Other_Info.this);
                newLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                newLayout.setOrientation(LinearLayout.VERTICAL);
                newLayout.setGravity(Gravity.CENTER);

                // Create a new TextView
                TextView textView = new TextView(Other_Info.this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(182, LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER);
                textView.setText("Hobby "+COMPTEUR_Ho);
                textView.setTextAppearance(Other_Info.this, R.style.company_nam);

                // Create a new EditText
                EditText editText = new EditText(Other_Info.this);
                editText.setLayoutParams(new LinearLayout.LayoutParams(850, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText.setEms(10);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                editText.setBackgroundResource(R.drawable.component_9); // Replace with the color or drawable you want


                // Add the TextView and EditText to the new layout
                newLayout.addView(textView);
                newLayout.addView(editText);

                // Add the new layout to the parent layout
                l_hobisse.addView(newLayout);

                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!TextUtils.isEmpty(editText.getText().toString())) {
                            dtUserOther.AjouterHobby(editText.getText().toString());
                        }
                    }
                });




                COMPTEUR_Ho++ ;

            }
        });
        Button remouv = (Button) findViewById(R.id.remouv_ed);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout12.getVisibility() == View.GONE) {
                    layout12.setVisibility(View.VISIBLE);
                    remouv.setVisibility(View.VISIBLE);
                    keytestlg = 2;
//                    Toast.makeText(Other_Info.this, sk1 , Toast.LENGTH_SHORT).show();
                } else {
                    langues3.setVisibility(View.VISIBLE);
                    addbtn.setVisibility(View.GONE);
                    keytestlg = 3;
                }
            }
        });
        remouv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (langues3.getVisibility() == View.VISIBLE) {
                    langues3.setVisibility(View.GONE);
                    addbtn.setVisibility(View.VISIBLE);
                    keytestlg = 2;
                } else {
                    layout12.setVisibility(View.GONE);
                    remouv.setVisibility(View.GONE);
                    keytestlg = 1;
                }
            }
        });

//skills adding

        String[] languageLevels = {"Beginner", "Pre-intermediate", "Intermediate", "Limited Working Proficiency", "Competent", "Proficient", "Upper-intermediate", "Fluent"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languageLevels);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        levellang.setAdapter(adapter);
        levellang2.setAdapter(adapter);
        levellang3.setAdapter(adapter);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Other_Info.this, Home_form.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Initially hide the EditText

        addbtn2.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);

        // Set up the buttons to toggle visibility of the EditText
        View.OnClickListener toggleVisibility = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout1.getVisibility() == View.GONE && addbtn.getVisibility() == View.GONE) {
                    layout1.setVisibility(View.VISIBLE);
                    addbtn.setVisibility(View.VISIBLE);
                }

            }

        };
        //        layout1.setVisibility(View.GONE);
//        addbtn.setVisibility(View.GONE);
        component5.setOnClickListener(toggleVisibility);
        View.OnClickListener show = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout2.getVisibility() == View.GONE && addbtn2.getVisibility() == View.GONE) {
                    layout2.setVisibility(View.VISIBLE);
                    addbtn2.setVisibility(View.VISIBLE);
                } else {
                    layout2.setVisibility(View.GONE);
                    addbtn2.setVisibility(View.GONE);

                }
            }
        };
        component6.setOnClickListener(show);
        View.OnClickListener show2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout3.getVisibility() == View.GONE) {
                    layout3.setVisibility(View.VISIBLE);
                    addbtn2.setBackgroundResource(R.drawable.remove1);

                } else {
                    layout3.setVisibility(View.GONE);
                    addbtn2.setBackgroundResource(R.drawable.add_new);

                }
            }
        };


        addbtn2.setOnClickListener(show2);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    showErrorDialog();
                    // Continue with the rest of your code here
                
            }
        });
    }


    public void showErrorDialog() {
        ConstraintLayout layout_d = findViewById(R.id.layout_dialog);
        View v = LayoutInflater.from(Other_Info.this).inflate(R.layout.dialog_enr, layout_d);
        Button btn_nn = v.findViewById(R.id.nn);
        Button btn_oui = v.findViewById(R.id.oui);

        AlertDialog.Builder builder = new AlertDialog.Builder(Other_Info.this);
        builder.setView(v);
        final AlertDialog alertDialog = builder.create();
        btn_nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
//                Toast.makeText(Other_Info.this, levellang.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        lg1 = (EditText) findViewById(R.id.getLang1);
        lg2 = (EditText) findViewById(R.id.getLang2);
        lg3 = (EditText) findViewById(R.id.getLang3);

        lg1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
        lg2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
        lg3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });



        int testIntent = mycvActivity.testtt;
        btn_oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TST_CV_VIEW = true ;

                dtUserOther.AjouterAboutme(rectangle1.getText().toString());

                if (!TextUtils.isEmpty(lg1.getText().toString())) {
                    dtUserOther.AjouterLangues(lg1.getText().toString(), levellang.getSelectedItem().toString());
                }
                if (!TextUtils.isEmpty(lg2.getText().toString())) {
                    dtUserOther.AjouterLangues(lg2.getText().toString(), levellang2.getSelectedItem().toString());
                }
                if (!TextUtils.isEmpty(lg3.getText().toString())) {
                    dtUserOther.AjouterLangues(lg3.getText().toString(), levellang3.getSelectedItem().toString());
                }

                if (testIntent == 0 || testIntent == 6 || testIntent == 12 || testIntent == 18) {
                    Intent intent = new Intent(Other_Info.this, cv1_Activity.class);
                    startActivity(intent);
                } else if (testIntent == 1 || testIntent == 7 || testIntent == 13 || testIntent == 19) {
                    Intent intent = new Intent(Other_Info.this, cv2_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 2 || testIntent == 8 || testIntent == 14 || testIntent == 20) {
                    Intent intent = new Intent(Other_Info.this, cv3_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 3 || testIntent == 9 || testIntent == 15 || testIntent == 21) {
                    Intent intent = new Intent(Other_Info.this, cv4_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 4 || testIntent == 10 || testIntent == 16 || testIntent == 22) {
                    Intent intent = new Intent(Other_Info.this, cv5_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 5 || testIntent == 11 || testIntent == 17 || testIntent == 23) {
                    Intent intent = new Intent(Other_Info.this, cv6_Activity.class);
                    startActivity(intent);
                }
//                for (int i = 0 ; i < stalist.size() ; i++){
//                    dtUserOther.AjouterSkills(stalist.get(i));
//                }

                //,
                //lg2.getText().toString(),levellang2.getSelectedItem().toString()
                //lg3.getText().toString(),levellang3.getSelectedItem().toString()



            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-9871786487157459/9969196618", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        //mInterstitialAd = null;
                    }
                });


        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            // This is where you would call your showErrorDialog() function
                            showErrorDialog();
                            // Continue with the rest of your code here
                        }

                        @Override
                        public void onAdClicked() {
                            // Called when a click is recorded for an ad.
                            Log.d(TAG, "Ad was clicked.");
                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            // Called when ad is dismissed.
                            // Set the ad reference to null so you don't show the ad a second time.
                            Log.d(TAG, "Ad dismissed fullscreen content.");
                            //mInterstitialAd = null;
                        }

                        @Override
                        public void onAdImpression() {
                            // Called when an impression is recorded for an ad.
                            Log.d(TAG, "Ad recorded an impression.");
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            // Called when ad is shown.
                            Log.d(TAG, "Ad showed fullscreen content.");
                        }
                    });
                    mInterstitialAd.show(Other_Info.this);
                } else {
                    showErrorDialog();
                    // Continue with the rest of your code here
                }
            }
        });


        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            alertDialog.show();
        }
    }
}
