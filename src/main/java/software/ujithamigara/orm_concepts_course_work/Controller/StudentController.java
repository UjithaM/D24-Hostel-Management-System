package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

public class StudentController {

    @FXML
    private ToggleGroup GenderRadioButton;

    @FXML
    private DatePicker dateOfBirthDatePicker;

    @FXML
    private JFXTextField studentAddressTextField;

    @FXML
    private JFXTextField studentContactTextField;

    @FXML
    private JFXTextField studentIDTextField;

    @FXML
    private JFXTextField studentNameTextField;
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.StudentBO);
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            if(studentBO.deleteStudent(studentIDTextField.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted successfully ! ").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student Not deleted ! ").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student Not deleted ! ").show();
            e.printStackTrace();
        }
    }

    @FXML
    void saveButtonAction(ActionEvent event) {
        try {
            RadioButton selectedRadioButton = (RadioButton) GenderRadioButton.getSelectedToggle();
            if(studentBO.saveStudent(new StudentDTO(studentIDTextField.getText(), studentNameTextField.getText(),
                    studentAddressTextField.getText(), studentContactTextField.getText(),
                    dateOfBirthDatePicker.getValue(), selectedRadioButton.getText()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved successfully ! ").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student not saved ! ").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student not saved ! ").show();
            e.printStackTrace();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        try {
            RadioButton selectedRadioButton = (RadioButton) GenderRadioButton.getSelectedToggle();
            if(studentBO.updateStudent(new StudentDTO(studentIDTextField.getText(), studentNameTextField.getText(),
                    studentAddressTextField.getText(), studentContactTextField.getText(),
                    dateOfBirthDatePicker.getValue(), selectedRadioButton.getText()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Update successfully ! ").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student not Updated ! ").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student not Updated ! ").show();
            e.printStackTrace();
        }
    }

}
