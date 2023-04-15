package lk.ijse.hibernate.d24.controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.d24.bo.BOFactory;
import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DashboardRoomViewAllFormController {
    public AnchorPane secondaryPane;
    public TableView tableView;
    public TableColumn colRoomTypeId;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public TableColumn colType;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTypeID"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("KeyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));

        try {

            ArrayList<RoomDTO> rooms = roomBO.getAllRooms();

            tableView.setItems(FXCollections.observableArrayList(rooms.stream().map(roomDTO -> {
                return new RoomDTO(
                        roomDTO.getRoomTypeID(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty(),
                        roomDTO.getType()
                );
            }).collect(Collectors.toList())));

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
