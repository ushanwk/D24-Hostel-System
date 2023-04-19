package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.dto.StudentDTO;
import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.ReservationRepository;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.repository.custom.StudentRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {
    StudentRepository studentRepository = (StudentRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.STUDENT);
    RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOM);
    ReservationRepository reservationRepository = (ReservationRepository) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.RESERVATION);
    @Override
    public boolean saveReservation(ReservationDTO reservationDTO) {
        StudentEntity student = studentRepository.search(reservationDTO.getStudentID());
        RoomEntity room = roomRepository.search(reservationDTO.getRoomTypeID());

        reservationRepository.save(new ReservationEntity(
                reservationDTO.getResID(),
                reservationDTO.getDate(),
                student,
                room,
                reservationDTO.getStatus()
        ));

        int qty = roomRepository.getRoomCount(reservationDTO.getRoomTypeID());

        room.setQty(qty-1);

        roomRepository.update(room);

        return true;
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {
        StudentEntity student = studentRepository.search(reservationDTO.getStudentID());
        RoomEntity room = roomRepository.search(reservationDTO.getRoomTypeID());

        reservationRepository.update(new ReservationEntity(
                reservationDTO.getResID(),
                reservationDTO.getDate(),
                student,
                room,
                reservationDTO.getStatus()
        ));

        return true;
    }

    @Override
    public boolean deleteReservation(ReservationDTO reservationDTO) {
        StudentEntity student = studentRepository.search(reservationDTO.getStudentID());
        RoomEntity room = roomRepository.search(reservationDTO.getRoomTypeID());

        reservationRepository.delete(new ReservationEntity(
                reservationDTO.getResID(),
                reservationDTO.getDate(),
                student,
                room,
                reservationDTO.getStatus()
        ));

        int qty = roomRepository.getRoomCount(reservationDTO.getRoomTypeID());

        room.setQty(qty+1);

        roomRepository.update(room);

        return true;
    }

    @Override
    public ReservationDTO searchReservation(String id) {
        ReservationEntity reservationEntity = reservationRepository.search(id);

        return new ReservationDTO(
                reservationEntity.getResId(),
                reservationEntity.getDate(),
                reservationEntity.getStudent().getStudentId(),
                reservationEntity.getRoom().getRoomTypeId(),
                reservationEntity.getStatus()
        );
    }

    @Override
    public ArrayList<ReservationDTO> getAllReservations() {
        ArrayList<ReservationDTO> allRes = new ArrayList<>();

        allRes.addAll(reservationRepository.getAll().stream().map(reservationEntity -> {
            return new ReservationDTO(
                    reservationEntity.getResId(),
                    reservationEntity.getDate(),
                    reservationEntity.getStudent().getStudentId(),
                    reservationEntity.getRoom().getRoomTypeId(),
                    reservationEntity.getStatus()
            );
        }).collect(Collectors.toList()));

        return allRes;
    }

    @Override
    public String nextResId() {
        return reservationRepository.nextResId();
    }

    @Override
    public ArrayList<StudentDTO> getAllNotPay() {
        ArrayList<StudentDTO> studentList = new ArrayList<>();

        studentList.addAll(reservationRepository.getAllNotPay().stream().map(studentEntity -> {
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
}
