package utils;

import java.util.Date;

public class Utils {
    public static String randomUserName(){
        return "Vadym" + new Date().getTime();
    }
}
