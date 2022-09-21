package fr.example.artisoraan;

public class HelperClass {
    String nom , prenom , email , num , profession , mdp  ;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public HelperClass(String nom, String prenom, String email, String num, String profession) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num = num;
        this.profession = profession;


    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }



    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }




    public HelperClass() {

    }
}
