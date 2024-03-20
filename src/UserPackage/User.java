package UserPackage;
import TaskPackage.Task;
import UtilityPackage.Utils;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    public  String first_name;
    Task[] taskList = new Task[100] ;
    private int taskCount ;

    public  String last_name;
    public  String email;
    public int streak;

    public User(String username, String password, String first_Name, String last_Name, String email) {
        this.username=username;
        this.password=password;
        this.first_name=first_Name;
        this.last_name=last_Name;
        this.email=email;
        this.taskCount =0 ;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        if(Utils.isPasswordValid(password)) this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }


    public boolean isTaskRepetitive(String newTask){
        int i;
        for( i=0 ; i< taskCount ; i++){
            if(taskList[i].name .equals(newTask))
                return true;
        }
        return false;
    }
    public Task createTask(String name) {
        Scanner scan = new Scanner(System.in);
        while (isTaskRepetitive(name)) {
            System.out.println("Creation failed : Task with this name already exists !!!");
            System.out.println("Choose diffrent name:");
            name = scan.next();
        }

        System.out.println("Chose color for your task :");
        String color = scan.next();
        while (!Task.isColorValid(color)) {
            color = scan.next();
        }
        Task task = new Task(name, this, color);
        taskList[taskCount] = task;
        taskCount++;
        return task;

    }
    public String getFullName(){

        return first_name + " " + last_name;
    }

}
