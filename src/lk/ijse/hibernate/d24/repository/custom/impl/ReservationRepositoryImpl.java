package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.ReservationEntity;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.repository.custom.ReservationRepository;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public boolean save(ReservationEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(ReservationEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(ReservationEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ReservationEntity search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ReservationEntity reservation = session.get(ReservationEntity.class, id);

        transaction.commit();
        session.close();

        return reservation;
    }

    @Override
    public List<ReservationEntity> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<ReservationEntity> allReservations = session.createQuery("from ReservationEntity").list();

        transaction.commit();
        session.close();

        return allReservations;
    }

    @Override
    public String nextResId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select resId from ReservationEntity order by resId desc");

        String nextId = "R001";

        if (query.list().size() == 0) {
            return nextId;
        } else {
            String id = (String) query.list().get(0);

            String[] SUs = id.split("R00");

            for (String a : SUs) {
                id = a;
            }

            int idNum = Integer.valueOf(id);

            id = "R00" + (idNum + 1);

            transaction.commit();
            session.close();

            return id;
        }
    }
}
