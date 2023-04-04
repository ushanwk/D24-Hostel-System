package lk.ijse.hibernate.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDTO {
    String roomTypeID;
    String keyMoney;
    int qty;
    String type;
}
