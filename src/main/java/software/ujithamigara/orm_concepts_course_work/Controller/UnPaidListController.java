package software.ujithamigara.orm_concepts_course_work.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.ReservationBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.StudentBO;
import software.ujithamigara.orm_concepts_course_work.dto.ReservationDTO;
import software.ujithamigara.orm_concepts_course_work.dto.tm.ReservationTM;
import software.ujithamigara.orm_concepts_course_work.dto.tm.UnpaidTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UnPaidListController {

    @FXML
    private TableColumn<UnpaidTM, Double> kryMoneyCol;

    @FXML
    private TableColumn<UnpaidTM, Double> roomIdCol;

    @FXML
    private TableColumn<UnpaidTM, String> roomTypeCol;

    @FXML
    private TableColumn<UnpaidTM, String> studentIdCol;

    @FXML
    private TableColumn<UnpaidTM, String> studentNameCol;

    @FXML
    private TableView<UnpaidTM> unPaidTable;
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ReservationBO);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.StudentBO);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.RoomBO);
    public void initialize() {
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        roomIdCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        kryMoneyCol.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));


        try {
            List<ReservationDTO> reservationDTOS = reservationBO.findAllUnpaidReservations();
            ObservableList<UnpaidTM> studentDtoObservableList = FXCollections.observableArrayList();
            reservationDTOS.forEach(dto -> studentDtoObservableList.add(new UnpaidTM(dto.getStudent().getStudentId(), dto.getStudent().getStudentName(), dto.getRoom().getRoomId(), dto.getRoom().getRoomTypeId(), dto.getRoom().getKeyMoney())));
            unPaidTable.setItems(studentDtoObservableList);
        } catch (Exception exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).show();
            unPaidTable.getItems().clear();
        }
    }
}
