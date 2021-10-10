package com.techelevator;

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

    public void userBalance(int currentDeposit){
        bank.addMoneyToCurrentBalance(currentDeposit);
        System.out.println("Your balance is: " + formatMoneyOutput(bank.getCurrentBalance()));
        logAddMoney(currentDeposit);
    }

    public void dispenseItem(String itemChoice){
        item = inventory.getInventoryKey().get(itemChoice);
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            item.itemCountDecrease();
            printItemTypeMessage();
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

    public void executeTransaction(String itemChoice){

        if(inventory.getInventoryKey().containsKey(itemChoice)){
            item = inventory.getInventoryKey().get(itemChoice);
            System.out.println("You have purchased: " + itemChoice + " " + item.getProductName() + ", which costs " + formatMoneyForInternalUse(itemChoice));
            if(item.getCount() == 0){
                System.out.println("Sorry, this item is sold out :(");

            } else {
                if(bank.getCurrentBalance() > item.getPrice()){
                    int originalBalance = bank.getCurrentBalance();
                    dispenseItem(itemChoice);
                    bank.subtractMoneyFromCurrentBalance(item.getPrice());
                    String itemPrice = String.valueOf(item.getPrice());
                    logProductSelection(itemChoice, originalBalance);
                    System.out.println("\nYour current balance is: " + formatMoneyOutput(bank.getCurrentBalance()));
                } else {
                    System.out.println("Please add money to your current balance to purchase this item");
                }
            }


        } else{
            System.out.println("The item that you selected does not exist in the Vendo-Matic 800");
        }

    }

    public void getChangeAmount(){
        int originalBalance = bank.getCurrentBalance();
        bank.makeChange();
        logChangeGiven(originalBalance);
    }

    public String formatMoneyForInternalUse(String itemChoice){
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

    public String formatMoneyOutput(int money){
        String moneyAsString = String.valueOf(money);
        if(moneyAsString.length() == 1){
            return "$0.00";
        }
        if(moneyAsString.length() < 3){
            return "$0." + moneyAsString;
        }
        if(moneyAsString.length() == 3){
            String dollar = moneyAsString.substring(0, 1);
            String cents = moneyAsString.substring(1, moneyAsString.length());
            return "$" + dollar + "." + cents;
        }
        else {
            String dollar = moneyAsString.substring(0,2);
            String cents = moneyAsString.substring(2, moneyAsString.length());
            return "$" + dollar + "." + cents;
        }
    }

    public void logAddMoney(int currentDeposit){
        Logger depositLogger = new Logger();
        String message = "FEED MONEY: " + formatMoneyOutput(currentDeposit) + " " + formatMoneyOutput(bank.getCurrentBalance());
        if(currentDeposit > 0){
            depositLogger.writeToFile(message);
        }

    }

    public void logProductSelection(String itemChoice, int originalBalance){
        String message = item.getProductName() + " " + item.getSlotLocation() + " " + formatMoneyOutput(originalBalance) + " " + formatMoneyOutput(bank.getCurrentBalance());
        Logger productLogger = new Logger();
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            productLogger.writeToFile(message);
        }

    }

    public void logChangeGiven(int changeDue){
        Logger changeDueLogger = new Logger();
        String message = "GIVE CHANGE: " + formatMoneyOutput(changeDue) + " " + formatMoneyOutput(bank.getCurrentBalance());
        if(changeDue > 0){
            changeDueLogger.writeToFile(message);
        }
    }

}
