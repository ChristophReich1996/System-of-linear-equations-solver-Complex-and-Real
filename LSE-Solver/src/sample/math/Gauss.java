package sample.math;

import sample.Controller;

public class Gauss {

    public static double[][] Gausseli(double[][] a) {


        boolean SbS = Controller.StepByStepSolution;

        if (SbS) {
            Controller.Output += Matrix.MatrixToString(a);
        }

        for (int j = 0; j < a[0].length; j++) {
            for (int f = 1 + j; f < a[0].length - 1; f++) {
                if (a[f][j] != 0) {
                    double factor = a[j][j] / a[f][j];
                    for (int h = 0; h < a[0].length; h++) {
                        a[f][h] = a[j][h] - (factor * a[f][h]);
                    }
                    if (SbS) {
                        Controller.Output += "Row " + (j+1) + " - (" + factor + " * Row " + (f+1) + ") = Row " + (f+1) + "\n\n";
                        Controller.Output += Matrix.MatrixToString(a);
                    }
                }
            }
        }

        Matrix.MatrixAusgabe(a);

        if (a[a.length - 1][a.length - 1] == 0) {
            Controller.Output = "System has no solution !\n\n";
        } else if (Determinante.DeterminanteTreppe(a) == 0) {
            Controller.Output = "System has no solution !\n\n";
        }

        return a;
    }

    public static KomplexeZahlKartesisch[][] KomplexGausseli(KomplexeZahlKartesisch[][] a) {

        System.out.println("Gauss");

        boolean SbS = Controller.StepByStepSolution;

        if (SbS) {
            Controller.Output += Matrix.MatrixAbiToString(a);
        }

        if (!SbS) {
            Controller.Output += "\n";
        }

        for (int j = 0; j < a[0].length; j++) {
            for (int f = 1 + j; f < a[0].length - 1; f++) {
                if (!((a[f][j].getRe() == 0) && (a[f][j].getIm() == 0))) {
                    KomplexeZahlKartesisch factor = a[j][j].AbiDividieren(a[j][j], a[f][j]);
                    for (int h = 0; h < a[0].length; h++) {
                        a[f][h] = a[j][h].AbiSubtrahieren(a[j][h], factor.AbiMultiplizieren(factor, a[f][h]));
                    }
                    if (SbS) {
                        Controller.Output += "Row " + (j+1) + " - (" + factor.AbiAusgabeString(factor) + " * Row " + (f+1) + ") = Row " + (f+1) + "\n\n";
                        Controller.Output += Matrix.MatrixAbiToString(a);
                    }
                }
            }
        }

        System.out.println("Gauss3");

        Matrix.KomplexMatrixAusgabe(a);

        if ((a[a.length - 1][a.length - 1].getRe() == 0) && (a[a.length - 1][a.length - 1].getIm() == 0)) {
            Controller.Output = "System has no solution !\n\n";
        }

        return a;
    }

}
