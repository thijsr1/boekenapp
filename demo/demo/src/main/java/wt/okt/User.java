package wt.okt;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column
    private String titel;

    @Column
    private String auteur;

    @Column
    private int aantalExemplaren;

    @Column
    private String afbeeldingURL;



    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAantalExemplaren() {
        return aantalExemplaren;
    }
    public void setAantalExemplaren(int aantalExemplaar) {
        this.aantalExemplaren = aantalExemplaar;
    }


    public String getAfbeeldingURL() {
        return afbeeldingURL;
    }
    public void setAfbeeldingURL(String afbeeldingURL) {
        this.afbeeldingURL = afbeeldingURL;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }



}
