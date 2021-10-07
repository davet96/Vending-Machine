package com.techelevator;

public class Item {

    private String productName;
    private String productType;
    private String slotLocation;
    private int price;

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

    public Item(){
        this.productName = "default";
        this.productType = "default";
        this.slotLocation = "default";
        this.price = 0;
    }


    public Item(String productName, String productType, String slotLocation, int price) {
        this.productName = productName;
        this.productType = productType;
        this.slotLocation = slotLocation;
        this.price = price;
    }




  //  public void Item(){

    //}

}
