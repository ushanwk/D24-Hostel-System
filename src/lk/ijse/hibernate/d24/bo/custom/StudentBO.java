package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.bo.SuperBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO);
    public boolean updateStudent(StudentDTO studentDTO);
    public boolean deleteStudent(StudentDTO studentDTO);
}
