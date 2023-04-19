package lk.ijse.hibernate.d24.repository.custom;

import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<ReservationEntity> {
    public String nextResId();
    public List<StudentEntity> getAllNotPay();
}
