package lk.ijse.hibernate.d24.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane primaryPane;
    public AnchorPane secondaryPane;

    public void initialize(){

    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RESERVATIONFORM, secondaryPane);
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENTFORM, secondaryPane);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOMFORM, secondaryPane);
    }

    public void btnStudentRegOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENTFORM, secondaryPane);
    }

    public void btnUserOnAction(ActionEvent actionEvent) {
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, primaryPane);
    }
}
