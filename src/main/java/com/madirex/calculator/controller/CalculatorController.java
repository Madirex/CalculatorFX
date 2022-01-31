package com.madirex.calculator.controller;

import com.madirex.calculator.model.CalculatorModel;
import com.madirex.calculator.utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalculatorController {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label screen;

    private CalculatorModel model;

    @FXML
    public void initialize() {
        this.model = new CalculatorModel();

        model.setResultado("");
        model.setOperando("");
        model.setOperation(' ');

        initListeners();
    }

    private void initListeners(){
        gridPane.getChildren().forEach(e -> ((Button) e).setOnAction(this::manageButton));
    }

    private void pressButton(String c) {
        char character = c.charAt(0);

        //NÚMEROS
        if (Util.isInteger(character)){
            //En el caso de que haya una operación asignada:
            if (model.getOperation() != ' '){
                model.setOperando(model.getOperando() + c); //Escribir en el operando
            }
            else{
                //De lo contrario, escribir en el resultado
                model.setResultado(model.getResultado() + c);
            }
        }
        //PUNTO (.)
        else if (character == '.'){
            //En el caso de que haya una operación asignada:
            if (model.getOperation() != ' '){
                //En el caso de que el operando tenga contenido Y NO tenga ya una marca para números decimales
                if (model.getOperando().length() > 0 && !model.getOperando().contains(".")){
                    model.setOperando(model.getOperando() + c);
                }
            }
            else{
                //En el caso de que el resultado tenga contenido Y NO tenga ya una marca para números decimales
                if (model.getResultado().length() > 0 && !model.getResultado().contains(".")) {
                    model.setResultado(model.getResultado() + c);
                }
            }
        }
        else{
            //Si hay operando
            if (model.getOperation() != ' '){
                doOperation();
            }

            //Asignar la operación pulsada
            if (c.charAt(0) != '=') {
                model.setOperation(c.charAt(0));
            }
        }
    }

    private void doOperation() {
        //Asignar resultado
        double resultado;
        if (model.getResultado().isEmpty()){
            resultado = 0.0;
        }else{
            resultado = Double.parseDouble(model.getResultado());
        }

        //Asignar operando
        double operando;
        if (model.getOperando().isEmpty()){
            operando = 0.0;
        }else{
            operando = Double.parseDouble(model.getOperando());
        }

        switch(model.getOperation()){
            case '*':
                model.setResultado(resultado * operando + "");
                resetValues();
                break;
            case '/':
                if (operando == 0){
                    model.setResultado(resultado + "");
                }else{
                    model.setResultado(resultado / operando + "");
                }

                resetValues();
                break;
            case '-':
                model.setResultado(resultado - operando + "");
                resetValues();
                break;
            case '+':
                model.setResultado((resultado + operando) + "");
                resetValues();
                break;

            default:
                System.err.println("No se ha encontrado la acción de operar.");
                break;
        }
    }

    private void resetValues() {
        model.setOperando("");
        model.setOperation(' ');
    }

    public void manageButton(ActionEvent e){
        pressButton(((Button) e.getSource()).getText());
        screen.setText(model.getResultado() + " " + model.getOperation() + " " + model.getOperando());
    }
}