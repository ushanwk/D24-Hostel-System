package lk.ijse.hibernate.d24.repository;

import lk.ijse.hibernate.d24.repository.custom.impl.StudentRepositoryImpl;

public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory(){
    }

    public static RepositoryFactory getRepositoryFactory(){
        return (repositoryFactory == null) ? repositoryFactory = new RepositoryFactory() : repositoryFactory;
    }

    public enum RepositoryTypes{
        STUDENT
    }

    public SuperRepository getRepository(RepositoryTypes types){
        switch (types) {
            case STUDENT:
                return new StudentRepositoryImpl();

            default:
                return null;
        }
    }
}