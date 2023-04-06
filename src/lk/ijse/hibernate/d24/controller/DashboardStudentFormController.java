package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
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

    }

    private void clear(){
        txtFldStudentIdReg.clear();
        txtFldNameReg.clear();
        txtFldAddressReg.clear();
        txtFldDobReg.clear();
        txtFldGenderReg.clear();
    }
}
