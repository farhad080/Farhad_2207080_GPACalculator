package com.example.gpacalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FormController {

    @FXML private TextField courseNameField;
    @FXML private TextField courseCodeField;
    @FXML private TextField courseCreditField;
    @FXML private TextField teacher1Field;
    @FXML private TextField teacher2Field;
    @FXML private ComboBox<String> gradeBox;
    @FXML private Button calcBtn;

    public static ArrayList<Course> courses = new ArrayList<>();

    @FXML
    public void initialize() {
        gradeBox.getItems().addAll("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "D", "F");
    }

    @FXML
    public void addCourse() {
        try {
            String cname = courseNameField.getText();
            String ccode = courseCodeField.getText();
            double credit = Double.parseDouble(courseCreditField.getText());
            String t1 = teacher1Field.getText();
            String t2 = teacher2Field.getText();
            String grade = gradeBox.getValue();
            if (cname.isEmpty() || ccode.isEmpty() || t1.isEmpty() || t2.isEmpty() || grade == null) {
                showAlert("Fill all fields!");
                return;
            }
            courses.add(new Course(cname, ccode, credit, t1, t2, grade));
            showAlert("Course Added!");
            double sum = courses.stream().mapToDouble(c -> c.credit).sum();
            double totalRequiredCredit = 25;
            if (sum >= totalRequiredCredit) calcBtn.setDisable(false);
            courseNameField.clear();
            courseCodeField.clear();
            courseCreditField.clear();
            teacher1Field.clear();
            teacher2Field.clear();
            gradeBox.getSelectionModel().clearSelection();

        } catch (Exception e) {
            showAlert("Invalid input!");
        }
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void calculateGPA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Result.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
