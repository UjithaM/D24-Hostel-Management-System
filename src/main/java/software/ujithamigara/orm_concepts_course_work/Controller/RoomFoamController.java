package software.ujithamigara.orm_concepts_course_work.Controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import software.ujithamigara.orm_concepts_course_work.bo.BOFactory;
import software.ujithamigara.orm_concepts_course_work.bo.custrom.RoomBO;
import software.ujithamigara.orm_concepts_course_work.dto.RoomDTO;
import software.ujithamigara.orm_concepts_course_work.dto.tm.RoomTM;

import java.util.List;

public class RoomFoamController {

    @FXML
    private JFXTextField QuantityTextField;

    @FXML
    private TableColumn<RoomTM, Double> keyMoneyCol;

    @FXML
    private JFXTextField keyMoneyTextField;

    @FXML
    private TableColumn<RoomTM, Integer> qtyCol;

    @FXML
    private TableColumn<RoomTM, String> roomIdCol;

    @FXML
    private JFXTextField roomIdTextField;

    @FXML
    private TableView<RoomTM> roomTable;

    @FXML
    private JFXTextField roomTypeTextField;

    @FXML
    private TableColumn<RoomTM, String> typeCol;

    @FXML
    private JFXButton saveButton;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.RoomBO);

    public void initialize() {
        roomIdCol.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        keyMoneyCol.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        refreshTable();
    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            roomBO.deleteRoom(new RoomDTO(roomIdTextField.getText(), roomTypeTextField.getText(), Double.valueOf(keyMoneyTextField.getText()), Integer.valueOf(QuantityTextField.getText())));
            new Alert(Alert.AlertType.CONFIRMATION, "Room deleted successfully !").show();
            clearTextField();
            refreshTable();
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
            refreshTable();
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
            refreshTable();
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
    private void refreshTable() {
        try {
            List<RoomDTO> all = roomBO.getAllRoom();
            ObservableList<RoomTM> studentDtoObservableList = FXCollections.observableArrayList();
            all.forEach(dto -> studentDtoObservableList.add(new RoomTM(dto.getRoomId(), dto.getRoomTypeId(), dto.getKeyMoney(), dto.getQuantity())));
            roomTable.setItems(studentDtoObservableList);
        } catch (Exception exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).show();
            roomTable.getItems().clear();
        }
    }

    public void tblRoomOnMouseClicked(MouseEvent mouseEvent) {
        RoomTM selectedItem = roomTable.getSelectionModel().getSelectedItem();
        try {
            if (selectedItem != null) {
                saveButton.setDisable(true);
                roomIdTextField.setText(selectedItem.getRoomId());
                roomTypeTextField.setText(selectedItem.getRoomTypeId());
                keyMoneyTextField.setText(String.valueOf(selectedItem.getKeyMoney()));
                QuantityTextField.setText(String.valueOf(selectedItem.getQuantity()));
            }
        } catch (RuntimeException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
