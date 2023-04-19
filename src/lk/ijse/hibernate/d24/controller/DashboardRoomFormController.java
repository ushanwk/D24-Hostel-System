package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class DashboardRoomFormController {
    public JFXTextField txtFldRoomTypeIdReg;
    public JFXTextField txtFldRoomTypeReg;
    public JFXTextField txtFldQtyReg;
    public JFXTextField txtFldKeyMoneyReg;
    public JFXTextField txtFldTypeSearch;
    public JFXTextField txtFldQtySearch;
    public JFXTextField txtFldSKeyMoneySearch;
    public TextField txtFldRoomTypeIdSearch;
    public AnchorPane secondaryPane;
    public Text txtNonAcRooms;
    public Text txtNonAcFoodRooms;
    public Text txtAcRooms;
    public Text txtAcFoodRooms;

    public void initialize(){
        clearReg();
        clearSearch();

        txtFldRoomTypeIdReg.setText(roomBO.nextRoomId());

        try {
            txtAcRooms.setText(String.valueOf(roomBO.getRoomCount("RM-7896")));
        }catch (Exception e){
            txtAcRooms.setText("0");
        }

        try {
            txtAcFoodRooms.setText(String.valueOf(roomBO.getRoomCount("RM-0093")));
        }catch (Exception e){
            txtAcFoodRooms.setText("0");
        }

        try {
            txtNonAcRooms.setText(String.valueOf(roomBO.getRoomCount("RM-1324")));
        }catch (Exception e){
            txtNonAcRooms.setText("0");
        }

        try {
            txtNonAcFoodRooms.setText(String.valueOf(roomBO.getRoomCount("RM-5467")));
        }catch (Exception e){
            txtNonAcFoodRooms.setText("0");
        }

    }

    private void clearReg(){
        txtFldKeyMoneyReg.clear();
        txtFldQtyReg.clear();
        txtFldRoomTypeIdReg.clear();
        txtFldRoomTypeReg.clear();
    }

    private void clearSearch(){
        txtFldQtySearch.clear();
        txtFldTypeSearch.clear();
        txtFldRoomTypeIdSearch.clear();
        txtFldSKeyMoneySearch.clear();
    }

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        roomBO.saveRoom(new RoomDTO(
                txtFldRoomTypeIdReg.getText(),
                txtFldKeyMoneyReg.getText(),
                Integer.valueOf(txtFldQtyReg.getText()),
                txtFldRoomTypeReg.getText()
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Room Added Successfully").show();
        clearReg();

        initialize();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearReg();
        clearSearch();
    }

    public void txtFldRoomTypeIdOnAction(ActionEvent actionEvent) {

        try {
            RoomDTO roomDTO = roomBO.searchRoom(txtFldRoomTypeIdSearch.getText());

            txtFldRoomTypeIdSearch.setText(roomDTO.getRoomTypeID());
            txtFldTypeSearch.setText(roomDTO.getType());
            txtFldSKeyMoneySearch.setText(roomDTO.getKeyMoney());
            txtFldQtySearch.setText(String.valueOf(roomDTO.getQty()));

        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Room not Found").show();
            clearSearch();
        }


    }

    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        roomBO.updateRoom(new RoomDTO(
                txtFldRoomTypeIdSearch.getText(),
                txtFldSKeyMoneySearch.getText(),
                Integer.valueOf(txtFldQtySearch.getText()),
                txtFldRoomTypeIdSearch.getText()
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Room Updated Successfully").show();
        clearSearch();

        initialize();
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        roomBO.deleteRoom(new RoomDTO(
                txtFldRoomTypeIdSearch.getText(),
                txtFldSKeyMoneySearch.getText(),
                Integer.valueOf(txtFldQtySearch.getText()),
                txtFldRoomTypeIdSearch.getText()
        ));
        new Alert(Alert.AlertType.CONFIRMATION,"Room Deleted Successfully").show();
        clearSearch();

        initialize();
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWALLROOMS, secondaryPane);
    }
}
