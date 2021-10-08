package com.techelevator;

public class Bank {

    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;

    private int currentBalance = 0;

    public int getCurrentBalance() {
        return currentBalance;
    }

    public static int getNICKEL() {
        return NICKEL;
    }

    public static int getDIME() {
        return DIME;
    }

    public static int getQUARTER() {
        return QUARTER;
    }

}
