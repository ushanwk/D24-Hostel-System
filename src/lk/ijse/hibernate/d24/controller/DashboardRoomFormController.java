package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;

public class DashboardRoomFormController {
    public JFXTextField txtFldRoomTypeIdReg;
    public JFXTextField txtFldRoomTypeReg;
    public JFXTextField txtFldQtyReg;
    public JFXTextField txtFldKeyMoneyReg;
    public JFXTextField txtFldTypeSearch;
    public JFXTextField txtFldQtySearch;
    public JFXTextField txtFldSKeyMoneySearch;
    public TextField txtFldRoomTypeIdSearch;

    public void initialize(){
        clearReg();
        clearSearch();
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
        clearReg();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearReg();
        clearSearch();
    }

    public void txtFldRoomTypeIdOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO = roomBO.searchRoom(txtFldRoomTypeIdSearch.getText());

        txtFldRoomTypeIdSearch.setText(roomDTO.getRoomTypeID());
        txtFldTypeSearch.setText(roomDTO.getType());
        txtFldSKeyMoneySearch.setText(roomDTO.getKeyMoney());
        txtFldQtySearch.setText(String.valueOf(roomDTO.getQty()));
    }

    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        roomBO.updateRoom(new RoomDTO(
                txtFldRoomTypeIdSearch.getText(),
                txtFldSKeyMoneySearch.getText(),
                Integer.valueOf(txtFldQtySearch.getText()),
                txtFldRoomTypeIdSearch.getText()
        ));
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        roomBO.deleteRoom(new RoomDTO(
                txtFldRoomTypeIdSearch.getText(),
                txtFldSKeyMoneySearch.getText(),
                Integer.valueOf(txtFldQtySearch.getText()),
                txtFldRoomTypeIdSearch.getText()
        ));
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) {
    }
}
