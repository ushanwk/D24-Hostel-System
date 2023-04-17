package lk.ijse.hibernate.d24.repository.custom.impl;

import lk.ijse.hibernate.d24.entity.StudentEntity;
import lk.ijse.hibernate.d24.repository.custom.StudentRepository;
import lk.ijse.hibernate.d24.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public boolean save(StudentEntity entity) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(StudentEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(StudentEntity entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public StudentEntity search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        StudentEntity student = session.get(StudentEntity.class, id);

        transaction.commit();
        session.close();

        return student;
    }

    @Override
    public List<StudentEntity> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<StudentEntity> allStudents = session.createQuery("from StudentEntity").list();

        transaction.commit();
        session.close();

        return allStudents;
    }

    @Override
    public String findNextStudentID() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select studentId from StudentEntity order by studentId desc");

        String id = (String)query.list().get(0);

        String[] SUs = id.split("S00");

        for (String a:SUs) {
            id = a;
        }

        int idNum = Integer.valueOf(id);

        id = "S00" + (idNum+1);

        transaction.commit();
        session.close();

        return id;

    }
}
