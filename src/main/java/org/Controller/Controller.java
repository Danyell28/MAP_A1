package org.Controller;

import org.Repository.IRepository;
import org.Model.*;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;
    }

    public IEntity[] getAll(){
        return this.repo.getAll();
    }

    public IEntity[] getAllWithCostOverThreshold(){
        IEntity[] result = new IEntity[10];
        int size = 10, current = 0;
        IEntity[] elements = this.repo.getAll();
        for(IEntity el: elements){
            if(el != null && el.isOver((float)1000)){
                if ( current == size ){
                    //we need to resize the array
                    IEntity[] newResult = new IEntity[2*size];
                    for(int i=0;i<size;i++)
                        newResult[i] = result[i];
                    result = newResult;
                    size *= 2;
                }
                result[current++] = el;
            }

        }
        return result;
    }

    public void remove(Integer id){
        this.repo.removeEntity(id);
    }

    public void add(String type, Integer id, String name, Integer repairCost){
        IEntity el;
        if ( type.equals("Car"))
            el = new Car(id,name,repairCost);
        else if( type.equals("Truck"))
            el = new Truck(id,name,repairCost);
        else if( type.equals("Motorcycle"))
            el = new Motorcycle(id,name,repairCost);
        else
            throw new RuntimeException("Invalid entity type. Try again!");
        this.repo.add(el);
    }


}
