package com.example.cvmaroc;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataUser extends SQLiteOpenHelper {

    public MyDataUser(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE InfoPersonnel(idinfo INTEGER PRIMARY KEY AUTOINCREMENT ,nom TEXT , prenom TEXT , email TEXT , numero TEXT, adress TEXT , city TEXT )");
        db.execSQL("CREATE TABLE Educations(idedu INTEGER PRIMARY KEY AUTOINCREMENT ,school TEXT , start TEXT , fin TEXT , subject TEXT , description TEXT)");
        db.execSQL("CREATE TABLE Experiences(idwork INTEGER PRIMARY KEY AUTOINCREMENT , job TEXT , societe TEXT , start TEXT , fin TEXT , description TEXT )");
        db.execSQL("CREATE TABLE Aboutme(idaboutme INTEGER PRIMARY KEY AUTOINCREMENT , aboutme TEXT )");
        db.execSQL("CREATE TABLE Langues(idlg INTEGER PRIMARY KEY AUTOINCREMENT , namelang TEXT , levellang TEXT)");
        db.execSQL("CREATE TABLE Reference(idref INTEGER PRIMARY KEY AUTOINCREMENT  , namereferonce Text)");
        db.execSQL("CREATE TABLE Skills(idskil INTEGER PRIMARY KEY AUTOINCREMENT , skill TEXT )");
        db.execSQL("CREATE TABLE Hobbey(idh INTEGER PRIMARY KEY AUTOINCREMENT , hobby TEXT )");
        db.execSQL("CREATE TABLE Images(imgid INTEGER PRIMARY KEY AUTOINCREMENT ,image_data BLOB)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //    Ajouter tout informaion des User
    public void AjouterInfo(String nom, String prenom, String email, String tele, String adres, String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom", nom);
        cv.put("prenom", prenom);
        cv.put("email", email);
        cv.put("numero", tele);
        cv.put("adress", adres);
        cv.put("city", city);
        db.insert("InfoPersonnel", null, cv);
        db.close();
    }

    public void AjouterEducation(String school, String start, String fin, String subject, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvedu = new ContentValues();
        cvedu.put("school", school);
        cvedu.put("start", start);
        cvedu.put("fin", fin);
        cvedu.put("subject", subject);
        cvedu.put("description", description);
        db.insert("Educations", null, cvedu);
        db.close();

    }

    public void AjouterExperionce( String societe,String job, String start, String fin, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvexp = new ContentValues();
        cvexp.put("job", job);
        cvexp.put("start", start);
        cvexp.put("fin", fin);
        cvexp.put("societe", societe);
        cvexp.put("description", description);
        db.insert("Experiences", null, cvexp);
        db.close();

    }

    public void AjouterAboutme(String about) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvaboutme = new ContentValues();
        cvaboutme.put("aboutme", about);
        db.insert("Aboutme", null, cvaboutme);
        db.close();
    }
    public void AjouterLangues(String nameLg , String levelLg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvlong = new ContentValues();
        cvlong.put("namelang",nameLg);
        cvlong.put("levellang",levelLg);
        db.insert("Langues",null,cvlong);
        db.close();
    }

    public void AjouterSkills(String skill) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvsk = new ContentValues();
        cvsk.put("skill", skill);
        db.insert("Skills", null, cvsk);
        db.close();
    }
    public void AjouterHobby(String hobby){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hobby",hobby);
        db.insert("Hobbey",null,contentValues);
        db.close();
    }

    // Method to insert an image into the database
    public long insertImage(byte[] imageData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("image_data", imageData);
        long result = db.insert("Images", null, values);
        db.close();
        return result;
    }


    @SuppressLint("Range")
    public ArrayList<Profile> GetUserInfo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curs = db.rawQuery("SELECT * FROM InfoPersonnel",null);
        ArrayList<Profile> lsUserinfo = new ArrayList<Profile>();
        curs.moveToFirst();
        while (curs.isAfterLast() == false){
            int idinfo ;
            String nom , prenom , email , numero , adress , city ;
            idinfo = curs.getInt(curs.getColumnIndex("idinfo"));
            nom = curs.getString(curs.getColumnIndex("nom"));
            prenom = curs.getString(curs.getColumnIndex("prenom"));
            email = curs.getString(curs.getColumnIndex("email"));
            numero = curs.getString(curs.getColumnIndex("numero"));
            adress  = curs.getString(curs.getColumnIndex("adress"));
            city = curs.getString(curs.getColumnIndex("city"));
            lsUserinfo.add(new Profile( idinfo,nom , prenom , email , numero , adress , city));
            curs.moveToNext();
        }
        db.close();
        return lsUserinfo ;
    }
    @SuppressLint("Range")
    public ArrayList<Education> GetUserEducation(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  = db.rawQuery("SELECT * FROM Educations",null);
        ArrayList<Education> lsEducat = new ArrayList<Education>();
        cursor.moveToNext();
        while (cursor.isAfterLast() == false){
            int idedu ;
            String school , subject , start , fin , description ;
            idedu = cursor.getInt(cursor.getColumnIndex("idedu"));
            school = cursor.getString(cursor.getColumnIndex("school"));
            subject = cursor.getString(cursor.getColumnIndex("subject"));
            start = cursor.getString(cursor.getColumnIndex("start"));
            fin = cursor.getString(cursor.getColumnIndex("fin"));
            description = cursor.getString(cursor.getColumnIndex("description"));
            lsEducat.add(new Education(idedu,school,subject,description,start,fin));
            cursor.moveToNext();
        }
        db.close();
        return lsEducat ;
    }
    @SuppressLint("Range")
    public ArrayList<Experience> GetUserWork(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  = db.rawQuery("SELECT * FROM Experiences",null);
        ArrayList<Experience> lsWork = new ArrayList<Experience>();
        cursor.moveToNext();
        while (cursor.isAfterLast() == false){
            int idwork ;
            String job , soceite , start , fin , description ;
            idwork = cursor.getInt(cursor.getColumnIndex("idwork"));
            job = cursor.getString(cursor.getColumnIndex("job"));
            soceite = cursor.getString(cursor.getColumnIndex("societe"));
            start = cursor.getString(cursor.getColumnIndex("start"));
            fin = cursor.getString(cursor.getColumnIndex("fin"));
            description = cursor.getString(cursor.getColumnIndex("description"));
            lsWork.add(new Experience(idwork,soceite,job,start,fin,description));
            cursor.moveToNext();
        }
        db.close();
        return lsWork ;
    }
    @SuppressLint("Range")
    public ArrayList<Profile> GetUserAbout(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Aboutme",null);
        ArrayList<Profile> lsAbout = new ArrayList<>();
        cursor.moveToNext();
        while (cursor.isAfterLast() == false){
            int idaboutme ;
            String about ;
            idaboutme = cursor.getInt(cursor.getColumnIndex("idaboutme"));
            about = cursor.getString(cursor.getColumnIndex("aboutme"));
            lsAbout.add(new Profile(idaboutme,about));
            cursor.moveToNext();
        }
        db.close();
        return lsAbout;
    }
    @SuppressLint("Range")
    public ArrayList<Profile> GetLanguesUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Langues",null);
        ArrayList<Profile> lsLang = new ArrayList<>();
        cursor.moveToNext();
        while (cursor.isAfterLast() == false){
            int idLg ;
            String nameLg , levelLg ;
            idLg = cursor.getInt(cursor.getColumnIndex("idlg"));
            nameLg = cursor.getString(cursor.getColumnIndex("namelang"));
            levelLg = cursor.getString(cursor.getColumnIndex("levellang"));
            lsLang.add(new Profile(idLg,nameLg,levelLg));
            cursor.moveToNext();
        }
        db.close();
        return lsLang ;
    }

    @SuppressLint("Range")
    public ArrayList<Hobby> GetUserHobby(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Hobbey",null);
        ArrayList<Hobby> lssHo = new ArrayList<>();
        cursor.moveToNext();
        while (cursor.isAfterLast() == false){
            int idsk ;
            String nameho ;
            idsk = cursor.getInt(cursor.getColumnIndex("idh"));
            nameho = cursor.getString(cursor.getColumnIndex("hobby"));
            lssHo.add(new Hobby(idsk,nameho));
            cursor.moveToNext();
        }
        db.close();
        return lssHo ;
    }

    @SuppressLint("Range")
    public ArrayList<Skill> GetUserSkills(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ccurs = db.rawQuery("SELECT * FROM Skills",null);
        ArrayList<Skill> lsskills = new ArrayList<>();
        ccurs.moveToNext();
        while (ccurs.isAfterLast() == false){
            int idskil ;
            String namesk ;
            idskil = ccurs.getInt(ccurs.getColumnIndex("idskil"));
            namesk = ccurs.getString(ccurs.getColumnIndex("skill"));
            lsskills.add(new Skill(idskil,namesk));
            ccurs.moveToNext();
        }
        db.close();
        return lsskills ;
    }
    // Method to retrieve image data from the database
    // Method to retrieve the last inserted image data from the database
    public byte[] getLastImageData() {
        SQLiteDatabase db = this.getReadableDatabase();
        byte[] imageData = null;

        Cursor cursor = db.query(
                "Images",
                new String[]{"image_data"},
                null,
                null,
                null,
                null,
                "imgid" + " DESC",  // Order by primary key in descending order
                "1"                  // Limit the result to 1 row
        );

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("image_data");
            imageData = cursor.getBlob(columnIndex);
            cursor.close();
        }

        db.close();
        return imageData;
    }


}
