package model;

import java.util.Date;

public class Karte {

    private int code;
    private int id;
    private KartenTyp kartenTyp;
    private Konto konto;
    private float maxProTag = 500;
    private Date date;
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

    //only valid for students
    private boolean setMaxProTag(int betrag, Date date) {

        if (this.getDate().compareTo(date) == 0){

            if((this.maxProTag - betrag) > 0){

                this.maxProTag -= betrag;
                System.out.println(betrag + " wurden abgebucht, Sie können heute noch " + this.getMaxProTag() + "€ abbuchen.");
                return true;
            }
            else {
                System.out.println("Sie haben Ihr Tageslimit für ihr Studentenkonto bereits überschritten, kommen Sie morgen wieder.");
                return false;
            }
        }
        else {

            if((this.maxProTag - betrag) > 0){

                this.maxProTag -= betrag;
                System.out.println(betrag + " wurden abgebucht, Sie können heute noch " + this.getMaxProTag() + "€ abbuchen.");
                return true;
            }
        }
        return false;
    }


    public void abbuchen(Konto k, int betrag, int code, Date date) {

        if (this.authentifizieren(code)){

            checkKontoTyp(k, betrag, date);
        }
        else {
            System.out.println("Falscher PIN!!");
        }
    }

    public boolean authentifizieren(int code) {

        return (code == this.getCode()) ? true : false;
    }

    //checks if the bank account is for a students or business client
    private void checkKontoTyp(Konto k, int betrag, Date date){

        if (k.getKontoTyp() == KontoTyp.STUDENTENKONTO) {

            if (this.setMaxProTag(betrag, date)) {

                if (this.getKonto().abbuchen(betrag)) {

                    this.getKonto().abbuchen(betrag);
                }
            }
            else {
                System.out.println("Sie haben Ihr Tageslimit für ihr Studentenkonto bereits überschritten, kommen Sie morgen wieder.");
            }
        }
        else if (k.getKontoTyp() == KontoTyp.BUSINESSKONTO){

            if (this.getKonto().abbuchen(betrag)) {

                this.getKonto().abbuchen(betrag);
            }
        }
    }
}
