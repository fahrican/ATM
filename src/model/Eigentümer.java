package model;

public class Eigentümer {

    private String name;
    private double saldo;
    private Karte karte;
    private KontoTyp kontoTyp;

    public Eigentümer(String name, double saldo, Karte karte, KontoTyp kontoTyp) {
        this.name = name;
        this.saldo = saldo;
        this.karte = karte;
        this.kontoTyp = kontoTyp;
    }

    public double getSaldo() {
        return saldo;
    }

    public Karte getKarte() {
        return karte;
    }

    public String getName() {
        return name;
    }

    public KontoTyp getKontoTyp() {
        return kontoTyp;
    }

}
