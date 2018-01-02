package sample.math;

import sample.Controller;

public class Solve {

    public static void SolveReal(double[][] a) {
        double[] result = new double[a.length];
        double faktor = 0;

        for (int i = 0; i < a.length; i++) {
            result[i] = 0;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a.length; j++) {
                faktor = faktor + (result[j] * a[i][j]);
            }
            faktor = faktor - (result[i] * a[i][i]);
            result[i] = (a[i][a.length] - faktor) / (a[i][i]);
            System.out.println(result[i]);
            faktor = 0;
        }
        for (int i = 0; i < a.length; i++) {
            result[i] = Math.rint(result[i] * 10000) / 10000;
            Controller.Output += "x" + i + " = " + result[i] + "\n";
        }
    }

    public static void SolveKomplexAbi(KomplexeZahlKartesisch[][] a) {
        KomplexeZahlKartesisch[] result = new KomplexeZahlKartesisch[a.length];
        KomplexeZahlKartesisch faktor = new KomplexeZahlKartesisch();

        for (int i = 0; i < a.length; i++) {
            result[i] = faktor;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a.length; j++) {
                faktor = faktor.AbiAddieren(faktor, result[j].AbiMultiplizieren(result[j], a[i][j]));
            }
            faktor = faktor.AbiSubtrahieren(faktor, (result[i].AbiMultiplizieren(result[i], a[i][i])));
            result[i] = (a[i][i]).AbiDividieren(a[i][a.length].AbiSubtrahieren(a[i][a.length], faktor), (a[i][i]));
            //result[i].AbiAusgabe(result[i]);
            faktor = new KomplexeZahlKartesisch();
        }
        for (int i = 0; i < a.length; i++) {
            result[i].setReal(Math.rint(result[i].getRe() * 10000) / 10000);
            result[i].setImag(Math.rint(result[i].getIm() * 10000) / 10000);
            Controller.Output += "x" + i + " = " + result[i].AbiAusgabeString(result[i]) + "\n";
        }
    }
}
