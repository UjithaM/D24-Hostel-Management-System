package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;

public class RoomFoamController {

    @FXML
    private JFXTextField QuantityTextField;

    @FXML
    private JFXTextField keyMoneyTextField;

    @FXML
    private JFXTextField roomIdTextField;
    @FXML
    private JFXTextField roomTypeTextField;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.RoomBO);
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            roomBO.deleteRoom(new RoomDTO(roomIdTextField.getText(), roomTypeTextField.getText(), Double.valueOf(keyMoneyTextField.getText()), Integer.valueOf(QuantityTextField.getText())));
            new Alert(Alert.AlertType.CONFIRMATION, "Room deleted successfully !").show();
            clearTextField();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Room not deleted ! ").show();
            e.printStackTrace();
        }
    }

    @FXML
    void saveButtonAction(ActionEvent event) {
        try {
            roomBO.saveRoom(new RoomDTO(roomIdTextField.getText(), roomTypeTextField.getText(), Double.valueOf(keyMoneyTextField.getText()), Integer.valueOf(QuantityTextField.getText())));
            new Alert(Alert.AlertType.CONFIRMATION, "Room saved successfully ! ").show();
            clearTextField();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Room not saved ! ").show();
            e.printStackTrace();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        try {
            roomBO.updateRoom(new RoomDTO(roomIdTextField.getText(), roomTypeTextField.getText(), Double.valueOf(keyMoneyTextField.getText()), Integer.valueOf(QuantityTextField.getText())));
            new Alert(Alert.AlertType.CONFIRMATION, "Room updated successfully ! ").show();
            clearTextField();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Room Not Updated ! ").show();
            e.printStackTrace();
        }
    }

    void clearTextField(){
        roomIdTextField.setText("");
        roomTypeTextField.setText("");
        keyMoneyTextField.setText("");
        QuantityTextField.setText("");
    }
}
