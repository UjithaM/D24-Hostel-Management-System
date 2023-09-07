package software.ujithamigara.orm_concepts_course_work.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.UserBO;
import software.ujithamigara.orm_concepts_course_work.dto.UserDTO;

import java.io.IOException;

public class LoginController {
    @FXML
    private CheckBox passwordCheckBox;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField userNameTxtField;
    @FXML
    private JFXTextField passwordReviledTextField;
    @FXML
    private AnchorPane root;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.UserBO);
    public void initialize() {
        passwordReviledTextField.setVisible(false);
        passwordReviledTextField.setEditable(false);
        //create
        try {
            if (userBO.searchUser(new UserDTO("admin", "admin")) == null){
                userBO.saveUser(new UserDTO("admin", "admin"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void loginButtonAction(ActionEvent event){
        try {
            if (userBO.searchUser(new UserDTO(userNameTxtField.getText(), passwordField.getText())) != null){
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/software/ujithamigara/orm_concepts_course_work/view/Dashboard.fxml"));
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(new Scene(anchorPane));
                stage.setTitle("D24 Hostel Management System - Dashboard");
                stage.centerOnScreen();
                stage.show();
            }else {
                new Alert(Alert.AlertType.ERROR, "incorrect Password or User Name !").show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void passwordCheckBoxOnAction(ActionEvent event) {
        if (passwordCheckBox.isSelected()) {
            passwordField.setVisible(false);
            passwordReviledTextField.setVisible(true);
            passwordReviledTextField.setText(passwordField.getText());
        }else {
            passwordField.setVisible(true);
            passwordReviledTextField.setVisible(false);
            passwordReviledTextField.setText("");
        }
    }

    public void signUpBtnOnAction(ActionEvent actionEvent) {

    }
}