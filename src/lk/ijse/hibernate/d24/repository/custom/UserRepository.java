package lk.ijse.hibernate.d24.repository.custom;

import lk.ijse.hibernate.d24.entity.UserEntity;
import lk.ijse.hibernate.d24.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity> {
    public String getPassword(String username);
}
