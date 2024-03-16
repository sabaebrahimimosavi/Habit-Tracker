package TaskPackage;

import UserPackage.User;
import java.util.Scanner;
public class Task {
    public String name;
    public final String color=null;
    private double start_time;
    private double finish_time;
    User user =new User();

    Scanner timeInput = new Scanner(System.in) ;

    public void setStart_time(double start_time){
        while (start_time<0){
            System.out.println("invalid time!\n");
            start_time = timeInput.nextDouble();
        }
        this.start_time=start_time;
    }
    public void setFinish_time(double finish_time){
        while (finish_time<0){
            System.out.println("invalid time!\n");
            finish_time = timeInput.nextDouble();
        }
        this.finish_time=finish_time;
    }
    public void setName(String name){

        this.name = name;
    }

    public double getDuration(){
        double result;
        double tempStart = start_time - (int) start_time;
        double tempFinish = finish_time - (int) finish_time;
        int tempHour = (int)finish_time - (int) start_time ;
        double tempMin=tempFinish - tempStart;
        if(tempMin<0){
            tempMin=0.6+tempMin;
            tempHour--;
            result = tempMin+tempHour;
        } else {
            result = tempMin+tempHour;
        }
        return result;
    }

    boolean isColorValid (String colour){
        for (char c : colour.toCharArray()) {
            if ((c < 'A' || c > 'F') && (c < '0' || c > '9')) {
                System.out.println("Color is not valid!\nPlease enter valid color:");
                return false;
            }
        }
        color=colour;
        return true;
    }

    public Task (String name , User user)
    {
        setName(name);
    }
    public Task (String name , User user , String color){
        setName(name);
        isColorValid(color);
    }
}
