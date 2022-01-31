package com.madirex.calculator.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorView.class.getResource("calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setMinWidth(350);
        stage.setMinHeight(400);
        stage.setTitle("MadiCalculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}