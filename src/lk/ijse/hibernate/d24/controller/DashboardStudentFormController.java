package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;

import java.sql.Date;

public class DashboardStudentFormController {
    public JFXTextField txtFldStudentIdReg;
    public JFXTextField txtFldNameReg;
    public JFXTextField txtFldAddressReg;
    public JFXTextField txtFldDobReg;
    public JFXTextField txtFldGenderReg;
    public JFXTextField txtFldTelReg;
    public JFXTextField txtFldNameSearch;
    public JFXTextField txtFldAddressSearch;
    public JFXTextField txtFldSDobSearch;
    public JFXTextField txtFldGenderSearch;
    public TextField txtFldStdentIdSearch;
    public JFXTextField txtFldTelSearch;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        clear();
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        studentBO.saveStudent(new StudentDTO(
                txtFldStudentIdReg.getText(),
                txtFldNameReg.getText(),
                txtFldAddressReg.getText(),
                txtFldGenderReg.getText(),
                Date.valueOf(txtFldDobReg.getText()),
                txtFldTelReg.getText()

        ));

        clear();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clear();
    }

    private void clear(){
        txtFldStudentIdReg.clear();
        txtFldNameReg.clear();
        txtFldAddressReg.clear();
        txtFldDobReg.clear();
        txtFldGenderReg.clear();
        txtFldTelReg.clear();
    }

    public void btnUpdateOnAcion(ActionEvent actionEvent) {
        studentBO.updateStudent(new StudentDTO(
                txtFldStdentIdSearch.getText(),
                txtFldNameSearch.getText(),
                txtFldAddressReg.getText(),
                txtFldGenderSearch.getText(),
                Date.valueOf(txtFldSDobSearch.getText()),
                txtFldTelSearch.getText()
        ));
        clear();
    }

    public void btnDeleteOnAcion(ActionEvent actionEvent) {
        studentBO.deleteStudent(new StudentDTO(
                txtFldStdentIdSearch.getText(),
                txtFldNameSearch.getText(),
                txtFldAddressReg.getText(),
                txtFldGenderSearch.getText(),
                Date.valueOf(txtFldSDobSearch.getText()),
                txtFldTelSearch.getText()

        ));
        clear();
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) {
    }

    public void txtFldSearchIdOnAction(ActionEvent actionEvent) {

        try {
            StudentDTO studentDTO = studentBO.searchStudent(txtFldStdentIdSearch.getText());

            txtFldSDobSearch.setText(String.valueOf(studentDTO.getDob()));
            txtFldTelSearch.setText(studentDTO.getTel());
            txtFldAddressSearch.setText(studentDTO.getAddress());
            txtFldGenderSearch.setText(studentDTO.getGender());
            txtFldNameSearch.setText(studentDTO.getName());
            txtFldStdentIdSearch.setText(studentDTO.getStudentID());

        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING).show();
        }

    }
}
