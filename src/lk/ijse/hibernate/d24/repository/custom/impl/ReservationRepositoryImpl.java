package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.repository.custom.ReservationRepository;

import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public boolean save(ReservationEntity entity) {
        return false;
    }

    @Override
    public boolean update(ReservationEntity entity) {
        return false;
    }

    @Override
    public boolean delete(ReservationEntity entity) {
        return false;
    }

    @Override
    public ReservationEntity search(String id) {
        return null;
    }

    @Override
    public List<ReservationEntity> getAll() {
        return null;
    }
}
