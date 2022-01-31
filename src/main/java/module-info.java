module com.madirex.madicalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.madirex.calculator to javafx.fxml;
    exports com.madirex.calculator.controller;
    opens com.madirex.calculator.controller to javafx.fxml;
    exports com.madirex.calculator.view;
    opens com.madirex.calculator.view to javafx.fxml;
}