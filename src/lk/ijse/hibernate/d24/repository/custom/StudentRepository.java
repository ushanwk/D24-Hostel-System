package lk.ijse.hibernate.d24.repository.custom;

import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.CrudRepository;
import lk.ijse.hibernate.d24.repository.SuperRepository;

public interface StudentRepository extends CrudRepository<StudentEntity> {
    public String findNextStudentID();
}
