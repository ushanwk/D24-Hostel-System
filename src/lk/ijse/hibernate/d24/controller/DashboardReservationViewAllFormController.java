package lk.ijse.hibernate.d24.controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DashboardReservationViewAllFormController {
    public AnchorPane secondaryPane;
    public TableView tableView;
    public TableColumn colReservationId;
    public TableColumn colDate;
    public TableColumn colStudentId;
    public TableColumn colRoomTypeId;
    public TableColumn colStatus;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize(){
        colReservationId.setCellValueFactory(new PropertyValueFactory<>("resID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTypeID"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

        try{

            ArrayList<ReservationDTO> allReservations = reservationBO.getAllReservations();

            tableView.setItems(FXCollections.observableArrayList(allReservations.stream().map(reservationDTO -> {
                return new ReservationDTO(
                        reservationDTO.getResID(),
                        reservationDTO.getDate(),
                        reservationDTO.getStudentID(),
                        reservationDTO.getRoomTypeID(),
                        reservationDTO.getStatus()
                );
            }).collect(Collectors.toList())));

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
