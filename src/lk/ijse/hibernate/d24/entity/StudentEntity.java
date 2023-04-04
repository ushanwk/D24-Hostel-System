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
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String tel;
    @Column
    private Date DOB;
    @Column
    private String gender;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ReservationEntity> resList = new ArrayList<>();

}
