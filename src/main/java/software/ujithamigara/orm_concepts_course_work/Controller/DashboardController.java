package software.ujithamigara.orm_concepts_course_work.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Label adminNameLabel;

    @FXML
    private Label availableRoomLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label reserveRoomLabel;

    @FXML
    private AnchorPane root;

    @FXML
    private Label totalRoomCountLabl;

    @FXML
    void dashboardButtonOnAction(ActionEvent event) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/software/ujithamigara/orm_concepts_course_work/view/Dashboard.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(anchorPane));
            stage.setTitle("D24 Hostel Management System - Dashboard");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reservationButtonOnAction(ActionEvent event) {

    }

    @FXML
    void roomButtonOnAction(ActionEvent event)  {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/software/ujithamigara/orm_concepts_course_work/view/RoomFoam.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
            stage.setTitle("D24 Hostel Management System - Room");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signOutButtonOnAction(ActionEvent event) {

    }

    @FXML
    void studentButtonOnAction(ActionEvent event) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/software/ujithamigara/orm_concepts_course_work/view/Student.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
            stage.setTitle("D24 Hostel Management System - Student");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
