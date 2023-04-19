package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.entity.UserEntity;
import lk.ijse.hibernate.d24.repository.custom.UserRepository;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserRepostoryImpl implements UserRepository {

    @Override
    public boolean save(UserEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(UserEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(UserEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public UserEntity search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        UserEntity user = session.get(UserEntity.class, id);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public String getPassword(String username) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select password from UserEntity where userName like: ID").setParameter("ID", username);

        List list = query.list();

        transaction.commit();
        session.close();

        if(list.size() == 0){
            return null;
        }else{
            return (String)list.get(0);
        }

    }
}
