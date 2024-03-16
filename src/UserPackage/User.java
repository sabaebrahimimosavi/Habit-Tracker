package UserPackage;

import TaskPackage.Task;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    public  String first_name;

    public  String last_name;
    public  String email;
    public int streak;

    public User(String username, String password, String first_Name, String last_Name, String email) {
        this.username=username;
        this.password=password;
        this.first_name=first_Name;
        this.last_name=last_Name;
        this.email=email;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public Task createTask(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scan.nextLine();
        return new Task(name,);
    }
    public String getFullName(){
        return first_name + " " + last_name;
    }

}
