package com.company;

public class printStar {
    private static int count = 1;

    public static void printStar() {
        for(int i=0;i<6;i++) {
            printasCount(count);
            if(count%2==1) count++;
            else count = count +2;
        }
    }
    public static void printasCount(int number) {
        for(int j=1;j<=number;j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}

