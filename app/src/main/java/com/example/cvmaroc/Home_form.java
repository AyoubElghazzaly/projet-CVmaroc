package com.example.cvmaroc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class Home_form extends AppCompatActivity {
    Button form_personal, form_education, form_work, back, btn_skill_detail, view_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
        setContentView(R.layout.form_home);


        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_form.this, mycvActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        form_personal = (Button) findViewById(R.id.form_personal);
        form_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt = new Intent(Home_form.this, form_personnel.class);
                startActivity(intt);
            }
        });

        form_education = (Button) findViewById(R.id.form_education);
        form_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt = new Intent(Home_form.this, Education_activiter.class);
                startActivity(intt);
            }
        });

        form_work = (Button) findViewById(R.id.form_work);
        form_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_form.this, form_work.class);
                startActivity(intent);
            }
        });
        btn_skill_detail = (Button) findViewById(R.id.btn_skill_detail);
        btn_skill_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_form.this, Other_Info.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        MyDataUser dtUserOther = new MyDataUser(this, "dataUserInfo", null, 8);

        view_cv = (Button) findViewById(R.id.view_cv_btn);

        if (dtUserOther.GetUserInfo().size() >= 1){
            view_cv.setVisibility(View.VISIBLE);
        }else {
            view_cv.setVisibility(View.GONE);
        }
        int testIntent = mycvActivity.testtt;

        view_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testIntent == 0 || testIntent == 6 || testIntent == 12 || testIntent == 18) {
                    Intent intent = new Intent(Home_form.this, cv1_Activity.class);
                    startActivity(intent);
                } else if (testIntent == 1 || testIntent == 7 || testIntent == 13 || testIntent == 19) {
                    Intent intent = new Intent(Home_form.this, cv2_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 2 || testIntent == 8 || testIntent == 14 || testIntent == 20) {
                    Intent intent = new Intent(Home_form.this, cv3_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 3 || testIntent == 9 || testIntent == 15 || testIntent == 21) {
                    Intent intent = new Intent(Home_form.this, cv4_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 4 || testIntent == 10 || testIntent == 16 || testIntent == 22) {
                    Intent intent = new Intent(Home_form.this, cv5_Activity.class);
                    startActivity(intent);
                }else if (testIntent == 5 || testIntent == 11 || testIntent == 17 || testIntent == 23) {
                    Intent intent = new Intent(Home_form.this, cv6_Activity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
