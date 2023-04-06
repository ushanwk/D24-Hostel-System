package lk.ijse.hibernate.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class StudentEntity {
    @Id
    @Column(length = 20)
    private String studentId;
    private String name;
    private String address;
    private String tel;
    private Date DOB;
    private String gender;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ReservationEntity> resList = new ArrayList<>();

}
