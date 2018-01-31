package model;

import java.util.Date;

public class Karte {

    private int code;
    private int id;
    private KartenTyp kartenTyp;
    private Konto konto;
    private float maxProTag = 500;
    private Date date;
    private float maxProWoche;
    private Eigentümer eigentümer;

    public Karte(int code, int id, KartenTyp kartenTyp, Konto konto, Eigentümer eigentümer) {
        this.code = code;
        this.id = id;
        this.kartenTyp = kartenTyp;
        this.konto = konto;
        this.eigentümer = eigentümer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Eigentümer getEigentümer() {
        return eigentümer;
    }

    public int getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    public KartenTyp getKartenTyp() {
        return kartenTyp;
    }

    public Konto getKonto() {
        return konto;
    }

    public float getMaxProTag() {
        return maxProTag;
    }

    public void setMaxProTag(float betrag, Date date) {

        if (this.getDate().compareTo(date) == 0){

            if((this.maxProTag - betrag) > 0){

                this.maxProTag -= betrag;
                System.out.println(betrag + " wurden abgebucht, Sie können heute noch " + this.getMaxProTag() + "€ abbuchen.");
            }
            else {
                System.out.println("Sie haben Ihr Tageslimit bereits überschritten, kommen Sie morgen wieder.");
            }
        }
        else {

            if((this.maxProTag - betrag) > 0){

                this.maxProTag -= betrag;
                System.out.println(betrag + " wurden abgebucht, Sie können heute noch " + this.getMaxProTag() + "€ abbuchen.");
            }
        }

    }

    public float getMaxProWoche() {
        return maxProWoche;
    }

    public void abbuchen(Konto k, int betrag) {

        if (k.getKontoTyp() == KontoTyp.STUDENTENKONTO) {

            if () {

                System.out.println();
            }
        }
    }

    public boolean authentifizieren(int code) {

    }
}
