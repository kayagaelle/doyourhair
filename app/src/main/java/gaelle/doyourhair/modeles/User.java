package gaelle.doyourhair.modeles;

import java.util.Date;

/**
 * Created by HP on 22/01/2019.
 */
@Entity(foreignKeys = @ForeignKey(entity = Adresse.class,parentColums ="idAdresse" ; childColumns ="idAdresse"))
public class User {

    @PrimaryKey(autoGenerate = true)
    private long idUser;
    private String mail;
    private String motDePasse;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String photo;
   // private int idAdresse;
    private char sexe;




    public User() { }

    public User(String mail, String motDePasse) {
        this.mail = mail;
        this.motDePasse = motDePasse;

    }

    // --- GETTER ---


    // --- SETTER ---





}
