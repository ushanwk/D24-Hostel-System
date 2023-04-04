package lk.ijse.hibernate.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTO {
    String resID;
    Date date;
    String StudentID;
    String roomTypeID;
    String status;
}
