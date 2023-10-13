package com.example.aston_task_jun.bankaccount.utils;

public class AccountUtil {

    public static String getRandomNumberBetweenRange(){
        long number = (long) (Math.random()*((9999999999999999L-1000000000000000L)+1))+1000000000000000L;
        return number + "";
    }
}
