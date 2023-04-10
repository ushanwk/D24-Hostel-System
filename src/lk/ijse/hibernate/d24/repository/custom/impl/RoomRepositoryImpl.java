package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public boolean save(RoomEntity entity) {
        return false;
    }

    @Override
    public boolean update(RoomEntity entity) {
        return false;
    }

    @Override
    public boolean delete(RoomEntity entity) {
        return false;
    }

    @Override
    public RoomEntity search(String id) {
        return null;
    }

    @Override
    public List<RoomEntity> getAll() {
        return null;
    }
}
