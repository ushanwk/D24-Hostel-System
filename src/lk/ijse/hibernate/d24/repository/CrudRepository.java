package lk.ijse.hibernate.d24.repository;

public interface CrudRepository<T> extends SuperRepository{
    public boolean save(T entity);
    public boolean update(T entity);
    public boolean delete(T entity);
}
