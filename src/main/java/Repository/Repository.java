package Repository;
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
            if(el.getId() == this.arr[i].getId())
                throw new RuntimeException("An element with the given id already exists!");
        }
        this.arr[current++] = el;
    }

    public void removeEntity( Integer id){
        for(int i=0;i<current;i++){
            if(this.arr[id].getId() == id){
                for(int j=i;j<current-1;j++)
                    this.arr[j] = this.arr[j+1];
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
