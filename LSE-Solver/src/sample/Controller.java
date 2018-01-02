package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import sample.math.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // Gui elements
    public Button solveC;
    public Button solveR;
    public CheckBox sbsS;
    public static TextArea input;
    public static TextArea output;
    public static CheckBox exp;
    public static CheckBox abi;
    //public static Label output;
    public static TextField Unknowns;
    // Class variables
    public static Boolean StepByStepSolution = false;
    public static Boolean Exp = false;
    public static Boolean Abi = false;
    public static String Output;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * @param actionEvent Button to solve the System of linear equations including complex Numbers.
     */
    public void solveComplex(ActionEvent actionEvent) {
        ReadDataComplex data = new ReadDataComplex();
    }

    /**
     * @param actionEvent Button to solve the System of linear equations including real Numbers.
     */
    public void solveReal(ActionEvent actionEvent) {
        ReadDataReal data = new ReadDataReal();
    }

    /**
     * @param actionEvent Check Box to show a Step-by-Step Solution.
     */
    public void sbsSolution(ActionEvent actionEvent) {
        StepByStepSolution = sbsS.isSelected();
    }

    public void expSet(ActionEvent actionEvent) {
        Exp = exp.isSelected();
    }

    public void abiSet(ActionEvent actionEvent) {
        Abi = abi.isSelected();
    }
}
