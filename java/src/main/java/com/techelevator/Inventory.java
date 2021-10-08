package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

            private static final int SLOT_LOCATION = 0;
            private static final int PRODUCT_NAME = 1;
            private static final int PRICE = 2;
            private static final int PRODUCT_TYPE = 3;

            public Inventory(){}


            public List<String[]> inventoryInput(){
            List<String[]> inventoryList = new ArrayList<>();

            File vmFile = new File("vendingmachine.csv");
            try(Scanner fileImport = new Scanner(vmFile)){
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
                  double priceConverter = Double.parseDouble(currentItem[PRICE]);
                  int priceAsInt = (int) priceConverter * 100;
                   Item item = new Item(currentItem[SLOT_LOCATION],currentItem[PRODUCT_NAME], priceAsInt,currentItem[PRODUCT_TYPE]);
                   inventoryKey.put(currentItem[SLOT_LOCATION],item);
                }
                return inventoryKey;
            }

            public void listItems(){
                for(Map.Entry<String,Item> currentEntry :getInventoryKey().entrySet()){
                    System.out.println(currentEntry.getKey() + " " + currentEntry.getValue().getProductName() + " " + currentEntry.getValue().getPrice() + " " + currentEntry.getValue().getCount() + " in stock" );
                }
            }


            public PrintWriter logWriter(){
                String fileDestination = "log.txt";
                File logDestination = new File(fileDestination);
                logDestination.getAbsolutePath();

                try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(logDestination, true))) {

                } catch(FileNotFoundException fnfE){
                    System.out.println(fnfE.getMessage());

                } return logWriter();
            }










}
