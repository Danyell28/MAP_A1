package org.View;

import org.Controller.Controller;
import org.Model.IEntity;

import java.util.Scanner;

public class UI {
    private Controller controller;

    public UI(Controller controller){
        this.controller = controller;
    }

    private void printAll(){
        IEntity[] elements = this.controller.getAll();
        System.out.println("There are all the entities in the program:");
        for(IEntity el : elements){
            if( el != null)
                System.out.println(el.toString());
        }

    }

    private void printAllOverThreshold(){
        IEntity[] elements = this.controller.getAllWithCostOverThreshold();
        System.out.println("There are all the entities in the program:");
        for(IEntity el : elements) {
            if( el != null)
                System.out.println(el.toString());
        }
    }

    private void addEntity(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the type of the entity: ");
        String type = sc.next();

        System.out.println("Enter the id of the entity: ");
        Integer id = new Integer(sc.nextInt());

        System.out.println("Enter the name of the entity: ");
        String name = sc.next();

        System.out.println("Enter the repair cost of the entity: ");
        Integer repairCost = new Integer(sc.nextInt());

        try{
            this.controller.add(type,id,name,repairCost);
            System.out.println("The entity was successfully added!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteEntity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the id of the element you wish to remove:");
        Integer id = new Integer(sc.nextInt());
        try{
            this.controller.remove(id);
            System.out.println("The element was successfully removed!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private void printMenu(){
        System.out.println("\nSelect one of the following: ");
        System.out.println("1. Show all entities in the program.");
        System.out.println("2. Add a new entity.");
        System.out.println("3. Delete an entity.");
        System.out.println("4. Show all entities with a repair cost of over 1000");
        System.out.println("0. Exit the program");
    }

    public void menu(){
        int option;
        Scanner sc = new Scanner(System.in);
        while(true){
            this.printMenu();
            System.out.print(" -> ");
            option = sc.nextInt();
            switch(option){
                case 0:
                    break;
                case 1:
                    this.printAll();
                    break;
                case 2:
                    this.addEntity();
                    break;
                case 3:
                    this.deleteEntity();
                    break;
                case 4:
                    this.printAllOverThreshold();
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
            if( option == 0) {
                System.out.println("Bye bye!!!");
                break;
            }
        }
    }
}
