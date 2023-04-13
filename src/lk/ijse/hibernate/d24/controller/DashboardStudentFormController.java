package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;

import java.sql.Date;

public class DashboardStudentFormController {
    public JFXTextField txtFldStudentIdReg;
    public JFXTextField txtFldNameReg;
    public JFXTextField txtFldAddressReg;
    public JFXTextField txtFldDobReg;
    public JFXTextField txtFldTelReg;
    public JFXTextField txtFldNameSearch;
    public JFXTextField txtFldAddressSearch;
    public JFXTextField txtFldSDobSearch;
    public TextField txtFldStdentIdSearch;
    public JFXTextField txtFldTelSearch;
    public JFXComboBox cmbGender;
    public JFXComboBox cmbGenderSearch;


    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        clearSearch();clearReg();
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        studentBO.saveStudent(new StudentDTO(
                txtFldStudentIdReg.getText(),
                txtFldNameReg.getText(),
                txtFldAddressReg.getText(),
                String.valueOf(cmbGender.getValue()),
                Date.valueOf(txtFldDobReg.getText()),
                txtFldTelReg.getText()

        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Student Registered Successfully").show();

        clearReg();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearSearch();
        clearReg();
    }

    private void clearReg(){
        txtFldStudentIdReg.clear();
        txtFldNameReg.clear();
        txtFldAddressReg.clear();
        txtFldDobReg.clear();
        txtFldTelReg.clear();
    }

    private void clearSearch(){
        txtFldStdentIdSearch.clear();
        txtFldNameSearch.clear();
        txtFldAddressSearch.clear();
        txtFldSDobSearch.clear();
        txtFldTelSearch.clear();
    }


    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        studentBO.updateStudent(new StudentDTO(
                txtFldStdentIdSearch.getText(),
                txtFldNameSearch.getText(),
                txtFldAddressSearch.getText(),
                String.valueOf(cmbGenderSearch.getValue()),
                Date.valueOf(txtFldSDobSearch.getText()),
                txtFldTelSearch.getText()
        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Student Updated Successfully").show();

        clearSearch();
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        studentBO.deleteStudent(new StudentDTO(
                txtFldStdentIdSearch.getText(),
                txtFldNameSearch.getText(),
                txtFldAddressSearch.getText(),
                String.valueOf(cmbGenderSearch.getValue()),
                Date.valueOf(txtFldSDobSearch.getText()),
                txtFldTelSearch.getText()

        ));

        new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted Successfully").show();
        clearSearch();
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) {
    }

    public void txtFldSearchIdOnAction(ActionEvent actionEvent) {

        try {
            StudentDTO studentDTO = studentBO.searchStudent(txtFldStdentIdSearch.getText());

            txtFldSDobSearch.setText(String.valueOf(studentDTO.getDob()));
            txtFldTelSearch.setText(studentDTO.getTel());
            txtFldAddressSearch.setText(studentDTO.getAddress());
            txtFldNameSearch.setText(studentDTO.getName());
            txtFldStdentIdSearch.setText(studentDTO.getStudentID());

            cmbGenderSearch.getItems().add("Male");
            cmbGenderSearch.getItems().add("Female");

            if(studentDTO.getGender() .equals("Male")){
                cmbGenderSearch.setValue("Male");
            }else{
                cmbGenderSearch.setValue("Female");
            }


        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Student ID not Found").show();
            clearSearch();
        }

    }
}
