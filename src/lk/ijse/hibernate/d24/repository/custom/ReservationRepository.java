package lk.ijse.hibernate.d24.repository.custom;

import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity> {
    public String nextResId();
}
