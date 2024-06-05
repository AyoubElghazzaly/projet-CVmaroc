package com.example.cvmaroc;


public class Profile {
    public int numero;
    public String name, surname, email, contact, address, cin, city, photo;
    public String aboutme , nameLangue , level ;
    int idabout , idlang;


    public Profile(int idlang ,String nameLangue, String level) {
        this.idlang = idlang ;
        this.nameLangue = nameLangue;
        this.level = level;
    }

    public Profile(int idabout , String aboutme) {
        this.idabout = idabout ;
        this.aboutme = aboutme;

    }

    public Profile(int numero, String name, String surname, String email, String contact, String address, String city) {
        this.numero = numero;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.city = city;
    }

//
//    public ArrayList<Education> getEducationArrayList() {
//        return educationArrayList;
//    }
//
//    public void setEducationArrayList(ArrayList<Education> educationArrayList) {
//        this.educationArrayList = educationArrayList;
//    }
////    public void ajoutEducation(A)
//
//    public ArrayList<Experience> getExperienceArrayList() {
//        return experienceArrayList;
//    }
//
//    public void setExperienceArrayList(ArrayList<Experience> experienceArrayList) {
//        this.experienceArrayList = experienceArrayList;
//    }
//
//    public ArrayList<Skill> getSkillArrayList() {
//        return skillArrayList;
//    }
//
//    public void setSkillArrayList(ArrayList<Skill> skillArrayList) {
//        this.skillArrayList = skillArrayList;
//    }
//
//    public ArrayList<langue> getlangueArrayList() {
//        return langueArrayList;
//    }
//
//    public void setlangueArrayList(ArrayList<langue> langueArrayList) {
//        this.langueArrayList = langueArrayList;
//    }
//
//    ;
//
//    public ArrayList<references> getreferencesArrayList() {
//        return referencesArrayList;
//    }
//
//    public void setreferencesArrayList(ArrayList<references> referencesArrayList) {
//        this.referencesArrayList = referencesArrayList;
//    }


}


//    public String getAboutme() {
//        return aboutme;
//    }
//
//    public void setAboutme(String aboutme) {
//        this.aboutme = aboutme;
//    }

// Helper classes



class Education {
    int idedu;
    public String subject, school, description, debut, fin;

    public Education() {
        // Empty constructor
    }

    public Education(int idedu, String school, String subject, String description, String debut, String fin) {

        this.idedu = idedu;
        this.school = school;
        this.subject = subject;
        this.description = description;
        this.debut = debut;
        this.fin = fin;
    }


}

class Experience {
    public String societe, job, start, end, description;
    public int id;

    public Experience() {
    }

    public Experience(int id, String societe, String job, String start, String end, String description) {
        this.id = id;
        this.societe = societe;
        this.job = job;
        this.start = start;
        this.end = end;
        this.description = description;
    }


}

class Skill {
    int id ;
    public String name;
    public Skill() {
    }

    public Skill(int id ,String name) {
        this.id = id ;
        this.name = name;
    }
}
class Hobby {
    private int id ;
    private String nomHobby ;

    public Hobby(int id, String nomHobby) {
        this.id = id;
        this.nomHobby = nomHobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomHobby() {
        return nomHobby;
    }

    public void setNomHobby(String nomHobby) {
        this.nomHobby = nomHobby;
    }
}



