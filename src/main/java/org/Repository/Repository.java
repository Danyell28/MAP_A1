package org.Repository;
import org.Model.*;

public class Repository implements IRepository{
    private IEntity[] arr;
    private int size;
    private int current;

    public Repository(int size){
        this.arr = new IEntity[size];
        this.size = size;
        this.current = 0;
    }

    public void generateData() {
        add(new Car(1, "Skoda Octavia", 500));
        add(new Car(2, "Volkswagen Golf", 650));
        add(new Truck(3, "Volvo FH16", 2300));
        add(new Truck(4, "Scania R450", 2100));
        add(new Motorcycle(5, "Yamaha MT-07", 400));
        add(new Motorcycle(6, "Honda CB500F", 350));
    }

    private void resize(){
        IEntity[] newArr = new IEntity[2*size];
        for( int i=0; i<size; i++)
            newArr[i] = this.arr[i];
        this.size*=2;
        this.arr = newArr;
    }

    public void add(IEntity el){
        if ( this.current == this.size )
            resize();
        for( int i=0; i<current; i++){
            if(el.getId().equals(this.arr[i].getId()) )
                throw new RuntimeException("An element with the given id already exists!");
        }
        this.arr[current++] = el;
    }

    public void removeEntity( Integer id){
        for(int i=0;i<current;i++){
            if(this.arr[i].getId().equals(id)){
                for(int j=i;j<current-1;j++)
                    this.arr[j] = this.arr[j+1];
                this.arr[current - 1] = null;
                current--;
                return;
            }
        }
       throw new RuntimeException("There is no element with the given id!");
    }

    public IEntity[] getAll(){
        return this.arr.clone();
    }

}
