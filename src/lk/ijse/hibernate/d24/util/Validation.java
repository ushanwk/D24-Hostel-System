package lk.ijse.hibernate.d24.util;

import com.jfoenix.controls.JFXTextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validateLettersOnly(String text){
        Pattern pattern = Pattern.compile("^[A-Za-z]+(?:\\s[A-Za-z]+)*$");
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
    public static boolean validateNumbersOnly(String text){
        Pattern pattern = Pattern.compile("^[0-9]+$\n");
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }

    public static boolean validateDateOnly(String text){
        Pattern pattern = Pattern.compile("^[0-9]+$\n");
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
