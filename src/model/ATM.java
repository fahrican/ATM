package model;

import java.util.Calendar;
import java.util.Date;

public class ATM {

    private String bezeichnung;
    private float geldbestand;
    private int id;
    private Date date = Calendar.getInstance().getTime();

    public ATM(String bezeichnung, float geldbestand, int id) {
        this.bezeichnung = bezeichnung;
        this.geldbestand = geldbestand;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public float getGeldbestand() {
        return geldbestand;
    }

    public int getId() {
        return id;
    }

    public boolean abbuchen(Karte k, int geldBetrag, int code) {
        if (k.abbuchen(k.getKonto(), geldBetrag, code, getDate())) {
            return true;
        }
        return false;
    }

    public void limitAbfragen(Karte k) {

        if (k.getKonto().getKontoTyp() == KontoTyp.STUDENTENKONTO) {
            System.out.println("Ihr Überziehungsrahmen beträgt -500€");
        }
        else {
            System.out.println("Ihr Überziehungsrahmen beträgt -10.000€");
        }
    }

}
