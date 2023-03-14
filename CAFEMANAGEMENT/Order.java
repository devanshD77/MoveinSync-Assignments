package com.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    private Order(){/* No Use*/}
    public static List<Integer> startOrder(){
        List<Integer> newOrder = new ArrayList<>(4);
        Scanner sc = new Scanner(System.in);
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        int item4 = 0;
        int choice;
        int quantity;
        System.out.println("Press 1 for Coffee");
        System.out.println("Press 2 for Cereal");
        System.out.println("Press 3 for Sandwich");
        System.out.println("Press 4 for Pizza");
        System.out.println("Enter your choice ");
        choice = sc.nextInt();
        if(choice == 5){
            return newOrder;
        }
        System.out.println("How much sir?");
        quantity = sc.nextInt();
        if(choice == 1)item1 += quantity;
        else if(choice == 2)item2 += quantity;
        else if(choice == 3)item3 += quantity;
        else if(choice == 4)item4 += quantity;
        else{
            System.out.println("We are not able to process your order.");
            return newOrder;
        }

        while(true){
            String bool;
            System.out.println("Would you like to add something else(Yes/No):");
            bool = sc.next();
            if(Objects.equals(bool, "No"))break;
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            System.out.println("Enter quantity for the item");
            quantity = sc.nextInt();
            if(choice == 1)item1 += quantity;
            else if(choice == 2)item2 += quantity;
            else if(choice == 3)item3 += quantity;
            else if(choice == 4)item4 += quantity;
            else System.out.println("You chose wrong option. Please check your choice");
        }
        newOrder.add(item1);newOrder.add(item2);newOrder.add(item3);newOrder.add(item4);
        return newOrder;
    }
}
