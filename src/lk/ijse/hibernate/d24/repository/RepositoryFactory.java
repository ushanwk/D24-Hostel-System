package lk.ijse.hibernate.d24.repository;

import lk.ijse.hibernate.d24.repository.custom.impl.ReservationRepositoryImpl;
import lk.ijse.hibernate.d24.repository.custom.impl.RoomRepositoryImpl;
import lk.ijse.hibernate.d24.repository.custom.impl.StudentRepositoryImpl;

public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory(){
    }

    public static RepositoryFactory getRepositoryFactory(){
        return (repositoryFactory == null) ? repositoryFactory = new RepositoryFactory() : repositoryFactory;
    }

    public enum RepositoryTypes{
        STUDENT, ROOM, RESERVATION
    }

    public SuperRepository getRepository(RepositoryTypes types){
        switch (types) {
            case STUDENT:
                return new StudentRepositoryImpl();

            case ROOM:
                return new RoomRepositoryImpl();

            case RESERVATION:
                return new ReservationRepositoryImpl();

            default:
                return null;
        }
    }
}
