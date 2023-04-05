package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane primaryPane;
    public JFXTextField txtFldUsername;
    public JFXTextField txtFldPassword;

    public void btnSignInOnActiom(ActionEvent actionEvent) throws IOException {
        if(txtFldUsername.getText() .equals("user") && txtFldPassword.getText() .equals("1234")){
            Navigation.navigate(Routes.DASHBOARDFORM, primaryPane);
        }else{
            System.out.println("Not Done");
        }
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
