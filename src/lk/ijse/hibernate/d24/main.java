package lk.ijse.hibernate.d24;

import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        StudentEntity student = new StudentEntity("S001", "Ushan", "Matara", "098976", Date.valueOf("2002-07-11"), "Male", new ArrayList<>());
        RoomEntity room = new RoomEntity("R001", "Single", "100000", 10, new ArrayList<>());
        ReservationEntity reservation = new ReservationEntity("R001", Date.valueOf("2022-07-11"), student, room, "AVL");

        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(room);
        session.save(reservation);

        transaction.commit();

        session.close();
    }
}
