package lk.ijse.test.repo;

import lk.ijse.test.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface CrudRepo <TYPE extends SuperEntity,ID extends Serializable>{
    public TYPE add(Session session,TYPE type);
    public void update(Session session,TYPE type);
    public void delete(Session session,TYPE type);
    public TYPE get(Session session,ID id);
    public List<TYPE> getAll(Session session);
}
