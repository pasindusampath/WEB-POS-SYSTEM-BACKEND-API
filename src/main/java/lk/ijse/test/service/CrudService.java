package lk.ijse.test.service;

import lk.ijse.test.dto.SuperDTO;

import java.io.Serializable;
import java.util.List;

public interface CrudService <Type extends SuperDTO,Id extends Serializable> extends SuperService{
    public Type add(Type type);
    public Type update(Type type);
    public boolean delete(Id type);
    public Type get(Id type);
    public List<Type> getAll();
}
