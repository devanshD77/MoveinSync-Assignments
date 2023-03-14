package org.example;
import java.util.Scanner;
import java.sql.*;
public class App
{
    public static void main( String[] args ) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 for new user Registration");
        System.out.println("Press 2 for already registered user ");
        int option=sc.nextInt();
        if(option==1)
        {
            System.out.println("Enter the name of customer");
            String name=sc.next();
            System.out.println("Enter the new user pin ");
            int pin= sc.nextInt();
            String pin1= String.valueOf(pin);
            while(pin1.length()<=3)
            {
                System.out.println("Pin should be of 4 digits");
                System.out.println("Re-Enter pin");
                pin= sc.nextInt();
                pin1=String.valueOf(pin);
            }
            while(!pinvalidation.validate(pin))
            {
                System.out.println("Pin already exists");
                System.out.println("Enter the new user pin ");
                pin= sc.nextInt();
            }
            System.out.println("Enter the initial balance ");
            float balance=sc.nextFloat();
                newuser.register(name,pin,balance);
        }
        else
        {
            System.out.println("Enter your name :");
            String name=sc.next();
            System.out.println("Enter your pin :");
            int pin=sc.nextInt();
            String pin1= String.valueOf(pin);
            while(pin1.length()<=3)
            {
                System.out.println("Pin should be of 4 digits");
                System.out.println("Re-Enter pin");
                pin= sc.nextInt();
                pin1=String.valueOf(pin);
            }
            while(!Uservalidation.ifvalid(name,pin))
            {
                System.out.println("Invalid name or pin ");
                System.out.println("Enter your name :");
                 name=sc.next();
                System.out.println("Enter your pin :");
                 pin=sc.nextInt();
            }
            System.out.println("Welcome "+name );
            System.out.println("1) Show previous transactions");
            System.out.println("2) Withdraw money");
            System.out.println("3) Exit ");
            int choice=sc.nextInt();
            if(choice==1)
            {
               ResultSet resultSet=transactions.history(name,pin);
               if(resultSet.getFetchSize()<=0)
                    System.out.println("No transactions found ");
                while (resultSet.next()) {
                    System.out.println("Transaction Date and time ||  Amount Withdrawn ");
                    System.out.println(resultSet.getString(1)+"   ||   "+resultSet.getInt(2));
                }
            }
            else if(choice==2) {
                System.out.println("Enter the amount to withdraw :");
                float amount=sc.nextFloat();
                if(withdrawbalance.withdraw(name,pin,amount))
                {
                    System.out.println("Withdraw Successful ");
                }
                else{
                    System.out.println("Insufficient balance ");
                }
            }
            else {
                System.out.println("Thank You ");
                System.out.println("Good Bye ");
            }
        }
        sc.close();

    }
}

