package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;
import software.ujithamigara.orm_concepts_course_work.dto.tm.StudentTM;

import java.time.LocalDate;
import java.util.List;

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

    @FXML
    private TableColumn<StudentTM, LocalDate> DOBCol;

    @FXML
    private TableColumn<StudentTM, String> genderCol;

    @FXML
    private TableColumn<StudentTM, String> studentAddressCol;

    @FXML
    private TableColumn<StudentTM, String> studentContactCol;

    @FXML
    private TableColumn<StudentTM, String> studentIdCol;

    @FXML
    private TableColumn<StudentTM, String> studentNameCol;

    @FXML
    private JFXButton saveButton;

    @FXML
    private TableView<StudentTM> studentTable;

    @FXML
    private RadioButton rBtnFemale;

    @FXML
    private RadioButton rBtnMale;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.StudentBO);

    public void initialize() {
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        studentAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        studentContactCol.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        DOBCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        refreshTable();

    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            if(studentBO.deleteStudent(studentIDTextField.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted successfully ! ").show();
                clear();
                refreshTable();
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
                clear();
                refreshTable();
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
                clear();
                refreshTable();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student not Updated ! ").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student not Updated ! ").show();
            e.printStackTrace();
        }
    }
    void clear(){
        studentIDTextField.setText("");
        studentNameTextField.setText("");
        studentAddressTextField.setText("");
        studentContactTextField.setText("");
        dateOfBirthDatePicker.setValue(null);
        GenderRadioButton.selectToggle(null);
    }

    public void tblStudentOnMouseClicked(MouseEvent mouseEvent) {
        StudentTM selectedItem = studentTable.getSelectionModel().getSelectedItem();
        try {
            if (selectedItem != null) {
                saveButton.setDisable(true);
                studentIDTextField.setText(selectedItem.getStudentId());
                studentNameTextField.setText(selectedItem.getStudentName());
                studentAddressTextField.setText(selectedItem.getAddress());
                if (selectedItem.getGender().equals("Male")) {
                    rBtnMale.setSelected(true);
                } else {
                    rBtnFemale.setSelected(true);
                }
                studentContactTextField.setText(selectedItem.getContactNumber());
                dateOfBirthDatePicker.setValue(selectedItem.getDob());
            }
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void refreshTable() {
        try {
            List<StudentDTO> all = studentBO.getAllStudent();
            ObservableList<StudentTM> studentDtoObservableList = FXCollections.observableArrayList();
            all.forEach(dto -> studentDtoObservableList.add(new StudentTM(dto.getStudentId(), dto.getStudentName(), dto.getAddress(), dto.getContactNumber(), dto.getDob(), dto.getGender())));
            studentTable.setItems(studentDtoObservableList);
        } catch (Exception exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).show();
            studentTable.getItems().clear();
        }
    }
}
