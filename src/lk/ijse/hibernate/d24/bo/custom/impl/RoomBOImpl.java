package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.RoomRepositoryImpl;

import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {

    RoomRepositoryImpl roomRepository = (RoomRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOM);
    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return roomRepository.save(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return roomRepository.update(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        return roomRepository.delete(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public RoomDTO searchRoom(String id) {
        RoomEntity room = roomRepository.search(id);

        return new RoomDTO(
                room.getRoomTypeId(),
                room.getKeyMoney(),
                room.getQty(),
                room.getType()
        );
    }
}
