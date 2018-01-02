package sample.math;

public class Determinante {

    public static double DeterminateZweiXZwei(double[][] a) {

        double Determinanite2x2;

        Determinanite2x2 = ((a[0][0] * a[1][1]) - (a[1][0] * a[0][1]));

        return Determinanite2x2;
    }

    public static double DeterminanteDreiXDrei(double[][] a) {

        double Determinanite3x3;

        Determinanite3x3 = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[2][0] * a[0][1] * a[1][2]) - (a[0][2] * a[1][1] * a[2][0]) - (a[1][2] * a[2][1] * a[0][0]) - (a[2][2] * a[0][1] * a[1][0]);

        return Determinanite3x3;
    }

    public static double DeterminanteTreppe(double[][] a) {

        double DeterminanteTreppe = 1;

        for (int i1 = 0; i1 < a.length - 1; i1++) {
            DeterminanteTreppe = (DeterminanteTreppe * a[i1][i1]);
        }

        return DeterminanteTreppe;
    }

}
