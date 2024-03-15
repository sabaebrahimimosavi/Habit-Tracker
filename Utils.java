package UtilityPackage;

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
}
