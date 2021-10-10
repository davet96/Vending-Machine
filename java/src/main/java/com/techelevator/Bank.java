package com.techelevator;

public class Bank {

    private static final int NICKEL = 5;
    private static final int DIME = 10;
    private static final int QUARTER = 25;


    private int currentBalance = 0;
    Inventory vmInventory = new Inventory();


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




    public int addMoneyToCurrentBalance(int currentDeposit){
        currentBalance += currentDeposit;
        return currentBalance;
    }

    public int subtractMoneyFromCurrentBalance(int itemChoicePrice){
        currentBalance -= itemChoicePrice;
        return currentBalance;
    }

    public int makeChange(){
       int changeDue = currentBalance;
       int numberOfQuarters;
       int numberOfDimes;
       int numberOfNickels;


       numberOfQuarters = Math.round(changeDue / 25);
       changeDue = changeDue % 25;
       numberOfDimes = Math.round(changeDue / 10);
       changeDue = changeDue % 10;
       numberOfNickels = Math.round(changeDue / 5);
       changeDue = changeDue % 5;

        System.out.println("Please enjoy your " + numberOfQuarters + " Quarters, " + numberOfDimes + " Dimes, and " + numberOfNickels + " Nickels!");

      return currentBalance = 0;
    }

    public int getItemChoicePrice(String itemChoice) {
        int productCost;
        if (vmInventory.getInventoryKey().containsKey(itemChoice)) {
             productCost = vmInventory.getInventoryKey().get(itemChoice).getPrice(); //how to access price from TreeMap
            return productCost ;
        }
        return 0;
    }



}
