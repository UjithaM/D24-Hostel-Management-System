package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.ReservationBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;
import software.ujithamigara.orm_concepts_course_work.dto.tm.ReservationTM;
import software.ujithamigara.orm_concepts_course_work.dto.tm.RoomTM;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationFoamController {

    @FXML
    private ToggleGroup PaidStatus;

    @FXML
    private TableColumn<ReservationTM, LocalDate> dobCol;

    @FXML
    private TableColumn<ReservationTM, String> idCol;

    @FXML
    private TableColumn<ReservationTM, String> paidStatusCol;

    @FXML
    private DatePicker reservationDatePicker;

    @FXML
    private JFXTextField reservationIdTextField;

    @FXML
    private TableView<ReservationTM> reservationTable;

    @FXML
    private JFXComboBox<String> roomIdComboBox;

    @FXML
    private TableColumn<ReservationTM, String> roomTypeCol;

    @FXML
    private JFXComboBox<String> studentIdComboBOx;

    @FXML
    private TableColumn<ReservationTM, String> studentNameCol;

    @FXML
    private JFXButton saveButton;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ReservationBO);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.StudentBO);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.RoomBO);

    public void initialize() {
        List<String> studentIds = new ArrayList<>();
        try {
            List<StudentDTO> studentDTOS = studentBO.getAllStudent();
            for (StudentDTO studentDTO:studentDTOS) {
                studentIds.add(studentDTO.getStudentId());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "cannot Get data from Student Table ! ").show();
        }

        studentIdComboBOx.getItems().addAll(studentIds);

        List<String> roomIds = new ArrayList<>();

        try {
            List<RoomDTO> roomDTOS=roomBO.getAllRoom();
            for (RoomDTO roomDTO :roomDTOS) {
                roomIds.add(roomDTO.getRoomId());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "cannot get data from room Table ! ");
        }

        roomIdComboBox.getItems().addAll(roomIds);

        idCol.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        paidStatusCol.setCellValueFactory(new PropertyValueFactory<>("paidStatus"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        refreshTable();
    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            reservationBO.deleteReservation(reservationIdTextField.getText());
            new Alert(Alert.AlertType.CONFIRMATION, "reservation deleted successfully !").show();
            clear();
            refreshTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not deleted !").show();
            e.printStackTrace();
        }
    }

    @FXML
    void saveButtonAction(ActionEvent event) {
        try {
             RadioButton radioButton = (RadioButton) PaidStatus.getSelectedToggle();

             StudentDTO studentDTO = studentBO.searchStudent(studentIdComboBOx.getValue());
             Student student = new Student();
             student.setStudentId(studentDTO.getStudentId());
             student.setStudentName(studentDTO.getStudentName());
             student.setAddress(studentDTO.getAddress());
             student.setContactNumber(studentDTO.getContactNumber());
             student.setDob(studentDTO.getDob());
             student.setGender(studentDTO.getGender());

            RoomDTO roomDTO = roomBO.searchRoom(roomIdComboBox.getValue());
            Room room = new Room();
            room.setRoomId(roomDTO.getRoomId());
            room.setRoomTypeId(roomDTO.getRoomTypeId());
            room.setKeyMoney(roomDTO.getKeyMoney());
            room.setQuantity(roomDTO.getQuantity());

            reservationBO.saveReservation(new ReservationDTO(reservationIdTextField.getText(), reservationDatePicker.getValue(), radioButton.getText(), student, room));
            new Alert(Alert.AlertType.CONFIRMATION, "reservation added successfully ! ").show();
            clear();
            refreshTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not added ! ").show();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        try {
            RadioButton radioButton = (RadioButton) PaidStatus.getSelectedToggle();

            StudentDTO studentDTO = studentBO.searchStudent(studentIdComboBOx.getValue());
            Student student = new Student();
            student.setStudentId(studentDTO.getStudentId());
            student.setStudentName(studentDTO.getStudentName());
            student.setAddress(studentDTO.getAddress());
            student.setContactNumber(studentDTO.getContactNumber());
            student.setDob(studentDTO.getDob());
            student.setGender(studentDTO.getGender());

            RoomDTO roomDTO = roomBO.searchRoom(roomIdComboBox.getValue());
            Room room = new Room();
            room.setRoomId(roomDTO.getRoomId());
            room.setRoomTypeId(roomDTO.getRoomTypeId());
            room.setKeyMoney(roomDTO.getKeyMoney());
            room.setQuantity(roomDTO.getQuantity());

            reservationBO.updateReservation(new ReservationDTO(reservationIdTextField.getText(), reservationDatePicker.getValue(), radioButton.getText(), student, room));
            new Alert(Alert.AlertType.CONFIRMATION, "reservation updated successfully ! ").show();
            clear();
            refreshTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not updated ! ").show();
        }
    }
    void clear(){
        reservationIdTextField.setText("");
        reservationDatePicker.setValue(null);
        roomIdComboBox.setValue("");
        studentIdComboBOx.setValue("");
        PaidStatus.selectToggle(null);
    }
    private void refreshTable() {
        try {
            List<ReservationDTO> all = reservationBO.getAllReservation();
            ObservableList<ReservationTM> studentDtoObservableList = FXCollections.observableArrayList();
            all.forEach(dto -> studentDtoObservableList.add(new ReservationTM(dto.getReservationId(), dto.getStudent().getStudentName(), dto.getRoom().getRoomTypeId(), dto.getStatus(), dto.getDate())));
            reservationTable.setItems(studentDtoObservableList);
        } catch (Exception exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).show();
            reservationTable.getItems().clear();
        }
    }

    public void tblReservationOnMouseClicked(MouseEvent mouseEvent) {
        ReservationTM selectedItem = reservationTable.getSelectionModel().getSelectedItem();
        try {
            if (selectedItem != null) {
                saveButton.setDisable(true);
//                roomIdTextField.setText(selectedItem.getRoomId());
//                roomTypeTextField.setText(selectedItem.getRoomTypeId());
//                keyMoneyTextField.setText(String.valueOf(selectedItem.getKeyMoney()));
//                QuantityTextField.setText(String.valueOf(selectedItem.getQuantity()));
            }
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
