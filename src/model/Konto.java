package model;

import java.util.ArrayList;
import java.util.List;

public class Konto {

    private float kontostand;
    private KontoTyp kontoTyp;
    private float kreditrahmen;
    private Eigentümer eigentümer;
    private List<Karte> karten = new ArrayList<Karte>();
    private List<Buchung> buchungen = new ArrayList<Buchung>();

    public Konto(float kontostand, KontoTyp kontoTyp, float kreditrahmen, Eigentümer eigentümer) {
        this.kontostand = kontostand;
        this.kontoTyp = kontoTyp;
        this.kreditrahmen = kreditrahmen;
        this.eigentümer = eigentümer;
    }

    public Eigentümer getEigentümer() {
        return eigentümer;
    }

    public float getKontostand() {
        return kontostand;
    }

    public void setKontostand(float kontostand) {
        this.kontostand = kontostand;
    }

    public KontoTyp getKontoTyp() {
        return kontoTyp;
    }

    public float getKreditrahmen() {
        return kreditrahmen;
    }

    public void addKarte(Karte karte){

        if (karte != null){
            this.karten.add(karte);
        }
    }

    public boolean deleteKarte(Karte karte){
        return this.karten.remove(karte);
    }

    public Karte getKarte(int position){
        return this.karten.get(position);
    }

    public void addBuchung(Buchung buchung){

        if (buchung != null) {

            this.buchungen.add(buchung);
        }
    }

    public boolean deleteBuchung(Buchung buchung){
        return this.buchungen.remove(buchung);
    }

    public Buchung getBuchung(int position){
        return this.buchungen.get(position);
    }

    public boolean abbuchen(int betrag){

        //TODO: implement method
    }

}
