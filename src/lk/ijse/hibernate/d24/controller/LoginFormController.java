package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class LoginFormController {
    public AnchorPane primaryPane;
    public JFXTextField txtFldUsername;
    public JFXTextField txtFldPassword;

    public void btnSignInOnActiom(ActionEvent actionEvent) {
        if(txtFldUsername.getText() .equals("user") && txtFldPassword.getText() .equals("1234")){
            System.out.println("Done");
        }else{
            System.out.println("Not Done");
        }
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
