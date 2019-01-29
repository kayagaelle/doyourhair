package gaelle.doyourhair.model;


import java.util.Date;

public class User {
    private String idUser;
    private String mail;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String photo;
    private String adresse;
    private double latitude;
    private double longitude;
    private String sexe;
    private boolean isCoiffeuse;

    public User() {
        //
    }

    public User(String idUser, String mail, String nom, String prenom, boolean isCoiffeuse, double latitude, double longitude) {
        this.idUser = idUser;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.isCoiffeuse = isCoiffeuse;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public boolean isCoiffeuse() {
        return isCoiffeuse;
    }

    public void setCoiffeuse(boolean coiffeuse) {
        isCoiffeuse = coiffeuse;
    }
}
