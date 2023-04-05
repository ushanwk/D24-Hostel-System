package lk.ijse.hibernate.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import lk.ijse.hibernate.d24.util.Navigation;
import lk.ijse.hibernate.d24.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane primaryPane;
    public AnchorPane secondaryPane;
    public Text txtReservation;

    public void initialize(){

    }

    public void btnReservationOnAction(ActionEvent actionEvent) {
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENTFORM, secondaryPane);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) {
    }
}
