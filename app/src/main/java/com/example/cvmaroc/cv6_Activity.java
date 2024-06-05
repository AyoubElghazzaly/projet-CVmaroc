package com.example.cvmaroc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class cv6_Activity extends AppCompatActivity {

    TextView nametv, information, grandview;
    MyDataUser dtUserInfo;
    String infocontact;

    ArrayList<Profile> lsInfo;
    ArrayList<Education> lsEdu;
    ArrayList<Experience> lsWork;
    ArrayList<Skill> lsSkills;
    ArrayList<Profile> lslg;

    LinearLayout layout_cv;

    ArrayList<Profile> lsAbout;
    int testEdu, testWork, testlg;
    Button savePdf;
    Bitmap bitmap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.cv_view6);

        dtUserInfo = new MyDataUser(this, "dataUserInfo", null, 8);
        testEdu = Education_activiter.keytest;
        testWork = form_work.conteureWork;
        testlg = Other_Info.keytestlg;


        nametv = findViewById(R.id.name);
        information = findViewById(R.id.information);
        grandview = findViewById(R.id.education_experionce_);
        layout_cv = findViewById(R.id.layout_cv);

        lsInfo = dtUserInfo.GetUserInfo();

        lsEdu = dtUserInfo.GetUserEducation();
        lsWork = dtUserInfo.GetUserWork();
        lsAbout = dtUserInfo.GetUserAbout();
        lsSkills = dtUserInfo.GetUserSkills();
        lslg = dtUserInfo.GetLanguesUser();

        StringBuilder st = new StringBuilder();

        try {
            ArrayList<Hobby> lshobby = dtUserInfo.GetUserHobby();
            for (Hobby hobby : lshobby) {
                st.append("-  " + "<b>" + hobby.getNomHobby() + "</b>").append("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        nametv.setText(lsInfo.get(lsInfo.size() - 1).name + " " + lsInfo.get(lsInfo.size() - 1).surname);

        int nbrskkil = Other_Info.nbrskills ;
        StringBuilder strbuild = new StringBuilder();
        try {
            for (Skill skill: lsSkills) {
                strbuild.append("-  " + "<b>" +skill.name+ "</b>").append("<br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        String Lang2;
        if (lslg.get(lslg.size() - 2).nameLangue.length() != 0) {
            Lang2 = "<br><b>" + "- " + lslg.get(lslg.size() - 2).nameLangue + "</b>" + " ___ " + lslg.get(lslg.size() - 2).level;
        } else {
            Lang2 = "";
        }
        String Lang3;
        if (lslg.get(lslg.size() - 3).nameLangue.length() != 0) {
            Lang3 = "<br><b>" + "- " + lslg.get(lslg.size() - 1).nameLangue + "</b>" + " ___ " + lslg.get(lslg.size() - 1).level;
        } else {
            Lang3 = "";
        }

        String langues = "<br><b>" + "- " + lslg.get(lslg.size() - 3).nameLangue + "</b>" + " ___ " + lslg.get(lslg.size() - 3).level + Lang2 + Lang3;

        information.setText(Html.fromHtml("<b>" + lsInfo.get(lsInfo.size() - 1).email + "</b>" +
                "<br><b>" + lsInfo.get(lsInfo.size() - 1).contact + "</b>" +
                "<br><b>" + lsInfo.get(lsInfo.size() - 1).city + "</b>" +
                "<br><b>" + lsInfo.get(lsInfo.size() - 1).address + "</b>" + "<br>"  + "<br>" + "<br>"+
                "<br>"+"<h4> Skills : </h4>"+ strbuild + "</b>" + "<br>" + "<br>" +"<br>"+"<h4> Languages : </h4>"+ langues));



        String Edu2;
        if (testEdu == 2) {
            Edu2 = "<br><b>" + "- " + lsEdu.get(lsEdu.size() - 2).subject + "</b>" + "  " + lsEdu.get(lsEdu.size() - 2).debut + " - " + lsEdu.get(lsEdu.size() - 2).fin +
                    "<br>" + lsEdu.get(lsEdu.size() - 2).school +
                    "<br>" + lsEdu.get(lsEdu.size() - 2).description;
        } else {
            Edu2 = "";
        }
        String Edu3;
        if (testEdu == 3) {
            Edu3 = "<br><b>" + "- " + lsEdu.get(lsEdu.size() - 2).subject + "</b>" + "  " + lsEdu.get(lsEdu.size() - 2).debut + " - " + lsEdu.get(lsEdu.size() - 2).fin +
                    "<br>" + lsEdu.get(lsEdu.size() - 2).school +
                    "<br>" + lsEdu.get(lsEdu.size() - 2).description +
                    "<br><b>" + "- " + lsEdu.get(lsEdu.size() - 1).subject + "</b>" + "  " + lsEdu.get(lsEdu.size() - 1).debut + " - " + lsEdu.get(lsEdu.size() - 1).fin +
                    "<br>" + lsEdu.get(lsEdu.size() - 1).school +
                    "<br>" + lsEdu.get(lsEdu.size() - 1).description;
        } else {
            Edu3 = "";
        }


        String Work1 = "<h4> Experionce : </h4>" +
                "<b>" + "-  " + lsWork.get(lsWork.size() - 4).job + "</b>" +
                "<br>" + lsWork.get(lsWork.size() - 4).societe +
                "<br>" + lsWork.get(lsWork.size() - 4).start + " __ " + lsWork.get(lsWork.size() - 4).end +
                "<br>" + lsWork.get(lsWork.size() - 4).description;
        String Work2;
        if (testWork == 2) {
            Work2 = "<br><b>" + "-  " + lsWork.get(lsWork.size() - 3).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 3).societe +
                    "<br>" + lsWork.get(lsWork.size() - 3).start + " __ " + lsWork.get(lsWork.size() - 3).end +
                    "<br>" + lsWork.get(lsWork.size() - 3).description;
        } else {
            Work2 = "";
        }
        String Work3;
        if (testWork == 3) {
            Work3 = "<br><b>" + "-  " + lsWork.get(lsWork.size() - 3).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 3).societe +
                    "<br>" + lsWork.get(lsWork.size() - 3).start + " __ " + lsWork.get(lsWork.size() - 3).end +
                    "<br>" + lsWork.get(lsWork.size() - 3).description +
                    "<br><b>" + "-  " + lsWork.get(lsWork.size() - 2).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 2).societe +
                    "<br>" + lsWork.get(lsWork.size() - 2).start + " __ " + lsWork.get(lsWork.size() - 2).end +
                    "<br>" + lsWork.get(lsWork.size() - 2).description;
        } else {
            Work3 = "";
        }
        String Work4;
        if (testWork == 4) {
            Work4 = "<br><b>" + "-  " + lsWork.get(lsWork.size() - 3).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 3).societe +
                    "<br>" + lsWork.get(lsWork.size() - 3).start + " __ " + lsWork.get(lsWork.size() - 3).end +
                    "<br>" + lsWork.get(lsWork.size() - 3).description +
                    "<br><b>" + "-  " + lsWork.get(lsWork.size() - 2).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 2).societe +
                    "<br>" + lsWork.get(lsWork.size() - 2).start + " __ " + lsWork.get(lsWork.size() - 2).end +
                    "<br>" + lsWork.get(lsWork.size() - 2).description +
                    "<br><b>" + "-  " + lsWork.get(lsWork.size() - 1).job + "</b>" +
                    "<br>" + lsWork.get(lsWork.size() - 1).societe +
                    "<br>" + lsWork.get(lsWork.size() - 1).start + " __ " + lsWork.get(lsWork.size() - 1).end +
                    "<br>" + lsWork.get(lsWork.size() - 1).description;
        } else {
            Work4 = "";
        }

        String strAbout ;
        if (lsAbout.get(lsAbout.size() - 1).aboutme.length() != 0){
            strAbout = "<h4> About me : </h4>" +
                    "<b>" + "-  " + lsAbout.get(lsAbout.size() - 1).aboutme + "</b>" ;
        }else {
            strAbout = "";
        }

        grandview.setText(Html.fromHtml(strAbout +"<br>"+"<h4> Formation : </h4>" +
                "<b>" + "-  " + lsEdu.get(lsEdu.size() - 3).subject + "</b>" + "  " + lsEdu.get(lsEdu.size() - 3).debut + " - " + lsEdu.get(lsEdu.size() - 3).fin +
                "<br>" + lsEdu.get(lsEdu.size() - 3).school +
                "<br>" + lsEdu.get(lsEdu.size() - 3).description + Edu2 +
                Edu3 +
                Work1 +
                Work2 +
                Work3 +
                Work4 + "<br>" + "<br>" + "<br>" + "<br>" + "<br>" + "<br>"+"<h4> Hobby : </h4>"+ st + "</b>" ));

        savePdf = findViewById(R.id.btn_download);
        savePDF();
    }

    private void savePDF() {
        savePdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }

        });
    }

    // Inside generatePDF method
    // Inside generatePDF method
    public void generatePDF() {
        // Create a PdfDocument
        PdfDocument pdfDocument = new PdfDocument();

        // Create a PageInfo
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(layout_cv.getWidth(), layout_cv.getHeight(), 1).create();

        // Start a page
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        // Draw the LinearLayout content on the page
        layout_cv.draw(page.getCanvas());

        // Finish the page
        pdfDocument.finishPage(page);

        // Create a file and get its content URI using FileProvider
        String fileName = "Cv "+lsInfo.get(lsInfo.size() - 1).name +".pdf";
        File pdfFile = new File(getExternalFilesDir(null), fileName);
        Uri contentUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", pdfFile);

        try {
            // Write the PDF content to the file
            pdfDocument.writeTo(new FileOutputStream(pdfFile));

            // Grant permission to the receiving app to read the content URI
            grantUriPermission(getPackageName(), contentUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

            // Save or share the PDF file
            // For simplicity, let's open a share intent
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/pdf");
            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            startActivity(Intent.createChooser(shareIntent, "Share PDF"));

            Toast.makeText(this, "PDF generated successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error generating PDF", Toast.LENGTH_SHORT).show();
        } finally {
            // Close the PdfDocument
            pdfDocument.close();
        }
    }
}