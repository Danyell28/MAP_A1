package org.Repository;

import org.Model.*;

public interface IRepository {

    public IEntity[] getAll();
    public void add(IEntity el);
    public void removeEntity(Integer id);
    public void generateData();
}
