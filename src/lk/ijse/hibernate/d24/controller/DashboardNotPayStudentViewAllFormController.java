package lk.ijse.hibernate.d24.controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DashboardNotPayStudentViewAllFormController {
    public TableView tableView;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colGender;
    public TableColumn colDob;
    public TableColumn colTel;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("Tel"));

        try{

            ArrayList<StudentDTO> students = reservationBO.getAllNotPay();

            tableView.setItems(FXCollections.observableArrayList(
                    students.stream().map(studentDTO -> {
                        return new StudentDTO(
                                studentDTO.getStudentID(),
                                studentDTO.getName(),
                                studentDTO.getAddress(),
                                studentDTO.getGender(),
                                studentDTO.getDob(),
                                studentDTO.getTel()
                        );
                    }).collect(Collectors.toList())));

        } catch (Exception e){
            System.out.println(e);
        }

    }
}
