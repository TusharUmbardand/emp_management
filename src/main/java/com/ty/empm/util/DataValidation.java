package com.ty.empm.util;

import java.util.regex.Pattern;

public class DataValidation {

    public static boolean nameCheck(String name){
        String regex = "^[A-Za-z]+(\\s[A-Za-z]+)*$";
        return Pattern.matches(regex,name);

    }

}
