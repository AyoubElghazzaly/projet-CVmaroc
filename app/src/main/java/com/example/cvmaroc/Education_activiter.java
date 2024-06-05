package com.example.cvmaroc;

import android.annotation.SuppressLint;
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

public class Education_activiter extends AppCompatActivity {

    private Button other, remouv, routour;

    private LinearLayout education2, education3;
    private Button btn_add_educaton;
    private EditText school, subject, description, school2, subject2, description2, school3, subject3, description3;

    Spinner sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, sp11, sp12;

    MyDataUser dtUserEducation;
    public static int keytest = 1 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.form_education);


        dtUserEducation = new MyDataUser(this, "dataUserInfo", null, 8);


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


        education2 = (LinearLayout) findViewById(R.id.education_2);
        education3 = (LinearLayout) findViewById(R.id.education_3);
        remouv = (Button) findViewById(R.id.remouv_ed);


        btn_add_educaton = (Button) findViewById(R.id.btn_add);

        btn_add_educaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (education2.getVisibility() == View.GONE) {
                    education2.setVisibility(View.VISIBLE);
                    remouv.setVisibility(View.VISIBLE);
                    keytest = 2 ;
                } else {
                    education3.setVisibility(View.VISIBLE);
                    keytest = 3 ;
                }
            }
        });
        remouv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (education3.getVisibility() == View.VISIBLE) {
                    education3.setVisibility(View.GONE);
                    keytest = 2 ;
                } else {
                    education2.setVisibility(View.GONE);
                    remouv.setVisibility(View.GONE);
                    keytest = 1 ;
                }
            }
        });

        routour = findViewById(R.id.routour);
        routour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Education_activiter.this, Home_form.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Edit Text eduction 1
        school = (EditText) (findViewById(R.id.school));
        subject = (EditText) (findViewById(R.id.subject));
        description = (EditText) (findViewById(R.id.descrip));
        //Edit Text eduction 2
        school2 = (EditText) (findViewById(R.id.school2));
        subject2 = (EditText) (findViewById(R.id.subject2));
        description2 = (EditText) (findViewById(R.id.description2));
        //Edit Text eduction 3
        school3 = (EditText) (findViewById(R.id.school3));
        subject3 = (EditText) (findViewById(R.id.subject3));
        description3 = (EditText) (findViewById(R.id.description3));


        other = (Button) findViewById(R.id.other_page);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dtUserEducation.AjouterEducation(school.getText().toString(),sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString(),subject.getText().toString(),description.getText().toString());
                dtUserEducation.AjouterEducation(school2.getText().toString(),sp5.getSelectedItem().toString(),sp7.getSelectedItem().toString(),subject2.getText().toString(),description2.getText().toString());
                dtUserEducation.AjouterEducation(school3.getText().toString(),sp9.getSelectedItem().toString(),sp11.getSelectedItem().toString(),subject3.getText().toString(),description3.getText().toString());
//                user = (Profile) getIntent().getSerializableExtra("user");
//
//                // edication 1
//
//                Profile.Education edu1 = new Profile.Education();
//                edu1.setSchool(school.getText().toString());
//                edu1.setSubject(subject.getText().toString());
//                edu1.setDescription(description.getText().toString());
//                edu1.setDebut(sp1.getSelectedItem().toString());
//                edu1.setFin(sp2.getSelectedItem().toString());
//
//                // edication 1
//
//                Profile.Education edu2 = new Profile.Education();
//                edu2.setSchool(school2.getText().toString());
//                edu2.setSubject(subject2.getText().toString());
//                edu2.setDescription(description2.getText().toString());
//                edu2.setDebut(sp5.getSelectedItem().toString());
//                edu2.setFin(sp7.getSelectedItem().toString());
//
//                Profile.Education edu3 = new Profile.Education();
//                edu3.setSchool(school3.getText().toString());
//                edu3.setSubject(subject3.getText().toString());
//                edu3.setDescription(description3.getText().toString());
//                edu3.setDebut(sp9.getSelectedItem().toString());
//                edu3.setFin(sp11.getSelectedItem().toString());
//
//                user.getEducationArrayList().add(edu1);
//
//
//                user.getEducationArrayList().add(edu2);

//                user.getEducationArrayList().add(edu3);

////                ArrayList<Profile.Education> educationlistuser = new ArrayList<>();
////                educationlistuser.add(edu1);
////                educationlistuser.add(edu2);
////
//                user.setEducationArrayList(educationlistuser);
                Intent intent = new Intent(Education_activiter.this, form_work.class);

//                intent.putExtra("user", user);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
//        educate.add(description.getText().toString());
//        user.setEducationArrayList(educate);


//        school.getText().toString(),subject.getText().toString(),description.getText().toString()
    }
}
