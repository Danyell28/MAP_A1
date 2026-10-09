package org.Model;

public interface IEntity {
    public Integer getId();
    public String getName();
    public Integer getRepairCost();

    public void setName(String newName);
    public void setRepairCost(Integer newRepairCost);

    public String toString();
    public boolean isOver(Float threshold);
}
