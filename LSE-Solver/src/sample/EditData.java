package sample;

import sample.math.KomplexeZahlExp;
import sample.math.KomplexeZahlKartesisch;
import sample.math.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class EditData {

    public static char[] removeCommentsAndEdit(char[] data) {
        ArrayList<Character> dataList = new ArrayList<>();

        for (char Char : data) {
            dataList.add((Character) Char);
        }

        for (int i = 0; i < dataList.size() - 1; i++) {
            if ((dataList.get(i).equals('/')) && (dataList.get(i + 1).equals('/'))) {
                int j = i;
                while (true) {
                    if (j > dataList.size() - 1) {
                        break;
                    }
                    if (dataList.get(j).equals('\n')) {
                        dataList.remove(j);
                        break;
                    }
                    dataList.remove(j);
                }
                i = 0;
            }
            if (dataList.get(i).equals(' ')) {
                dataList.remove(i);
            }
        }
        char[] dataWithoutComannts = new char[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            dataWithoutComannts[i] = (char) dataList.get(i);
        }
        return dataWithoutComannts;
    }

    public static double[][] toDoubleArray(char[] data) {

        String numberOfUnknowns = Controller.Unknowns.getText();
        int numberOfUnknownsInt;
        try {
            numberOfUnknownsInt = Integer.parseInt(numberOfUnknowns);
            if (numberOfUnknownsInt < 2) {
                throw new Exception();
            }
        } catch (Exception E) {
            Controller.output.setText("Wrong input at number of unknowns !");
            return null;
        }

        double[][] matrix = new double[numberOfUnknownsInt][numberOfUnknownsInt + 1];

        int x = 0;
        int y = 0;

        String zahl = "";

        for (int i = 0; i < data.length; i++) {
            if ((data[i] == '-') || (data[i] == '0') || (data[i] == '1') || (data[i] == '2') || (data[i] == '3') || (data[i] == '4') || (data[i] == '5') || (data[i] == '6') || (data[i] == '7') || (data[i] == '8') || (data[i] == '9') || (data[i] == '.')) {
                zahl += data[i];
            } else {
                if (!zahl.equals("")) {
                    try {
                        matrix[y][x] = Double.parseDouble(zahl);
                    } catch (Exception E) {
                        Controller.output.setText("Wrong input!");
                        return null;
                    }
                }
                if (data[i] == ',') {
                    x++;
                } else if (data[i] == ';') {
                    x = 0;
                    y++;
                } else if (data[i] == '\n') {

                } else {
                    Controller.output.setText("Wrong input!");
                    return null;
                }
                zahl = "";
            }
        }
        if ((y != numberOfUnknownsInt)) {
            Controller.output.setText("Wrong input!");
            return null;
        }
        return matrix;
    }

    public static KomplexeZahlKartesisch[][] toDoubleArrayComplexAbi(char[] data) throws Exception {

        String numberOfUnknowns = Controller.Unknowns.getText();
        int numberOfUnknownsInt;
        try {
            numberOfUnknownsInt = Integer.parseInt(numberOfUnknowns);
            if (numberOfUnknownsInt < 2) {
                throw new Exception();
            }
        } catch (Exception E) {
            Controller.output.setText("Wrong input at number of unknowns !");
            return null;
        }

        int x = 0;
        int y = 0;

        ArrayList<String> zahlen = new ArrayList<>();

        for (int i = 0; i < numberOfUnknownsInt * (numberOfUnknownsInt + 1); i++) {
            zahlen.add(i, "");
        }

        int a = 0;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] == 'j') || (data[i] == 'i') || (data[i] == '*') || (data[i] == '+') || (data[i] == '-') || (data[i] == '0') || (data[i] == '1') || (data[i] == '2') || (data[i] == '3') || (data[i] == '4') || (data[i] == '5') || (data[i] == '6') || (data[i] == '7') || (data[i] == '8') || (data[i] == '9') || (data[i] == '.')) {
                String temp = zahlen.get(a) + data[i];
                zahlen.set(a, temp);
            } else if (data[i] == '\n') {
                continue;
            } else {
                a++;
            }
        }

        if (zahlen.size() != numberOfUnknownsInt * (numberOfUnknownsInt + 1)) {
            throw new Exception();
        }

        for (String temp : zahlen) {
            if (temp.equals("")) {
                throw new Exception();
            }
        }

        double Re = 0;
        double Im = 0;
        int temp = 0;
        String tempRe = "";
        String tempIm = "";
        KomplexeZahlKartesisch[][] MatrixData = new KomplexeZahlKartesisch[numberOfUnknownsInt][numberOfUnknownsInt + 1];
        int X = 0;
        int Y = 0;

        int counter = 0;

        for (int i = 0; i < zahlen.size(); i++) {
            char[] zahl = zahlen.get(i).toCharArray();
            for (char ziffer : zahl) {
                if ((ziffer == ('0')) || (ziffer == ('1')) || (ziffer == ('2')) || (ziffer == ('3')) || (ziffer == ('4')) || (ziffer == ('5')) || (ziffer == ('6')) || (ziffer == ('7')) || (ziffer == ('8')) || (ziffer == ('9')) || (ziffer == ('.'))) {
                    if (temp == 0) {
                        tempRe += ziffer;
                    } else {
                        tempIm += ziffer;
                    }
                } else if (ziffer != '-') {
                    temp = 1;
                } else {
                    continue;
                }
            }
            temp = 0;
            if (tempRe == "") {
                tempRe = "0";
            }
            if (tempIm == "") {
                tempIm = "0";
            }
            if (zahl[0] == '-') {
                if (zahl[0] == '-' && (zahl[1] == 'i' || zahl[1] == 'j')) {
                    tempRe = tempRe.replace("-", "");
                    tempIm = "-" + tempIm;
                    zahl[0] = ' ';
                } else {
                    tempRe = "-" + tempRe;
                    zahl[0] = ' ';
                }
            }
            for (char k : zahl) {
                if (k == '-') {
                    tempIm = "-" + tempIm;
                }
            }
            System.out.println("\nHier12345");
            System.out.println(tempRe);
            System.out.println(tempIm);
            Re = Double.parseDouble(tempRe);
            Im = Double.parseDouble(tempIm);
            System.out.println("\nHier x=" + X + " y=" + Y);
            MatrixData[Y][X] = new KomplexeZahlKartesisch(Re, Im);
            MatrixData[Y][X].AbiAusgabe(MatrixData[Y][X]);
            tempRe = "";
            tempIm = "";
            System.out.println("Anzahl der Unbekannten = " + numberOfUnknownsInt);
            if (counter == numberOfUnknownsInt) {
                counter = 0;
                X = 0;
                Y++;
            } else {
                X++;
                counter++;
            }
        }

        Matrix.KomplexMatrixAusgabe(MatrixData);
        return MatrixData;
    }

    public static KomplexeZahlExp[][] toDoubleArrayComplexExp(char[] data) throws Exception {
        String numberOfUnknowns = Controller.Unknowns.getText();
        int numberOfUnknownsInt;
        try {
            numberOfUnknownsInt = Integer.parseInt(numberOfUnknowns);
            if (numberOfUnknownsInt < 2) {
                throw new Exception();
            }
        } catch (Exception E) {
            Controller.output.setText("Wrong input at number of unknowns !");
            return null;
        }

        int x = 0;
        int y = 0;

        System.out.println("ED1");

        ArrayList<String> zahlen = new ArrayList<>();

        for (int i = 0; i < numberOfUnknownsInt * (numberOfUnknownsInt + 1); i++) {
            zahlen.add(i, "");
        }

        int a = 0;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] == '<') || (data[i] == '-') || (data[i] == '0') || (data[i] == '1') || (data[i] == '2') || (data[i] == '3') || (data[i] == '4') || (data[i] == '5') || (data[i] == '6') || (data[i] == '7') || (data[i] == '8') || (data[i] == '9') || (data[i] == '.')) {
                String temp = zahlen.get(a) + data[i];
                zahlen.set(a, temp);
            } else if (data[i] == '\n') {
                continue;
            } else {
                a++;
            }
        }
        System.out.println("ED2");
        if (zahlen.size() != numberOfUnknownsInt * (numberOfUnknownsInt + 1)) {
            throw new Exception();
        }
        System.out.println("ED3");
        for (String temp : zahlen) {
            if (temp.equals("")) {
                throw new Exception();
            }
        }
        System.out.println("ED4");
        double Re = 0;
        double Im = 0;
        int temp = 0;
        String tempR = "";
        String tempArg = "";
        KomplexeZahlExp[][] MatrixData = new KomplexeZahlExp[numberOfUnknownsInt][numberOfUnknownsInt + 1];
        int X = 0;
        int Y = 0;

        int counter = 0;
        System.out.println("ED5");
        for (int i = 0; i < zahlen.size(); i++) {
            System.out.println("ED6");
            char[] zahl = zahlen.get(i).toCharArray();
            for (char ziffer : zahl) {
                if ((ziffer == ('0')) || (ziffer == ('1')) || (ziffer == ('2')) || (ziffer == ('3')) || (ziffer == ('4')) || (ziffer == ('5')) || (ziffer == ('6')) || (ziffer == ('7')) || (ziffer == ('8')) || (ziffer == ('9')) || (ziffer == ('.'))) {
                    if (temp == 0) {
                        tempR += ziffer;
                    } else {
                        tempArg += ziffer;
                    }
                } else if (ziffer != '-') {
                    temp = 1;
                } else {
                    continue;
                }
            }
            temp = 0;
            if (tempR == "") {
                tempR = "0";
            }
            if (tempArg == "") {
                tempArg = "0";
            }
            if (zahl[0] == '-') {
                if (tempArg.contains("-")) {
                    tempArg = tempArg.replace("-", "");
                } else {
                    tempArg = "-" + tempArg;
                }
                zahl[0] = ' ';
            }
            for (char k : zahl) {
                if (k == '-') {
                    if (tempArg.contains("-")) {
                        tempArg = tempArg.replace("-", "");
                    } else {
                        tempArg = "-" + tempArg;
                    }
                }
            }
            System.out.println("\nHier12345");
            System.out.println(tempR);
            System.out.println(tempArg);
            Re = Double.parseDouble(tempR);
            Im = Double.parseDouble(tempArg);
            System.out.println("\nHier x=" + X + " y=" + Y);
            MatrixData[Y][X] = new KomplexeZahlExp(Re, Im);
            MatrixData[Y][X].ExpAusgabe(MatrixData[Y][X]);
            System.out.println("");
            tempR = "";
            tempArg = "";
            if (counter == numberOfUnknownsInt) {
                counter = 0;
                X = 0;
                Y++;
            } else {
                X++;
                counter++;
            }
        }

        return MatrixData;
    }
}
