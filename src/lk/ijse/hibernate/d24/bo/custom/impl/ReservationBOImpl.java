package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.ReservationBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.ReservationRepository;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.repository.custom.StudentRepository;

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
}
