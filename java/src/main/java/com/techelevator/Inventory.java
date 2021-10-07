package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

            private static final int SLOT_LOCATION = 0;
            private static final int PRODUCT_NAME = 1;
            private static final int PRICE = 2;
            private static final int PRODUCT_TYPE = 3;


            public List<String[]> inventoryInput(){
            List<String[]> inventoryList = new ArrayList<>();

            File vmFile = new File("vendingmachine.csv");
            try(Scanner fileImport = new Scanner(vmFile.getAbsolutePath())){
                if(!vmFile.exists()){
                    System.out.println("This file does not exist");
                } else if(!vmFile.isFile()){
                    System.out.println("This is not a file");
                }
                while(fileImport.hasNextLine()){
                    String itemLineInfo = fileImport.nextLine();
                    String[] items = itemLineInfo.split("\\|");
                    inventoryList.add(items);
                }

            } catch(Exception e) {
            System.out.println(e.getMessage());
                }
            return inventoryList;
            }

            // need map of items tree map?
            //
            public TreeMap<String, Item> getInventoryKey() {
                TreeMap<String, Item> inventoryKey = new TreeMap<>();
                List<String[]> inventoryList = inventoryInput();
                for(String[] currentItem : inventoryList){
                  Integer priceConverter = Integer.parseInt(currentItem[PRICE]);
                   Item item = new Item(currentItem[SLOT_LOCATION],currentItem[PRODUCT_NAME],priceConverter,currentItem[PRODUCT_TYPE]);
                   inventoryKey.put(currentItem[SLOT_LOCATION],item);
                }
                return inventoryKey;
            }










}
