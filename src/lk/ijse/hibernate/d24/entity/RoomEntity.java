package lk.ijse.hibernate.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class RoomEntity {
    @Id
    @Column(length = 20)
    private String roomTypeId;
    private String type;
    private String keyMoney;
    private int qty;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ReservationEntity> resList = new ArrayList<>();



}
