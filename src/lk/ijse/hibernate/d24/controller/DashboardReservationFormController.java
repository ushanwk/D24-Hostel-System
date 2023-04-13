package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.RoomRepositoryImpl;

import java.sql.Date;

public class DashboardReservationFormController {
    public JFXTextField txtReservationIdReg;
    public JFXTextField txtFldStudentIdReg;
    public JFXTextField txtFldStatusReg;
    public JFXTextField txtFldRoomTypeIdReg;
    public JFXTextField txtFldDateReg;
    public JFXTextField txtFldStudentIdSearch;
    public JFXTextField txtFldStatusSearch;
    public JFXTextField txtFldRoomTypeIdSearch;
    public TextField txtFldReservationIdSearch;
    public JFXTextField txtFldDateSearch;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        reservationBO.saveReservation(new ReservationDTO(
                txtReservationIdReg.getText(),
                Date.valueOf(txtFldDateReg.getText()),
                txtFldStudentIdReg.getText(),
                txtFldRoomTypeIdReg.getText(),
                txtFldStatusReg.getText()
        ));
    }

    private void clearReg(){
        txtReservationIdReg.clear();
        txtFldDateReg.clear();
        txtFldStudentIdReg.clear();
        txtFldRoomTypeIdReg.clear();
        txtFldStatusReg.clear();
    }

    private void clearSearch(){
        txtFldReservationIdSearch.clear();
        txtFldDateSearch.clear();
        txtFldStudentIdSearch.clear();
        txtFldRoomTypeIdSearch.clear();
        txtFldStatusSearch.clear();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearReg();
        clearSearch();
    }

    public void txtFldReservationIdOnAction(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = reservationBO.searchReservation(txtFldReservationIdSearch.getText());

        txtFldReservationIdSearch.setText(reservationDTO.getResID());
        txtFldDateSearch.setText(String.valueOf(reservationDTO.getDate()));
        txtFldStudentIdSearch.setText(reservationDTO.getStudentID());
        txtFldRoomTypeIdSearch.setText(reservationDTO.getRoomTypeID());
        txtFldStatusSearch.setText(reservationDTO.getStatus());
    }

    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        reservationBO.updateReservation(new ReservationDTO(
                txtReservationIdReg.getText(),
                Date.valueOf(txtFldDateReg.getText()),
                txtFldStudentIdReg.getText(),
                txtFldRoomTypeIdReg.getText(),
                txtFldStatusReg.getText()
        ));
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        reservationBO.deleteReservation(new ReservationDTO(
                txtReservationIdReg.getText(),
                Date.valueOf(txtFldDateReg.getText()),
                txtFldStudentIdReg.getText(),
                txtFldRoomTypeIdReg.getText(),
                txtFldStatusReg.getText()
        ));
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) {

    }
}
