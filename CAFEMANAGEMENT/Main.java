package com.pack;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Cafe {
    private final int numberOfChefs;
    public Cafe(String name, int numberOfChefs) {
        this.numberOfChefs = numberOfChefs;

    }
}
class Chef implements Comparable<Chef>{
    private int busy;
    public Chef( int busy){
        this.busy = busy;
    }
    public int getBusy(){
        return busy;
    }
    public void setBusy(int busy) {
        this.busy = busy;
    }
    public int compareTo(Chef chef) {
        return this.busy-chef.getBusy();
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numberOfChefs;
        List<Chef> chefList = new ArrayList<>();
        System.out.println("Enter number of chefs :\t");
        numberOfChefs = sc.nextInt();
        for(int i = 0; i < numberOfChefs; i++){
            Chef c = new Chef(0);
            chefList.add(c);
        }
        PriorityQueue<Chef> chefs = new PriorityQueue<>(chefList);
        int numberOfOrder = 5;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String prevordtime = LocalTime.now().format(formatter);
        while(numberOfOrder-- > 0){
            List<Integer> order = Order.startOrder();
            LocalTime orderTime = LocalTime.now();
            String newordtime = formatter.format(orderTime);
            int timePassed = Time.calculateDifference(prevordtime, newordtime);
            prevordtime = newordtime;
            Time.updateChefBusyTime(chefList, timePassed);
            int maxibusy = 0;
            for(int i = 3; i >=0; i--)
            {
                int preparationTime;
                if(i == 3)
                    preparationTime =7;
                else if(i == 2)
                    preparationTime =5;
                else if(i == 1)
                    preparationTime =3;
                else
                    preparationTime=3;
                int quantity = order.get(i);
                while(quantity-- > 0)
                {
                    Chef chef = chefs.poll();
                    assert chef!=null;
                    int busyTime = chef.getBusy();
                    busyTime += preparationTime;
                    chef.setBusy(busyTime);
                    maxibusy = Math.max(maxibusy , busyTime);
                    chefs.add(chef);
                }
            }
            String deliveryTime = Time.addTime(newordtime, maxibusy);
            if(!newordtime.equals(deliveryTime)){
                System.out.println("Thank you sir you will get your order by "+ deliveryTime+"\n");
            }
        }
    }

}
