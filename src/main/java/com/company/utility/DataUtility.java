package com.company.utility;

public class DataUtility {
    public static boolean isStringOnlyAlphabetOrNumber(String str) {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z0-9_]*$")));
    }

    public static boolean isStringOnlyNumber(String str) {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[0-9]*$")));
    }

    public static boolean isStringCorrectDate(String str) {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[0-9-]*$")));
    }

    public static boolean isStringCorrectEmail(String str) {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z0-9_@.]*$")));
    }

    public static boolean isStringCorrectFirstNameOrLastName(String str) {
        return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
    }
}
