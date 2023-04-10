package lk.ijse.hibernate.d24.repository;

import java.util.List;

public interface CrudRepository<T> extends SuperRepository{
    public boolean save(T entity);
    public boolean update(T entity);
    public boolean delete(T entity);
    public T search(String id);
    public List<T> getAll();
}
