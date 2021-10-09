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

    }

//    if(vmInventory.getInventoryKey().containsKey(userChoice)){
//        int productCost = vmInventory.getInventoryKey().get(userChoice).getPrice(); //how to access price from TreeMap

//    }



}
