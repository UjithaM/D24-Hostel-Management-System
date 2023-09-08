package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.ReservationBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dao.DAOFactory;
import software.ujithamigara.orm_concepts_course_work.dao.custom.ReservationDAO;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.StudentDTO;
import software.ujithamigara.orm_concepts_course_work.entity.Room;
import software.ujithamigara.orm_concepts_course_work.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservationFoamController {
    @FXML
    private ToggleGroup PaidStatus;

    @FXML
    private DatePicker reservationDatePicker;

    @FXML
    private JFXTextField reservationIdTextField;

    @FXML
    private JFXComboBox<String> roomIdComboBox;

    @FXML
    private JFXComboBox<String> studentIdComboBOx;

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


    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            reservationBO.deleteReservation(reservationIdTextField.getText());
            new Alert(Alert.AlertType.CONFIRMATION, "reservation deleted successfully !").show();
            clear();
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
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "reservation not updated ! ").show();
        }
    }
    void clear(){
        reservationIdTextField.setText("");
        reservationDatePicker.setValue(null);
        roomIdComboBox.setValue("");
        studentIdComboBOx.setValue("");
    }
}
