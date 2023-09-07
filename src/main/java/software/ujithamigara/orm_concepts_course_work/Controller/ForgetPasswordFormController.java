package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.UserBO;
import software.ujithamigara.orm_concepts_course_work.dto.UserDTO;

import java.io.IOException;

public class ForgetPasswordFormController {

    @FXML
    private JFXTextField conformPasswordTextField;

    @FXML
    private JFXTextField newPasswordTextField;

    @FXML
    private JFXTextField oldPasswordTextField;

    @FXML
    private JFXTextField userNameTextField;
    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.UserBO);
    @FXML
    void resetPasswordOnAction(ActionEvent event) {
        try {
            userBO.updateUser(new UserDTO(userNameTextField.getText(), conformPasswordTextField.getText()));
            new Alert(Alert.AlertType.CONFIRMATION, "Password Updated Successfully ! ").show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Password  Updated  Successfully ! ").show();
            throw new RuntimeException(e);
        }
    }
}
