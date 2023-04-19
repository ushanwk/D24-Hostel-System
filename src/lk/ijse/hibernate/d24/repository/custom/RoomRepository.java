package lk.ijse.hibernate.d24.repository.custom;

import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity> {
    public int getRoomCount(String id);
    public String findNextRoomID();
}
