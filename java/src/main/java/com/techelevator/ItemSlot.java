package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ItemSlot extends Item{

    public int numberOfItems;
    private String slotNumber;
    private List<Item> slotContents = new ArrayList<>();


    public String getSlotNumber() {
        return this.slotNumber;
    }

    public int getNumberOfItems() { // get number of items
        return slotContents.size();
    }

    public ItemSlot(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ItemSlot(String productName, String productType, String slotLocation, int price) {
        super(productName, productType, slotLocation, price);
    }

    Item potatoCrisps = new Item("Potato Crisps", "Chip", "A1", 305);
    Item stackers = new Item("Stackers", "Chip", "A2", 145);
    Item grainWaves = new Item("Grain Waves", "Chip","A3", 275);
    Item cloudPopcorn = new Item("Cloud Popcorn", "Chip", "A4", 365);
    Item moonpie = new Item("Moonpie", "Candy", "B1", 180);
    Item cowtales = new Item("Cowtales", "Candy", "B2", 150);
    Item wonkaBar = new Item("Wonka Bar", "Candy", "B3", 150);
    Item crunchie = new Item("Crunchie", "Candy", "B4", 175);
    Item cola = new Item("Cola", "Soda", "C1", 125);
    Item drSalt = new Item("Dr. Salt", "Soda", "C2", 150);
    Item mountainMelter = new Item("Mountain Melter", "Soda", "C3", 150);
    Item heavy = new Item("Heavy", "Soda", "C4", 150);
    Item uChews = new Item("U-Chews", "Gum", "D1", 85);
    Item littleLeagueChew = new Item("Little League Chew", "Gum", "D2", 95);
    Item chiclets = new Item("Chiclets", "Gum", "D3", 75);
    Item triplemint = new Item("Triplemint", "Gum", "D4", 75);

    List<Item> itemReference = new ArrayList<>();{
        itemReference.add(potatoCrisps);
        itemReference.add(stackers);
        itemReference.add(grainWaves);
        itemReference.add(cloudPopcorn);
        itemReference.add(moonpie);
        itemReference.add(cowtales);
        itemReference.add(wonkaBar);
        itemReference.add(crunchie);
        itemReference.add(cola);
        itemReference.add(drSalt);
        itemReference.add(mountainMelter);
        itemReference.add(heavy);
        itemReference.add(uChews);
        itemReference.add(littleLeagueChew);
        itemReference.add(chiclets);
        itemReference.add(triplemint);
    }

    public void removeFromSlot(){
        slotContents.remove(0);
    }

    public void fillSlot(){
        for(Item currentItem: itemReference){
            slotContents.add(currentItem);
            slotContents.add(currentItem);
            slotContents.add(currentItem);
            slotContents.add(currentItem);
            slotContents.add(currentItem);
        }
    }

 







}
