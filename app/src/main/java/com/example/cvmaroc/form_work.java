package com.example.cvmaroc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class form_work extends AppCompatActivity {
    private LinearLayout experience_2, experience_3, experience_4;
    private Button btn_add_experience, btn_moin, other;
    Spinner sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, sp11, sp12, sp13, sp14, sp15, sp16;

    private Profile user;
    private EditText societe, job, desription, societe_2, job_2, desription_2, societe_3, job_3, desription_3, societe_4, job_4, desription_4;

    MyDataUser dtUserWork;

    public static int conteureWork = 1 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_work);

        dtUserWork = new MyDataUser(this, "dataUserInfo", null, 8);


        Button routour = (Button) findViewById(R.id.routour);

        routour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form_work.this, Home_form.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        sp1 = findViewById(R.id.dropdown);
        sp2 = findViewById(R.id.dropdown2);
        sp3 = findViewById(R.id.dropdown3);
        sp4 = findViewById(R.id.dropdown1);
        sp5 = findViewById(R.id.dropdown4);
        sp6 = findViewById(R.id.dropdown5);
        sp7 = findViewById(R.id.dropdown6);
        sp8 = findViewById(R.id.dropdown7);
        sp9 = findViewById(R.id.dropdown8);
        sp10 = findViewById(R.id.dropdown9);
        sp11 = findViewById(R.id.dropdown10);
        sp12 = findViewById(R.id.dropdown11);
        sp13 = findViewById(R.id.dropdown12);
        sp14 = findViewById(R.id.dropdown13);
        sp15 = findViewById(R.id.dropdown14);
        sp16 = findViewById(R.id.dropdown15);


// Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

// Create a list of years from 100 years ago to 100 years in the future
        List<String> years = new ArrayList<>();
        for (int i = currentYear - 100; i <= currentYear + 100; i++) {
            years.add(Integer.toString(i));
        }

// Create an ArrayAdapter using the year list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);
        sp5.setAdapter(adapter);
        sp7.setAdapter(adapter);
        sp9.setAdapter(adapter);
        sp11.setAdapter(adapter);
        sp13.setAdapter(adapter);
        sp15.setAdapter(adapter);

        // Create a list of months
        String[] monthsArray = new DateFormatSymbols().getMonths();
        List<String> months = new ArrayList<>(Arrays.asList(monthsArray));

// Remove the last item if it's an empty string
        if (months.get(months.size() - 1).isEmpty()) {
            months.remove(months.size() - 1);
        }

// Create an ArrayAdapter using the month list
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        sp3.setAdapter(adapter2);
        sp4.setAdapter(adapter2);
        sp6.setAdapter(adapter2);
        sp8.setAdapter(adapter2);
        sp10.setAdapter(adapter2);
        sp12.setAdapter(adapter2);
        sp14.setAdapter(adapter2);
        sp16.setAdapter(adapter2);


        experience_2 = findViewById(R.id.experience__2);
        experience_3 = findViewById(R.id.experience_3);
        experience_4 = findViewById(R.id.experience_4);
        btn_add_experience = findViewById(R.id.btn_add);
        btn_moin = findViewById(R.id.remouv_Ex);
        btn_add_experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (experience_2.getVisibility() == View.GONE) {
                    experience_2.setVisibility(View.VISIBLE);
                    btn_moin.setVisibility(View.VISIBLE);
                    conteureWork = 2 ;
                } else if ((experience_3.getVisibility() == View.GONE)) {
                    experience_3.setVisibility(View.VISIBLE);
                    conteureWork = 3 ;
                } else {
                    experience_4.setVisibility(View.VISIBLE);
                    conteureWork = 4 ;
                }

            }
        });
        btn_moin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (experience_4.getVisibility() == View.VISIBLE) {
                    experience_4.setVisibility(View.GONE);
                    conteureWork = 3 ;
                } else if ((experience_3.getVisibility() == View.VISIBLE)) {
                    experience_3.setVisibility(View.GONE);
                    conteureWork = 2 ;
                } else {
                    experience_2.setVisibility(View.GONE);
                    btn_moin.setVisibility(View.GONE);
                    conteureWork = 1 ;
                }
            }
        });


        // work 1

        societe = (EditText) findViewById(R.id.societe);
        job = (EditText) findViewById(R.id.job);
        desription = (EditText) findViewById(R.id.describe_work);


        // work 2

        societe_2 = (EditText) findViewById(R.id.societe_2);
        job_2 = (EditText) findViewById(R.id.job_2);
        desription_2 = (EditText) findViewById(R.id.describe_2);

        // work 3

        societe_3 = (EditText) findViewById(R.id.societe_3);
        job_3 = (EditText) findViewById(R.id.job_3);
        desription_3 = (EditText) findViewById(R.id.describe_3);

        // work 4

        societe_4 = (EditText) findViewById(R.id.societe_4);
        job_4 = (EditText) findViewById(R.id.job_4);
        desription_4 = (EditText) findViewById(R.id.describe_4);

        other = (Button) findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dtUserWork.AjouterExperionce(societe.getText().toString(), job.getText().toString(),
                        sp1.getSelectedItem().toString() + " - " + sp4.getSelectedItem().toString(),
                        sp2.getSelectedItem().toString() + " - " + sp3.getSelectedItem().toString(),
                        desription.getText().toString());
                dtUserWork.AjouterExperionce(societe_2.getText().toString(), job_2.getText().toString(),
                        sp5.getSelectedItem().toString() + " " + sp6.getSelectedItem().toString(),
                        sp7.getSelectedItem().toString() + " " + sp8.getSelectedItem().toString(),
                        desription_2.getText().toString());
                dtUserWork.AjouterExperionce(societe_3.getText().toString(), job_3.getText().toString(),
                        sp9.getSelectedItem().toString() + " " + sp10.getSelectedItem().toString(),
                        sp11.getSelectedItem().toString() + " " + sp12.getSelectedItem().toString(),
                        desription_3.getText().toString());
                dtUserWork.AjouterExperionce(societe_4.getText().toString(), job_4.getText().toString(),
                        sp13.getSelectedItem().toString() + " " + sp14.getSelectedItem().toString(),
                        sp15.getSelectedItem().toString() + " " + sp16.getSelectedItem().toString(),
                        desription_4.getText().toString());




                Intent intent = new Intent(form_work.this, Other_Info.class);

//                intent.putExtra("user", user);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });


    }
}
