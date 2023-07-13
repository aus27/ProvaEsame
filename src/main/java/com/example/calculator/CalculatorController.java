package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static jdk.internal.org.jline.utils.Log.error;

public class CalculatorController {


    @FXML
    Button comma;
    @FXML
    Button zero;
    @FXML
    Button equal;
    @FXML
    Button plus;
    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button minus;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button cross;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;
    @FXML
    Button divide;
    @FXML
    Button can;
    @FXML
    Label screen;
    @FXML
    Button log;
    @FXML
    Button root;
    @FXML
    Button exp;
    @FXML
    Button power;

    String op = "";
    double number1 = 0;
    double number2 = 0;

    public void onNumberClick(ActionEvent ae) {
        String no = ((Button)ae.getSource()).getText();
        screen.setText(screen.getText() + no);
    }

    public void onCancelClick() {
        op = "";
        screen.setText("");
        number1 = 0;

        plus.setDisable(false);
        minus.setDisable(false);
        cross.setDisable(false);
        divide.setDisable(false);
        equal.setDisable(false);
        power.setDisable(false);
        root.setDisable(false);
        exp.setDisable(false);
        log.setDisable(false);
    }

    public void onEqualClick() {
        if(screen.getText().isEmpty()) return;

        number2 = Double.parseDouble(screen.getText());
        switch (op) {
            case "+" -> screen.setText(number1 + number2 + "");
            case "-" -> screen.setText(number1 - number2 + "");
            case "x" -> screen.setText(number1 * number2 + "");
            case "/" -> {
                if (number2 == 0){
                    screen.setText("Impossible to divide by zero");
                    onDisable();
                    break;
                }
                screen.setText(number1 / number2 + "");
            }
            case "^" -> screen.setText(Math.pow(number1,number2) + "");
            default -> error();
        }
        op = "";
    }

    public void onPlusClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        op = "+";
        screen.setText("");
    }

    public void onMinusClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        op = "-";
        screen.setText("");
    }

    public void onCrossClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        op = "x";
        screen.setText("");
    }

    public void onDivideClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        op = "/";
        screen.setText("");
    }

    public void onPowerClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        op = "^";
        screen.setText("");
    }

    public void onLogClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        if (number1 == 0){
            screen.setText("Invalid input");
            onDisable();
        }

        screen.setText(Math.log10(number1) + "");

        op = "";
    }

    public void onRootClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        screen.setText(Math.sqrt(number1) + "");

        op = "";
    }

    public void onExpClick() {
        if(screen.getText().isEmpty()) return;

        if(!op.equals("")){
            return;
        }
        number1 = Double.parseDouble(screen.getText());

        screen.setText(Math.exp(number1) + "");

        op = "";
    }

    private void onDisable() {
        plus.setDisable(true);
        minus.setDisable(true);
        cross.setDisable(true);
        divide.setDisable(true);
        equal.setDisable(true);
        power.setDisable(true);
        root.setDisable(true);
        exp.setDisable(true);
        log.setDisable(true);
    }


}