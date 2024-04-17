package UtilityPackage;

import java.util.Scanner;
import java.util.regex.*;
public class Utils {
    public static boolean isPasswordValid(String password) {
        boolean lettreCheck = false;
        boolean didgitcheck = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLetter(ch)) {
                lettreCheck = true;
            } else if (Character.isDigit(ch)) {
                didgitcheck = true;
            }
        }
        if(lettreCheck && didgitcheck)
            return true;
        else return false;
    }

    public static boolean isEmailValid(String email){
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        if (!matcher.matches()){
            System.out.println("Invalid email try again:");
        }
        return matcher.matches();
    }
}
