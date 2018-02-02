package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Buchung {

    private Date datum = new Date();;
    private int kartenID;
    private float summe;

    public Buchung(Date datum, int kartenID, float summe) {
        this.datum = datum;
        this.kartenID = kartenID;
        this.summe = summe;
    }

    public String getDatum() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(datum);
    }

    public int getKartenID() {
        return kartenID;
    }

    public float getSumme() {
        return summe;
    }
}
