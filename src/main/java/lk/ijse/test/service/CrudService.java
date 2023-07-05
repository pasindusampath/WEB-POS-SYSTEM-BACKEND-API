package lk.ijse.test.service;

public interface CrudService <Type,Id>{
    public Type add(Type type);
    public Type update(Type type);
    public boolean delete(Id type);
    public Type get(Id type);
}
