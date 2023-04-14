package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.bo.SuperBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    public boolean saveRoom(RoomDTO roomDTO);
    public boolean updateRoom(RoomDTO roomDTO);
    public boolean deleteRoom(RoomDTO roomDTO);
    public RoomDTO searchRoom(String id);
    public int getRoomCount(String id);
    public List<RoomDTO> getAllRooms();
}
