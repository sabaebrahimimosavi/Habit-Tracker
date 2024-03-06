package TaskPackage;

public class Task {
    public String name;
    public double start_time;
    public double finish_time;

    public void setName(String name){
        this.name = name;
    }

    public double getDuration(){
        double result=0;
        double tempStart = start_time - (int) start_time;
        double tempFinish = finish_time - (int) finish_time;
        int tempHour = (int)finish_time - (int) start_time ;
        double tempMin=tempFinish - tempStart;
        if(tempMin<0){
            tempMin=0.6+tempMin;
            tempHour--;
            result = tempMin+tempHour;
        }
        return result;
    }

    public Task (String name){
        setName(name);
    }
}
