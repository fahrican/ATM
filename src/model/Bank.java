package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Konto> konten = new ArrayList<Konto>();
    private ATM atm;

    public Bank(){

    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public void addKonto(Konto konto){

        if(konto != null){
            this.konten.add(konto);
        }
    }

    public boolean deleteKonto(Konto konto){
        return this.konten.remove(konto);
    }

    public Konto getKonto(int position){
        return this.konten.get(position);
    }
}
