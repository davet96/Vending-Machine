package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;

public class VendingMachine{


    Inventory inventory;
    Bank bank;
    Item item;

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
        }

    }
    public void productSelection(String itemChoice){
        item = inventory.getInventoryKey().get(itemChoice);
        if(inventory.getInventoryKey().containsKey(itemChoice)){
            System.out.println("You have selected: " + itemChoice);
            System.out.println(item.printItemTypeMessage());
        }
    }

    public void executeTransaction(String itemChoice){
        System.out.println("You have selected: " + itemChoice + ", which cost " + bank.getItemChoicePrice(itemChoice));

        bank.makeChange(bank.getCurrentBalance(), bank.getItemChoicePrice(itemChoice));
    }




}
