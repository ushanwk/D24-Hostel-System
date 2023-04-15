package lk.ijse.hibernate.d24.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardStudentViewAllFormController {
    public AnchorPane secondaryPane;
    public TableView tableView;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colGender;
    public TableColumn colDob;
    public TableColumn colTel;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("Tel"));

        try{

            ArrayList<StudentDTO> students = studentBO.getAllStudents();

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
