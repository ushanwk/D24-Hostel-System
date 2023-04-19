package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.bo.SuperBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.dto.UserDTO;

public interface UserBO extends SuperBO {
    public boolean saveUser(UserDTO userDTO);
    public boolean updateUser(UserDTO userDTO);
    public boolean deleteUser(UserDTO userDTO);
    public UserDTO searchUser(String id);
    public String getPassword(String username);
}
