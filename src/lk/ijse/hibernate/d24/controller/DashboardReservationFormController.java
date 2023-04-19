package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;
import java.sql.Date;

public class DashboardReservationFormController {
    public JFXTextField txtReservationIdReg;
    public JFXTextField txtFldStudentIdReg;
    public JFXTextField txtFldRoomTypeIdReg;
    public JFXTextField txtFldDateReg;
    public JFXTextField txtFldStudentIdSearch;
    public JFXTextField txtFldRoomTypeIdSearch;
    public TextField txtFldReservationIdSearch;
    public JFXTextField txtFldDateSearch;
    public AnchorPane secondaryPane;
    public JFXComboBox cmbStatusReg;
    public JFXComboBox cmbStatusSearch;
    public Text txtNonAcRooms;
    public Text txtNonAcFoodRooms;
    public Text txtAcRooms;
    public Text txtAcFoodRooms;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        cmbStatusReg.getItems().add("PAY");
        cmbStatusReg.getItems().add("NOT PAY");

        txtReservationIdReg.setText(reservationBO.nextResId());

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

    public void btnRegisterOnAction(ActionEvent actionEvent) {

        try {
            reservationBO.saveReservation(new ReservationDTO(
                    txtReservationIdReg.getText(),
                    Date.valueOf(txtFldDateReg.getText()),
                    txtFldStudentIdReg.getText(),
                    txtFldRoomTypeIdReg.getText(),
                    String.valueOf(cmbStatusReg.getValue())
            ));
            new Alert(Alert.AlertType.CONFIRMATION,"Reservation Placed Successfully").show();
            clearReg();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Invalid Student ID or Room ID").show();
        }

        initialize();

    }

    private void clearReg(){
        txtReservationIdReg.clear();
        txtFldDateReg.clear();
        txtFldStudentIdReg.clear();
        txtFldRoomTypeIdReg.clear();
        cmbStatusReg.setValue("");
    }

    private void clearSearch(){
        txtFldReservationIdSearch.clear();
        txtFldDateSearch.clear();
        txtFldStudentIdSearch.clear();
        txtFldRoomTypeIdSearch.clear();
        cmbStatusSearch.setValue("");
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearReg();
        clearSearch();
    }

    public void txtFldReservationIdOnAction(ActionEvent actionEvent) {

        try {
            ReservationDTO reservationDTO = reservationBO.searchReservation(txtFldReservationIdSearch.getText());

            txtFldReservationIdSearch.setText(reservationDTO.getResID());
            txtFldDateSearch.setText(String.valueOf(reservationDTO.getDate()));
            txtFldStudentIdSearch.setText(reservationDTO.getStudentID());
            txtFldRoomTypeIdSearch.setText(reservationDTO.getRoomTypeID());

            cmbStatusSearch.getItems().add("PAY");
            cmbStatusSearch.getItems().add("NOT PAY");

            if(reservationDTO.getStatus() .equals("PAY")){
                cmbStatusSearch.setValue("PAY");
            }else{
                cmbStatusSearch.setValue("NOT PAY");
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Reservation not Found").show();
            clearSearch();
        }

        initialize();
    }

    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        reservationBO.updateReservation(new ReservationDTO(
                txtFldReservationIdSearch.getText(),
                Date.valueOf(txtFldDateSearch.getText()),
                txtFldStudentIdSearch.getText(),
                txtFldRoomTypeIdSearch.getText(),
                String.valueOf(cmbStatusSearch.getValue())
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Reservation Updated Successfully").show();
        clearSearch();

        initialize();
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        reservationBO.deleteReservation(new ReservationDTO(
                txtFldReservationIdSearch.getText(),
                Date.valueOf(txtFldDateSearch.getText()),
                txtFldStudentIdSearch.getText(),
                txtFldRoomTypeIdSearch.getText(),
                String.valueOf(cmbStatusSearch.getValue())
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Reservation Deleted Successfully").show();
        clearSearch();

        initialize();
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWALLRESERVATIONS, secondaryPane);
    }
}
