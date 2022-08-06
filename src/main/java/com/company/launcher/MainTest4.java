package com.company.launcher;

import java.sql.SQLException;
import java.text.ParseException;

public class MainTest4 {


    public static void main(String[] args) throws SQLException, ParseException {


        System.out.println(sum());


    }


    public  static int  sum (int... nums){
        int s= 0 ;
        for(int a : nums)
            s+=a;
        return s;
    }
}
