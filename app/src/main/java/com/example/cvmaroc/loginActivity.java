package com.example.cvmaroc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_activity);

            Button login = (Button) findViewById(R.id.btnlogin);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(loginActivity.this,signupActivity.class);
                    startActivity(intent);

                }
            });

            TextView sgn = (TextView) findViewById(R.id.signup);
            sgn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(loginActivity.this,signupActivity.class);
                    startActivity(intent);

                }
            });
        }
    }
