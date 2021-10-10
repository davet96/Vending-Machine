package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;
import java.util.TreeMap;

public class VendingMachine{


    Inventory inventory = new Inventory();
    Bank bank = new Bank();
    Item item = new Item();

    public Inventory getInventory() {
        return inventory;
    }

    public Bank getBank() {
        return bank;
    }

    public Item getItem() {
        return item;
    }

    public VendingMachine(){}

    public void dispenseItem(String itemChoice){
        item = inventory.getInventoryKey().get(itemChoice);
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            item.itemCountDecrease();
            printItemTypeMessage();
        }

    }
    public void productSelection(String itemChoice){
        item = inventory.getInventoryKey().get(itemChoice);
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            System.out.println("You have selected: " + itemChoice);
        }
    }

    public void printItemTypeMessage(){
        if(item.getProductType().equals("Chip")){
            System.out.println("Crunch Crunch, Yum!");
        } else if(item.getProductType().equals("Candy")){
            System.out.println("Munch Munch, Yum!");
        } else if(item.getProductType().equals("Drink")){
            System.out.println("Glug Glug, Yum!");
        } else {
            System.out.println("Chew Chew, Yum!");
        }
    }

    public String formatMoney(String itemChoice){
        String formattedString = "";
        if(inventory.getInventoryKey().containsKey(itemChoice)) {
            String priceAsString = String.valueOf(inventory.getInventoryKey().get(itemChoice).getPrice());
            String afterDecimal = priceAsString.substring(priceAsString.length() - 2);
            String beforeDecimal = priceAsString.substring(0, priceAsString.length() - 2);
            if (priceAsString.length() <= 2) {
                beforeDecimal = "0";
            }
            formattedString = "$" + beforeDecimal + "." + afterDecimal;
        } return formattedString;
    }

    public void executeTransaction(String itemChoice){
        //Print out users choice, use printf()?
        //This method runs the entire transaction process
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            System.out.println("You have selected: " + itemChoice + ", which costs $" + formatMoney(itemChoice));
            if(item.getCount() == 0){
                System.out.println("Sorry, this item is sold out :(");

            } else {
                if(bank.getCurrentBalance() > item.getPrice()){
                    dispenseItem(itemChoice);
                    bank.subtractMoneyFromCurrentBalance(item.getPrice());
                    String itemPrice = String.valueOf(item.getPrice());
                    System.out.println(item.getProductName() + " " + formatMoney(itemPrice) + "\nYour current balance is: $" + bank.getCurrentBalance());
                } else {
                    System.out.println("Please add money to your current balance to purchase this item");
                }
            }


        } else{
            System.out.println("The item that you selected does not exist in the Vendo-Matic 800");
        }

    }

    public void getChangeAmount(){
        bank.makeChange();
    }

    public void userBalance(int currentDeposit){
        bank.addMoneyToCurrentBalance(currentDeposit);
        System.out.println("Your balance is: $" + (bank.getCurrentBalance() / 100));
    }

    public void logAddMoney(int currentDeposit){
        Logger depositLogger = new Logger();
        if(bank.addMoneyToCurrentBalance(currentDeposit) > 0){
            depositLogger.logFinancial(currentDeposit, bank.getCurrentBalance());
        }

    }

    public void logProductSelection(String itemChoice, int currentBalance){
        int newBalance = bank.getCurrentBalance() - bank.getItemChoicePrice(itemChoice);
        Logger productLogger = new Logger();
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            productLogger.logProduct(item.getProductName(), item.getSlotLocation(), currentBalance, newBalance);
        }

    }

    public void logChangeGiven(int changeDue){
        Logger changeDueLogger = new Logger();
        changeDue = bank.getCurrentBalance();
        if(changeDue > 0){
            changeDueLogger.logFinancial(bank.getCurrentBalance(), 0);
        }
    }





}
