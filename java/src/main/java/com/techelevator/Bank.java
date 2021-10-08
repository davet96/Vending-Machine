package com.techelevator;

public class Bank {

    private static final int ONE_DOLLAR = 100;
    private static final int TWO_DOLLARS = 200;
    private static final int FIVE_DOLLARS = 500;
    private static final int TEN_DOLLARS = 1000;
    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;

    private int currentBalance = 0;

    public int getCurrentBalance() {
        return currentBalance;
    }

    public static int getOneDollar() {
        return ONE_DOLLAR;
    }

    public static int getTwoDollars() {
        return TWO_DOLLARS;
    }

    public static int getFiveDollars() {
        return FIVE_DOLLARS;
    }

    public static int getTenDollars() {
        return TEN_DOLLARS;
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
