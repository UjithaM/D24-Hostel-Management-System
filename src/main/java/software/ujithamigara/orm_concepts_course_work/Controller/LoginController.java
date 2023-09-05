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
    private JFXTextField passwordReviledTextField;

    public void initialize() {
        passwordReviledTextField.setVisible(false);
        passwordReviledTextField.setEditable(false);
    }
    @FXML
    void loginButtonAction(ActionEvent event) {

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
}