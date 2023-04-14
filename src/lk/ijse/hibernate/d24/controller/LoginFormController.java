package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane primaryPane;
    public JFXTextField txtFldUsername;
    public JFXTextField txtFldPassword;
    public JFXPasswordField txtPassFldPassword;
    public ImageView imgOpenEye;
    public ImageView imgCloseEye;

    public void initialize(){
        txtFldPassword.setVisible(false);
        imgOpenEye.setVisible(false);
    }

    public void btnSignInOnActiom(ActionEvent actionEvent) throws IOException {
        if(txtFldUsername.getText() .equals("user") && txtPassFldPassword.getText() .equals("1234") || txtFldPassword.getText() .equals("1234")){
            Navigation.navigate(Routes.DASHBOARDFORM, primaryPane);
        }else{
            System.out.println("Not Done");
        }
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void openEyeOnMouseClicked(MouseEvent mouseEvent) {
        imgCloseEye.setVisible(true);
        imgOpenEye.setVisible(false);
        txtFldPassword.setVisible(false);
        txtPassFldPassword.setText(txtFldPassword.getText());
        txtPassFldPassword.setVisible(true);
        txtPassFldPassword.requestFocus();
    }

    public void closeEyeOnMouseClicked(MouseEvent mouseEvent) {
        imgOpenEye.setVisible(true);
        imgCloseEye.setVisible(false);
        txtPassFldPassword.setVisible(false);
        txtFldPassword.setText(txtPassFldPassword.getText());
        txtFldPassword.setVisible(true);
        txtFldPassword.requestFocus();
    }
}
