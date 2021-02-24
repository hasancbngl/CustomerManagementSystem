package com.company;

public class printStar {
    private static int count = 1;

    public static void printStar(int lineNumber) {
        for(int i=0;i<lineNumber;i++) {
            System.out.println(printasCount(count));
            System.out.println("");
            if(count%2==1) count++;
            else count = count +2;
        }
    }
    public static String printasCount(int number) {
        if(number<=1) {
            return "*";
        }
        else {
            return "*" + printasCount(number-1);
        }

    }
}

