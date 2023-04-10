package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.bo.SuperBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;

public interface RoomBO extends SuperBO {
    public boolean saveRoom(RoomDTO roomDTO);
    public boolean updateRoom(RoomDTO roomDTO);
    public boolean deleteRoom(RoomDTO roomDTO);
    public RoomDTO searchRoom(String id);
}
