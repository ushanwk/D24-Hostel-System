package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;
import lk.ijse.hibernate.d24.util.Validation;

import java.io.IOException;
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
    public AnchorPane secondaryPane;
    public Text txtInvalidTelError;
    public Text txtInvalidDateError;
    public Text txtInvalidNameError;


    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        clearSearch();clearReg();
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        txtInvalidDateError.setVisible(false);
        txtInvalidNameError.setVisible(false);
        txtInvalidTelError.setVisible(false);

        txtFldStudentIdReg.setText(studentBO.nextStudentId());
    }

    boolean isAfter = true;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws InterruptedException {

        boolean isSuccess = false;

        if(Validation.validateLettersOnly(txtFldNameReg.getText())){
            isSuccess = true;
        }else{
            isSuccess = false;
            isAfter = false;
            txtInvalidNameError.setVisible(true);
        }

        if(Validation.validateDateOnly(txtFldDobReg.getText())){
            isSuccess = true;
        }else{
            isSuccess = false;
            isAfter = false;
            txtInvalidDateError.setVisible(true);
        }

        if(Validation.validateNumbersOnly(txtFldTelReg.getText())){
            isSuccess = true;
        }else{
            isSuccess = false;
            isAfter = false;
            txtInvalidTelError.setVisible(true);
        }


        if(isSuccess){
            studentBO.saveStudent(new StudentDTO(
                    txtFldStudentIdReg.getText(),
                    txtFldNameReg.getText(),
                    txtFldAddressReg.getText(),
                    String.valueOf(cmbGender.getValue()),
                    Date.valueOf(txtFldDobReg.getText()),
                    txtFldTelReg.getText()
            ));

            new Alert(Alert.AlertType.CONFIRMATION,"Student Registered Successfully").show();

            initialize();
        }

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
        cmbGender.setValue("");
    }

    private void clearSearch(){
        txtFldStdentIdSearch.clear();
        txtFldNameSearch.clear();
        txtFldAddressSearch.clear();
        txtFldSDobSearch.clear();
        txtFldTelSearch.clear();
        cmbGenderSearch.setValue("");
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

        initialize();
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
        initialize();
    }

    public void btnViewAllOnAcion(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEWALLSTUDENTS, secondaryPane);
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

    public void txtGenderOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }

    public void txtStIdOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }

    public void txtNameOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }

    public void txtAddressOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }

    public void txtDobOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }

    public void txtTelOnMouseClicked(MouseEvent mouseEvent) {
        if(!isAfter){ initialize();isAfter=true;}
    }
}
