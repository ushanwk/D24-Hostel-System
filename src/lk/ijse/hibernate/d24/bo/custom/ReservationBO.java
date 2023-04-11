package lk.ijse.hibernate.d24.bo.custom;

import lk.ijse.hibernate.d24.bo.SuperBO;
import lk.ijse.hibernate.d24.dto.ReservationDTO;
import lk.ijse.hibernate.d24.dto.RoomDTO;

public interface ReservationBO extends SuperBO {
    public boolean saveReservation(ReservationDTO reservationDTO);
    public boolean updateReservation(ReservationDTO reservationDTO);
    public boolean deleteReservation(ReservationDTO reservationDTO);
    public ReservationDTO searchReservation(String id);
}
