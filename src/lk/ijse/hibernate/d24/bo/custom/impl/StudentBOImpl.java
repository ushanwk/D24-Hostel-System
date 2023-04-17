package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.StudentBO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.StudentRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentBOImpl implements StudentBO {

    StudentRepository studentRepository = (StudentRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        return studentRepository.save(new StudentEntity(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getTel(),
                studentDTO.getDob(),
                studentDTO.getGender(),
                new ArrayList<>()));

    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        return studentRepository.update(new StudentEntity(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getTel(),
                studentDTO.getDob(),
                studentDTO.getGender(),
                new ArrayList<>()));
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) {
        return studentRepository.delete(new StudentEntity(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getTel(),
                studentDTO.getDob(),
                studentDTO.getGender(),
                new ArrayList<>()));
    }

    @Override
    public StudentDTO searchStudent(String id) {
        StudentEntity student = studentRepository.search(id);
        return new StudentDTO(
                student.getStudentId(),
                student.getName(),
                student.getAddress(),
                student.getGender(),
                student.getDOB(),
                student.getTel()
        );
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<StudentDTO> studentList = new ArrayList<>();

        studentList.addAll(studentRepository.getAll().stream().map(studentEntity -> {
            return new StudentDTO(
                    studentEntity.getStudentId(),
                    studentEntity.getName(),
                    studentEntity.getAddress(),
                    studentEntity.getGender(),
                    studentEntity.getDOB(),
                    studentEntity.getTel()
            );
        }).collect(Collectors.toList()));

        return studentList;
    }

    @Override
    public String nextStudentId() {
        return studentRepository.findNextStudentID();
    }


}
