package com.pack;
import java.util.List;

public class Time {
    private Time(){}
    public static int calculateDifference(String lastOrderTime, String orderTime){
        String[] lastTime  = lastOrderTime.split(":");
        String[] currTime =  orderTime.split(":");
        int lastOrderHours = Integer.parseInt(lastTime[0]);
        int lastOrderMinutes = Integer.parseInt(lastTime[1]);
        int currOrderHours = Integer.parseInt(currTime[0]);
        int currOrderMinutes = Integer.parseInt(currTime[1]);
        int timePassed = 0;
        if(currOrderHours-lastOrderHours == 0)timePassed = currOrderMinutes - lastOrderMinutes;
        else if(currOrderHours-lastOrderHours == 1){
            timePassed += 60 - lastOrderMinutes + currOrderMinutes;
        }
        else if(currOrderHours-lastOrderHours > 1){
            timePassed = (currOrderHours - lastOrderHours -1)*60;
            timePassed += 60 - lastOrderMinutes + currOrderMinutes;
        }
        return timePassed;
    }
    public static String addTime(String orderTime, int timeBusy){
        String[] currTime =  orderTime.split(":");
        int currOrderHours = Integer.parseInt(currTime[0]);
        int currOrderMinutes = Integer.parseInt(currTime[1]);
        currOrderMinutes += timeBusy/60;
        currOrderMinutes += (timeBusy % 60);
        if(currOrderMinutes >= 60){
            currOrderHours++;
            currOrderMinutes -= 60;
        }
        if(currOrderHours >= 24){
            currOrderHours -= 24;
        }
        return Integer.toString(currOrderHours)+":"+Integer.toString(currOrderMinutes);
    }
    public static void updateChefBusyTime(List<Chef>chefList , int timePassed){
        for(Chef chef: chefList){
            int busyTime = chef.getBusy();
            busyTime -= timePassed;
            if(busyTime < 0)busyTime = 0;
            chef.setBusy(busyTime);
        }
    }
}
