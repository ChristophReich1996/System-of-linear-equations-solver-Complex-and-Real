package sample;

import sample.math.*;

public class ReadDataComplex {
    // Class variables
    private String data;

    // Constructor
    public ReadDataComplex() {
        Controller.output.setText("");
        Controller.Output = "";
        this.data = Controller.input.getText();
        data = data.replace("17*pi/12", "4.450589594");
        data = data.replace("13*pi/12", "3.403392041");
        data = data.replace("5*pi/3", "5.235987758");
        data = data.replace("3*pi/2", "4.712388981");
        data = data.replace("4*pi/3", "4.188790204");
        data = data.replace("5*pi/4", "3.926990818");
        data = data.replace("7*pi/6", "3.665191431");
        data = data.replace("pi/12", "0.2617993878");
        data = data.replace("pi/11", "0.2855993322");
        data = data.replace("pi/10", "0.3141592654");
        data = data.replace("pi/9", "0.3490658504");
        data = data.replace("pi/8", "0.3926990818");
        data = data.replace("pi/7", "0.4487989507");
        data = data.replace("pi/6", "0.5235987758");
        data = data.replace("pi/5", "0.6283185308");
        data = data.replace("pi/4", "0.7853981635");
        data = data.replace("pi/3", "1.047197551");
        data = data.replace("pi/2", "1.570796327");
        data = data.replace("2*pi", "6.283185308");
        data = data.replace("3*pi", "9.424777962");
        data = data.replace("pi", "3.141592654");
        data = data.replace("sqrt(2)", "1.414213562");
        data = data.replace("sqrt(3)", "1.732050808");
        data = data.replace("2*e", "5.436563656");
        data = data.replace("3*e", "8.154845484");
        data = data.replace("4*e", "10.87312731");
        data = data.replace("5*e", "13.59140914");
        data = data.replace("10*e", "27.18281828");
        data = data.replace("e", "2.718281828");
        char[] dataMatrix = data.toCharArray();
        int NumberOfUnknowns;
        try {
            NumberOfUnknowns = Integer.parseInt(Controller.Unknowns.getText());
            if (NumberOfUnknowns > 1) {
                dataMatrix = EditData.removeCommentsAndEdit(dataMatrix);
                if (Controller.Exp && !Controller.Abi) {
                    KomplexeZahlExp[][] MatrixExp = EditData.toDoubleArrayComplexExp(dataMatrix);
                    Controller.Output += Matrix.KomplexMatrixAusgabeExpString(MatrixExp) + "\n";
                    KomplexeZahlKartesisch[][] MatrixAbiAusExp = Matrix.KomplexeExpMatrixInAbi(MatrixExp);
                    MatrixAbiAusExp = Gauss.KomplexGausseli(MatrixAbiAusExp);
                    Solve.SolveKomplexAbi(MatrixAbiAusExp);
                    Controller.output.setText(Controller.Output);
                } else if (!Controller.Exp && Controller.Abi) {
                    KomplexeZahlKartesisch[][] MatrixAbi = EditData.toDoubleArrayComplexAbi(dataMatrix);
                    MatrixAbi = Gauss.KomplexGausseli(MatrixAbi);
                    Solve.SolveKomplexAbi(MatrixAbi);
                    Controller.output.setText(Controller.Output);
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception A) {
            Controller.output.setText("Wrong input!(33)");
        }
    }
}
