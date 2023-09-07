package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;

public class ReservationFoamController {
    @FXML
    private ToggleGroup PaidStatus;

    @FXML
    private DatePicker ReservationDatePicker;

    @FXML
    private JFXTextField ReservationIdTextField;

    @FXML
    private JFXComboBox<?> roomIdComboBox;

    @FXML
    private JFXComboBox<?> studentIdComboBOx;

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void saveButtonAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
