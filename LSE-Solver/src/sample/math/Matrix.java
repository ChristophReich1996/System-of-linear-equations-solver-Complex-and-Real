package sample.math;

public class Matrix {

    public static KomplexeZahlKartesisch[][] Entwickeln1Reihe1(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[3][3];

        for (int v = 1; v <= 3; v++) {
            for (int i = 1; i <= 3; i++) {
                b[i - 1][v - 1] = a[i][v];
            }
        }

        return b;
    }

    public static KomplexeZahlKartesisch[][] Entwickeln1Reihe2(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[3][3];

        for (int i = 1; i <= 3; i++) {
            b[0][i - 1] = a[0][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[1][i - 1] = a[2][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[2][i - 1] = a[3][i];
        }

        return b;
    }

    public static KomplexeZahlKartesisch[][] Entwickeln1Reihe3(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[3][3];

        for (int i = 1; i <= 3; i++) {
            b[0][i - 1] = a[0][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[1][i - 1] = a[1][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[2][i - 1] = a[3][i];
        }

        return b;
    }

    public static KomplexeZahlKartesisch[][] Entwickeln1Reihe4(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[3][3];

        for (int i = 1; i <= 3; i++) {
            b[0][i - 1] = a[0][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[1][i - 1] = a[1][i];
        }

        for (int i = 1; i <= 3; i++) {
            b[2][i - 1] = a[2][i];
        }

        return b;
    }

    public static KomplexeZahlKartesisch[][] KomplexVektorInMatrix(KomplexeZahlKartesisch[][] a, int Stelle) {

        KomplexeZahlKartesisch[][] c = new KomplexeZahlKartesisch[a.length][a.length - 1];

        for (int i = 0; i < (a.length - 1); i++) {
            for (int j = 0; j < a.length; j++) {
                c[j][i] = a[j][i];
            }
        }


        for (int i = 0; i < (a.length - 1); i++) {
            c[Stelle - 1][i] = a[a.length - 1][i];
        }

        return c;

    }

    public static double[][] VektorInMartix(double[][] a, int Stelle) {


        double[][] v = new double[a.length][a.length - 1];

        for (int i = 0; i < v.length; i++) {
            for (int f = 0; f < (v.length - 1); i++) {
                v[i][f] = a[i][f];
            }
        }

        for (int i = 0; i < (v.length - 1); i++) {
            v[Stelle - 1][i] = a[a.length - 1][i];
        }
        return v;
    }

    public static KomplexeZahlKartesisch[][] MatrixUmwandelnExpAbi(KomplexeZahlExp a[][]) {

        KomplexeZahlExp c = new KomplexeZahlExp();

        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[a.length][a.length - 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                b[i][j] = c.UmwandelnExpAbi(a[i][j]);
            }
        }
        return b;
    }

    public static KomplexeZahlExp[][] MatrixUmwandelnAbiExp(KomplexeZahlKartesisch a[][]) {

        KomplexeZahlKartesisch c = new KomplexeZahlKartesisch();

        KomplexeZahlExp[][] b = new KomplexeZahlExp[a.length][a.length - 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                b[i][j] = c.UmwandelnAbiExp(a[i][j]);
            }
        }
        return b;
    }

    public static void MatrixAusgabe(double[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= a.length; j++) {
                if (j == a.length) {
                    System.out.print("|" + a[i][j] + "   ");
                } else {
                    System.out.print("" + a[i][j] + "   ");
                }
            }
            System.out.println("");
        }
    }

    public static String MatrixToString(double[][] a) {
        String data = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= a.length; j++) {
                if (j == a.length) {
                    data += "|" + a[i][j] + "   ";
                } else {
                    data += "" + a[i][j] + "   ";
                }
            }
            data += "\n";
        }
        return data + "\n";
    }

    public static String MatrixAbiToString(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch temp = new KomplexeZahlKartesisch();

        String data = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= a.length; j++) {
                if (j == a.length) {
                    data += "|" + temp.AbiAusgabeString(a[i][j]) + "   ";
                } else {
                    data += "" + temp.AbiAusgabeString(a[i][j]) + "   ";
                }
            }
            data += "\n";
        }
        return data + "\n";
    }

    public static void KomplexMatrixAusgabe(KomplexeZahlKartesisch[][] a) {

        KomplexeZahlKartesisch c = new KomplexeZahlKartesisch();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length + 1; j++) {

                if (j == a.length) {
                    System.out.print("|");
                    c.AbiAusgabe(a[i][j]);
                } else {
                    c.AbiAusgabe(a[i][j]);
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }

    public static void KomplexMatrixAusgabeExp(KomplexeZahlExp[][] a) {

        KomplexeZahlExp c = new KomplexeZahlExp();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length + 1; j++) {

                if (j == a.length) {
                    System.out.print("|");
                    c.ExpAusgabe(a[i][j]);
                } else {
                    c.ExpAusgabe(a[i][j]);
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }

    }

    public static String KomplexMatrixAusgabeExpString(KomplexeZahlExp[][] a) {

        KomplexeZahlExp c = new KomplexeZahlExp();

        String temp = "";

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length + 1; j++) {

                if (j == a.length) {
                    temp += "|";
                    temp += c.ExpAusgabeString(a[i][j]);
                } else {
                    temp += c.ExpAusgabeString(a[i][j]);
                    temp += "   ";
                }
            }
            temp += "\n";
        }
        return temp;
    }


    public static KomplexeZahlKartesisch[][] KomplexeExpMatrixInAbi(KomplexeZahlExp[][] a) {

        KomplexeZahlExp c = new KomplexeZahlExp();
        KomplexeZahlKartesisch[][] b = new KomplexeZahlKartesisch[a.length][a.length + 1];

        for (int i = 0; i < (a.length); i++) {
            for (int j = 0; j < a.length + 1; j++) {
                b[i][j] = c.UmwandelnExpAbi(a[i][j]);
            }
        }
        return b;
    }
}
