package lk.ijse.hibernate.d24.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                initUI("LoginForm.fxml");
                window.setTitle("");
                break;

            case DASHBOARDFORM:
                initUI("DashboardForm.fxml");
                window.setTitle("");
                break;

            case STUDENTFORM:
                initUI("DashboardStudentForm.fxml");
                window.setTitle("");
                break;

            case ROOMFORM:
                initUI("DashboardRoomForm.fxml");
                window.setTitle("");
                break;

            case RESERVATIONFORM:
                initUI("DashboardReservationForm.fxml");
                window.setTitle("");
                break;

            case VIEWALLSTUDENTS:
                initUI("DashboardStudentViewAllForm.fxml");
                window.setTitle("");
                break;

            case VIEWALLROOMS:
                initUI("DashboardRoomViewAllForm.fxml");
                window.setTitle("");
                break;

            case VIEWALLRESERVATIONS:
                initUI("DashboardReservationViewAllForm.fxml");
                window.setTitle("");
                break;

            case USER:
                initUI("UserForm.fxml");
                window.setTitle("");
                break;

            case USERDETAILS:
                initUI("UserAccountDetailsForm.fxml");
                window.setTitle("");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hibernate//d24/view/" + location)));
    }
}
