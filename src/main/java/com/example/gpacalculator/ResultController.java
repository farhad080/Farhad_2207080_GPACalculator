package com.example.gpacalculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultController {

    @FXML private Label resultLabel;

    @FXML
    public void initialize() {
        double total = 0;
        double weighted = 0;

        for (Course c : FormController.courses) {
            total += c.credit;
            weighted += c.credit * gradeToPoint(c.grade);
        }

        double gpa = weighted / total;
        resultLabel.setText("Your GPA: " + String.format("%.2f", gpa));
    }

    @FXML
    public void backHome() {
        try {
            FormController.courses.clear();
            Stage stage = (Stage) resultLabel.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("hello-view.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double gradeToPoint(String g) {
        switch (g) {
            case "A+": return 4.0;
            case "A": return 3.75;
            case "A-": return 3.50;
            case "B+": return 3.25;
            case "B": return 3.00;
            case "B-": return 2.75;
            case "C+": return 2.50;
            case "C": return 2.25;
            case "D": return 2.00;
            default: return 0.0;
        }
    }
}
