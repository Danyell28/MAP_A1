package org.Model;

public class Truck implements IEntity{
    private Integer id;
    private String name;
    private Integer repairCost;

    public Truck(Integer id, String name, Integer repairCost){
        this.id = id;
        this.name = name;
        this.repairCost = repairCost;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getRepairCost(){
        return this.repairCost;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setRepairCost(Integer newRepairCost){
        this.repairCost = newRepairCost;
    }

    @Override
    public String toString(){
        return "Truck , "+ "id: "+ this.id +" , name: " + this.name + " , repair cost: " + this.repairCost;
    }

    public boolean isOver(Float threshold){
        return this.repairCost > threshold;
    }
}
