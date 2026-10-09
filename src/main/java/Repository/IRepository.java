package Repository;

import org.Model.*;

public interface IRepository {

    public IEntity[] getAll();
    public void add(IEntity el);
}
