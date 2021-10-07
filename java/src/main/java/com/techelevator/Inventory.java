package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

            File vmFile = new File("vendingmachine.csv");
            try(Scanner fileImport = new Scanner(vmFile.getAbsolutePath())){
                if(!vmFile.exists()){
                    System.out.println("This file does not exist");
                } else if(!vmFile.isFile()){
                    System.out.println("This is not a file");
                }
                while(fileImport.hasNextLine()){
                    String itemLineInfo = fileImport.nextLine();
                    String[] Items = itemLineInfo.split("|");
                }

                for()

            } catch(FileNotFoundException) {
            System.out.println("File not found");
            }


//        catch(FileNotFoundException fnfE){
//        System.out.println("The file could not be read");
//        }




    ItemSlot A1 = new ItemSlot("A1");
    ItemSlot A2 = new ItemSlot("A2");
    ItemSlot A3 = new ItemSlot("A3");
    ItemSlot A4 = new ItemSlot("A4");
    ItemSlot B1 = new ItemSlot("B1");
    ItemSlot B2 = new ItemSlot("B2");
    ItemSlot B3 = new ItemSlot("B3");
    ItemSlot B4 = new ItemSlot("B4");
    ItemSlot C1 = new ItemSlot("C1");
    ItemSlot C2 = new ItemSlot("C2");
    ItemSlot C3 = new ItemSlot("C3");
    ItemSlot C4 = new ItemSlot("C4");
    ItemSlot D1 = new ItemSlot("D1");
    ItemSlot D2 = new ItemSlot("D2");
    ItemSlot D3 = new ItemSlot("D3");
    ItemSlot D4 = new ItemSlot("D4");

    List<ItemSlot> vmSlots = new ArrayList<>();




    public void getInventory(){
        for(ItemSlot currentSlot: vmSlots){
            System.out.println("There are " + currentSlot.getNumberOfItems() + " " + currentSlot.getProductName());
        }
    }
}
