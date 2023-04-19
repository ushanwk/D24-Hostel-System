package lk.ijse.hibernate.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class UserEntity {
    @Id
    @Column(length = 20)
    private String userName;
    private String password;
    private String name;
    private String tel;
}
