package UserPackage;
import TaskPackage.Task;
import UtilityPackage.Utils;
import java.util.Scanner;


import static UtilityPackage.Utils.*;

public class User {
    private String username;
    private String password;
    public  String first_name;
    Task[] taskList = new Task[100] ;
    private static int taskCount ;

    public  String last_name;
    public  String email;
    public int streak;
    Scanner scan = new Scanner(System.in);

    public User(String username, String password, String first_Name, String last_Name, String email) {
        setUsername(username);
        setPassword(password);
        setFirst_name(first_Name);
        setLast_name(last_Name);
        this.taskCount =0 ;
        while (!isEmailValid(email)){
            email=scan.next();
        }
        this.email=email;
    }

    public void setLast_name(String last_name) {
        last_name=last_name.substring(0,1).toUpperCase()+last_name.substring(1).toLowerCase();
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        first_name=first_name.substring(0,1).toUpperCase()+first_name.substring(1).toLowerCase();
        this.first_name =first_name;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        while (!Utils.isPasswordValid(password)){
            System.out.println("YOUR PASSWORD IS INVALID !!! AT LEAST USE ONE LETTER AND ONE NUMBER .");
            System.out.println("Enter valid password:");
            password = scan.next();
        }
        this.password = password;
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
        return first_name.concat(" "+last_name);
    }
    public Task getTaskByName(String taskName){
        for(int i=0 ; i<taskCount; i++){
            if (taskList[i].getName().equals(taskName)){
                return taskList[i];
            }
        }
        System.out.println("Error: Task not found with this name ' " + taskName + " '");
        return null;
    }
    public Task[] getTaskByColor(String color) {
        Task[] tasksWithColor = new Task[taskCount];
        int count = 0;
        for (int i = 0; i < taskCount; i++) {
            if (taskList[i].getColor().equals(color)) {
                tasksWithColor[count] = taskList[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No tasks found with the color '" + color + "'.");
            return null;
        }
        Task[] result = new Task[count];
        System.arraycopy(tasksWithColor, 0, result, 0, count);
        return result;
    }

}
