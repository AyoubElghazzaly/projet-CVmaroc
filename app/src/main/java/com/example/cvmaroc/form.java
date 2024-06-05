package com.example.cvmaroc;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class form extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST=1;

    Button btnplus, btnmoin,uploadP;
    private EditText edtext;
    private TextView txtview;
    ImageView ImageVU;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_personnel);
        Button btn=(Button)findViewById(R.id.rectangle_1);
        Button routour = (Button) findViewById(R.id.routour);
        ImageVU =  findViewById(R.id.imageVU);





        routour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form.this, mycvActivity.class);
                startActivity(intent);
            }
        });

        btnplus = findViewById(R.id.plus);
        btnmoin = findViewById(R.id.moin);
        edtext = findViewById(R.id.edtext);
        txtview = findViewById(R.id.other_detai);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnplus.setVisibility(View.GONE);
                txtview.setVisibility(View.GONE);
                btnmoin.setVisibility(View.VISIBLE);
                edtext.setVisibility(View.VISIBLE);

            }
        });

        btnmoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnplus.setVisibility(View.VISIBLE);
                txtview.setVisibility(View.VISIBLE);
                btnmoin.setVisibility(View.GONE);
                edtext.setVisibility(View.GONE);
            }
        });

    /*    btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showErrorDialog();
            }
        });*/

    }





/*    public void showErrorDialog(){
            ConstraintLayout layout_d =findViewById(R.id.layout_dialog);
            View v = LayoutInflater.from(form.this).inflate(R.layout.dialog_enr,layout_d);
            Button btn_nn = v.findViewById(R.id.nn);
            Button btn_oui = v.findViewById(R.id.oui);
            AlertDialog.Builder builder = new AlertDialog.Builder(form.this);
            builder.setView(v);
            final AlertDialog alertDialog= builder.create();
            btn_nn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });
            if (alertDialog.getWindow()!=null){
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Intent intent= new Intent(form.this,form_work.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            alertDialog.show();
        }*/


    }



