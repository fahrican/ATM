package model;

public class ATM {

    private String bezeichnung;
    private float geldbestand;
    private int id;

    public ATM(String bezeichnung, float geldbestand, int id) {
        this.bezeichnung = bezeichnung;
        this.geldbestand = geldbestand;
        this.id = id;
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

    public void abbuchen(Karte k, float geldBetrag) {
        //TODO: finish implementation
        k.abbuchen(k.getKonto(), );
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
