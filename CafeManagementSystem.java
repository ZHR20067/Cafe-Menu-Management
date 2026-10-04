/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dsa_project;

/**
 *
 * @author ZHR
 */
import java.util.ArrayList;
import java.util.Scanner;

class Cafe {
    int ID;
    String Name;
    double Price;
    
    Cafe(int ID, String Name, double Price) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
    } 
    void display() {
        System.out.println("item ID : " + ID + " || item name : " + Name + " || item price : " + Price);
    }
}

public class CafeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Cafe> C = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        int choice;
        
        do {
            System.out.println("\nCafe menu system");
            System.out.println("1. Add item");
            System.out.println("2. Search item");
            System.out.println("3. Delete item");
            System.out.println("4. Display available items");
            System.out.println("5. Exit");
            
            System.out.println("What would you like to do ?");
            choice = input.nextInt();
            
            switch (choice) {
                
    case 1: // Add item
        System.out.println("Enter item ID: ");
        int ID = input.nextInt();
        
        input.nextLine();
    
        System.out.println("Enter item name: ");
        String Name = input.nextLine();
        
        System.out.println("Enter item price: ");
        double Price = input.nextDouble();
        
        C.add(new Cafe(ID, Name, Price));
        System.out.println("Item added successfully! ");
        break;
        
    case 2: // Search item
        System.out.println("Enter item ID for search:");
        int searchID = input.nextInt();
        boolean found = false;
        
        for (Cafe c : C) {
            if (c.ID == searchID){
                System.out.println("\nitem available !");
                c.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("item sold out! ");
        }
        break;
        
    case 3: // Delete item
        System.out.println("Enter item ID to delete:");
        int deleteID = input.nextInt();
        boolean removed = false;

        for (int i = 0; i < C.size(); i++) {
            if (C.get(i).ID == deleteID) {
                C.remove(i);
                removed = true;
                System.out.println("Item deleted successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Item not found!");
        }
        break;
        
    case 4: // Display item
        for (int i = 0; i < C.size()-1; i++) {
            for (int j = 0; j < C.size() -i -1; j++) {
                if (C.get(j).ID > C.get(j+1).ID) {
                    Cafe temp = C.get(j);
                    C.set(j, C.get(j+1));
                    C.set(j+1, temp);
                }
            }
        }
        System.out.println("Items sorted by ID");
        System.out.println("\nAvailable items");
        
        for (Cafe c : C) {
            c.display();
        }
        break;
       
    case 5: // Exit
        System.out.println("End of menu");
        break;
        
    default:
        System.out.println("Invalid");
}
        } while (choice !=5);
        input.close();
    }
}
