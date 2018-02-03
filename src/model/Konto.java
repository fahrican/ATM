package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Konto {

    private float kontostand;
    private KontoTyp kontoTyp;
    private float kreditrahmen;
    private Eigentümer eigentümer;
    private List<Karte> karten = new ArrayList<Karte>();
    private List<Buchung> buchungen = new ArrayList<Buchung>();

    public Konto(float kontostand, KontoTyp kontoTyp, Eigentümer eigentümer) {
        this.kontostand = kontostand;
        this.kontoTyp = kontoTyp;
        this.eigentümer = eigentümer;
    }

    public Eigentümer getEigentümer() {
        return eigentümer;
    }

    public float getKontostand() {
        return kontostand;
    }

    public float setKontostand(float betrag) {
        this.kontostand -= betrag;
        return this.getKontostand();
    }

    public KontoTyp getKontoTyp() {
        return kontoTyp;
    }

    public float getKreditrahmen() {

        return (this.getKontoTyp() == KontoTyp.STUDENTENKONTO) ? 500.00f : 10000.00f;
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

    /*
    * checks if the amount to draw of money is more
    * than the amount of money in the bank account
    * */
    public boolean abbuchen(int betrag){

        if (betrag > this.getKontostand()){

            if (this.setKontostand(betrag) >= this.getKreditrahmen()) {
                this.setKontostand(betrag);
                this.buchungen.add(new Buchung(new Date(), karten.get(0).getId(), betrag));
                return true;
            }
            return false;
        }
        else {

            this.setKontostand(betrag);
        }
        return true;
    }

}
