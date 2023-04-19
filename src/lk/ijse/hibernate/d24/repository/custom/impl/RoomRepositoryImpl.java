package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public boolean save(RoomEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(RoomEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(RoomEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public RoomEntity search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        RoomEntity room = session.get(RoomEntity.class, id);

        transaction.commit();
        session.close();

        return room;
    }

    @Override
    public List<RoomEntity> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<RoomEntity> allRooms = session.createQuery("from RoomEntity").list();

        transaction.commit();
        session.close();

        return allRooms;
    }

    @Override
    public int getRoomCount(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select qty from RoomEntity where roomTypeId like: ID").setParameter("ID", id);

        int qty = (int)(query.list().get(0));

        transaction.commit();
        session.close();

        return qty;
    }

    @Override
    public String findNextRoomID() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select roomTypeId from RoomEntity order by roomTypeId desc");

        String nextId = "RM-0001";

        if(query.list().size() == 0){
            return nextId;
        }else{
            String id = (String)query.list().get(0);

            String[] SUs = id.split("RM-");

            for (String a:SUs) {
                id = a;
            }

            int idNum = Integer.valueOf(id);

            id = "RM-" + (idNum+1);

            transaction.commit();
            session.close();

            return id;
        }

    }
}
