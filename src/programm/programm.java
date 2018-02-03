package programm;

import model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class programm {

    public static void main(String[] args) {
/*
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));*/

        Scanner scanner = new Scanner(System.in);
        int userInput = 9;
        Karte aykutKarte = new Karte(1122, 1, KartenTyp.BANKOMATKARTE);
        Eigentümer aykut = new Eigentümer("Aykut", 3000, aykutKarte, KontoTyp.BUSINESSKONTO);
        Konto aykutKonto = new Konto(3000, KontoTyp.BUSINESSKONTO, aykut);
        aykutKarte.setEigentümer(aykut);
        aykutKarte.setKonto(aykutKonto);
        ATM atm = new ATM("Erste Bank", 60000, 1);

        while (userInput != 0) {

            System.out.println("(1) für Kreditrahmen");
            System.out.println("(2) für Kontostand");
            System.out.println("(3) Geld abheben");
            System.out.println("(4) Geldbestand des Bankomaten");
            System.out.println("(0) zum Beenden");
            System.out.print(": ");
            userInput = scanner.nextInt();

            switch (userInput) {

                case 1:
                    System.out.println("Ihr Kreditrahmen beträgt: " + aykutKonto.getKreditrahmen() + "€\n");
                    break;

                case 2:
                    System.out.println("Ihr Kontostand: " + aykutKonto.getKontostand() + "€\n");
                    break;

                case 3:
                    System.out.print("Bitte PIN einegeben: ");
                    int pin = scanner.nextInt();
                    System.out.print("Bitte Geldbetrag einegeben: ");
                    int geldBetrag = scanner.nextInt();
                    if (atm.abbuchen(aykutKarte, geldBetrag, pin)){
                        System.out.println("Es werden " + geldBetrag + " abgehoben.");
                        System.out.println("Ihr Kontostand: " + aykutKonto.getKontostand() + "€\n");
                    }
                    else {
                        atm.abbuchen(aykutKarte, geldBetrag, pin);
                    }
                    break;

                case 4:
                    System.out.println("Im Bankomaten sind noch " + atm.getGeldbestand() + "€\n");
                    break;

                default:
                    break;
            }
        }
    }
}
