package TaskPackage;

import UserPackage.User;
import java.util.Scanner;
public class Task {
    public String name;
    private final String color;
    private double start_time;
    private double finish_time;
    private User user ;

    public void setUser(User user) {
        this.user = user;
    }

    Scanner timeInput = new Scanner(System.in) ;

    public void setStart_time(double start_time){
        while (start_time<0){
            System.out.println("invalid time!\n");
            start_time = timeInput.nextDouble();
        }
        this.start_time=start_time;
    }
    double getStartTime(){
        return start_time;
    }
    public void setFinish_time(double finish_time){
        while (finish_time<0){
            System.out.println("invalid time!\n");
            finish_time = timeInput.nextDouble();
        }
        this.finish_time=finish_time;
    }
    double getFinishTime(){
        return finish_time;
    }
    public void setName(String name){

        this.name = name;
    }

    public double getDuration(){
        double result;
        if (getStartTime()<=getFinishTime()){
            double tempStart = getStartTime() - (int) getStartTime();
            double tempFinish = getFinishTime() - (int) getFinishTime();
            int tempHour = (int) getFinishTime() - (int) getStartTime();
            double tempMin = tempFinish - tempStart;
            if (tempMin < 0) {
                tempMin = 0.6 + tempMin;
                tempHour--;
                result = tempMin + tempHour;
            } else {
                result = tempMin + tempHour;
            }
        }else {
            double tempStart = getStartTime() - (int) getStartTime();
            double tempFinish = getFinishTime() - (int) getFinishTime();
            int tempHour = (int) getFinishTime() - (int) getStartTime();
            double tempMin = tempFinish - tempStart;
            if (tempMin >= 0) {
                tempHour=24+tempHour;
                result = tempMin + tempHour;
            } else {
                tempMin = 0.6 + tempMin;
                tempHour=24+tempHour;
                tempHour--;
                result = tempMin + tempHour;
            }
        }
        return result;
    }

    public static boolean isColorValid (String colour){
        for (char c : colour.toCharArray()) {
            if ((c < 'A' || c > 'F') && (c < '0' || c > '9')) {
                System.out.println("Color is not valid!\nPlease enter valid color:");
                return false;
            }
        }
        return true;
    }

    public Task (String name , User user)
    {
        setName(name);
        //white
        color="FFFFFF";
        setUser(user);
    }
    public Task (String name , User user , String color){
        setName(name);
        setUser(user);
        this.color=color;
    }
}
