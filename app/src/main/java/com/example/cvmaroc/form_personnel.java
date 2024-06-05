package com.example.cvmaroc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class form_personnel extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 1;

    private Button btnplus,edtext, btnmoin;
    EditText  name, surname, emailedit, number, adress, cin, city;
    private TextView txtview, photo, contact_inf;
    ImageView ImageVU;
    MyDataUser dtUserInfo;
    Calendar selectedDate ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_personnel);

        dtUserInfo = new MyDataUser(this, "dataUserInfo", null, 8);

        Button btn = (Button) findViewById(R.id.rectangle_1);
        Button routour = (Button) findViewById(R.id.routour);

        ImageVU = findViewById(R.id.imageVU);
        Button uploadP = (Button) findViewById(R.id.uploadP);
        uploadP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });


        routour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(form_personnel.this, Home_form.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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


        name = (EditText) findViewById(R.id.name_user);
        surname = (EditText) findViewById(R.id.surname_us);
        emailedit = (EditText) findViewById(R.id.email_us);
        number = (EditText) findViewById(R.id.number_us);
        adress = (EditText) findViewById(R.id.adress_us);
        cin = (EditText) findViewById(R.id.cin_us);
        city = (EditText) findViewById(R.id.city_us);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString();
                String p = surname.getText().toString();
                String em = emailedit.getText().toString();
                String num = number.getText().toString();
                String adres = adress.getText().toString();
                String ci = city.getText().toString();

                dtUserInfo.AjouterInfo( n, p, em, num, adres, ci);


                Intent intent1 = new Intent(form_personnel.this, Education_activiter.class);


                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });


        edtext.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        edtext.setText(dayOfMonth+" / "+monthOfYear+" / "+year);
                        selectedDate = Calendar.getInstance();
                        selectedDate.set(Calendar.YEAR,year);
                        selectedDate.set(Calendar.MONTH,monthOfYear);
                        selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                    }
                }, Calendar.getInstance());
                dialog.setAccentColor(R.color.black);

                dialog.show(getSupportFragmentManager(),null);
            }
        });

    }


    private void upload() {
        Intent imageintnt = new Intent(Intent.ACTION_PICK);
        imageintnt.setType("image/*");
        startActivityForResult(imageintnt, PICK_IMAGE_REQUEST);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) ;
            upload();
        } else {
            Toast.makeText(this, "permission manquante", Toast.LENGTH_SHORT).show();
        }
    }

    /*  @Override
      protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
          super.onActivityResult(requestCode, resultCode, data);
          if(resultCode==101 &&resultCode==RESULT_OK && data != null){
              Uri selectedImageUri = data.getData();
              Log.d("MyApp", "Selected Image URI: " + selectedImageUri);
              if (selectedImageUri != null) {
                  // Replace ImageVU with the actual instance of your ImageView
                  ImageVU.setImageURI(selectedImageUri);
                  Glide.with(this).load(selectedImageUri).into(ImageVU);

              }else {
                  Log.d("MyApp", "No data received from image picker");
              }
          }*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == form_personnel.RESULT_OK) {
            if (data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();

                ImageVU.setImageURI(selectedImageUri);

                try {
                    Log.d("MyApp", "Selected Image URI: " + selectedImageUri);

                    InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                    byte[] imageData = getBytes(inputStream);

                    // Insert the image into the database
                    dtUserInfo.insertImage(imageData);

                    // Display the image in your ImageView
                    ImageVU.setImageURI(selectedImageUri);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Helper method to convert InputStream to byte array
    private byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }



//    Profile userCv = new Profile();
//                Toast.makeText(form_personnel.this,userCv.getName(),Toast.LENGTH_SHORT).show();
//    public void setUserCv(Profile userCv) {
//        this.userCv = userCv;
//        userCv.setName(name.getText().toString());
//    }

}