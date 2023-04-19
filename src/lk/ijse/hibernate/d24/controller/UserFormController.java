package lk.ijse.hibernate.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.UserBO;
import lk.ijse.hibernate.d24.dto.UserDTO;
import lk.ijse.hibernate.d24.entity.UserEntity;
import lk.ijse.hibernate.d24.repository.custom.UserRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.UserRepostoryImpl;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class UserFormController {
    public AnchorPane pane;
    public Text txtName;
    public Text txtUsername;
    public Text txtPassword;
    public Text txtTel;
    public TextField txtNewUsername;
    public TextField txtNewPassword;
    public TextField txtConfirmPassword;
    public TextField txtCurrentUsername;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        UserDTO user = userBO.searchUser(LoginFormController.username);

        txtName.setText(user.getName());
        txtUsername.setText(user.getUserName());
        txtPassword.setText(user.getPassword());
        txtTel.setText(user.getTel());
    }

    public void btnSaveChangesOnAction(ActionEvent actionEvent) {
        if(txtUsername.getText() .equals(txtCurrentUsername.getText())){
            if(txtNewPassword.getText() .equals(txtConfirmPassword.getText())){
                userBO.updateUser(new UserDTO(txtCurrentUsername.getText(), txtConfirmPassword.getText(), txtName.getText(), txtTel.getText()));
                new Alert(Alert.AlertType.CONFIRMATION,"Username and Password Updated Successfully").show();
                initialize();
            }else{
                new Alert(Alert.AlertType.WARNING,"Passwords are not match").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Invalid Username").show();
        }
    }
}
