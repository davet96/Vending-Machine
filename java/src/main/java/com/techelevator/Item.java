package com.techelevator;

public class Item {

    private String productName;
    private String productType;
    private String slotLocation;
    private int price;
    private int count;

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public int getPrice() {
        return price;
    }

    public int getCount(){
        return count;
    }

    public Item(){

        this.productName = "default";
        this.productType = "default";
        this.price = 0;
        this.slotLocation = "default";

    }


    public Item( String slotLocation, String productName, int price, String productType) {  // constructor for Item
        this.productName = productName;
        this.productType = productType;
        this.slotLocation = slotLocation;
        this.price = price;
        this.count = 5;
    }


    public void itemCountDecrease(){
        count -= 1;
    }

}
