package lk.ijse.hibernate.d24.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class UserFormController {
    public Line lineAccountDetails;
    public Line lineUpdateDetails;
    public AnchorPane pane;

    public void initialize(){
        lineAccountDetails.setVisible(true);
        lineUpdateDetails.setVisible(false);
    }

    public void txtAccountDetailsOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        lineAccountDetails.setVisible(true);
        lineUpdateDetails.setVisible(false);
        Navigation.navigate(Routes.USERDETAILS, pane);
    }

    public void txtUpdateDetailsOnMouseClicked(MouseEvent mouseEvent) {
        lineAccountDetails.setVisible(false);
        lineUpdateDetails.setVisible(true);
    }
}
