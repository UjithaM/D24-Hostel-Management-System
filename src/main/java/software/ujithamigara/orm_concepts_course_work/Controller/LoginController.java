package software.ujithamigara.orm_concepts_course_work.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public class LoginController {
    @FXML
    private CheckBox passwordCheckBox;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField userNameTxtField;

    @FXML
    void loginButtonAction(ActionEvent event) {

    }

    @FXML
    void passwordCheckBoxOnAction(ActionEvent event) {
    }
}