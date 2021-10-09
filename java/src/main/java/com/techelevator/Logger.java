package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




//public class Logger {


   // public static void main(String[] args)  {


        // make logger display month day time deposits, purchased items, change given
        // need print writer
        // try and catch block
        // call dataFile "Log.txt"
        // when making print writer code new PrintWriter(new FileOutputStream(Log.txt,true))
        // look up lecture, exercises, textbook, google it
//        try{
//            File transactionLog = new File("Log.txt");
//            if(!transactionLog.exists()){
//                transactionLog.createNewFile();
//            }
//            PrintWriter logWriter = new PrintWriter(new FileOutputStream("log.txt",true));
//            DateFormat dateFormat = new SimpleDateFormat();
//            Date date = new Date();
//
//            String userInput = menu.getChoiceFromMainMenu();
//            while (!userInput.equals("2")) {
//                if (userInput.equals("1")) {
//                    // call the method getItems on inventory
//                    for (int i = 0; i < listOfItems.size(); i++) {
//                        System.out.print(listOfItems.get(i).getCode() + "| ");
//                        System.out.print(listOfItems.get(i).getName() + "| ");
//                        System.out.println(listOfItems.get(i).getPrice());
//                    }
//                } else {
//                    System.out.println("Invalid selection! Please try again.");
//                }
//                userInput = menu.getChoiceFromMainMenu();
//            }
//
//            double currentDeposit = 0.00;
//
//
//            String purchaseInput= menu.PURCHASE_MENU_OPTIONS();
//            while (!purchaseInput.equals("3")) {
//                if (purchaseInput.equals("1")) {
//
//                    String depositMoneySelected = (String) menu.getChoiceFromOptions(DEPOSIT_MENU_OPTIONS);
//                    while (!depositMoneySelected.equals("5")) {
//                        if (depositMoneySelected.equals("1")) {
//                            currentDeposit += 1;
//                            logWriter.println(dateFormat.format(date) + " FEED MONEY: " + "$1.00" + "  $" + currentDeposit);
//                            System.out.println("Your balance is: $" + currentDeposit);
//                        } else if (depositMoneySelected.equals("2")) {
//                            currentDeposit += 2;
//                            logWriter.println(dateFormat.format(date) + " FEED MONEY: " + "$2.00" + "  $" + currentDeposit);
//                            System.out.println("Your balance is: $" + currentDeposit);
//                        } else if (depositMoneySelected.equals("3")) {
//                            currentDeposit += 5;
//                            logWriter.println(dateFormat.format(date) + " FEED MONEY: " + "$5.00" + "  $" + currentDeposit);
//                            System.out.println("Your balance is: $" + currentDeposit);
//                        } else if (depositMoneySelected.equals("4")) {
//                            currentDeposit += 10;
//                            logWriter.println(dateFormat.format(date) + " FEED MONEY: " + "$10.00" + "  $" + currentDeposit);
//                            System.out.println("Your balance is: $" + currentDeposit);
//                        } else {
//                            System.out.println("Invalid selection. Please try again.");
//                        }
//                        depositMoneySelected = menu.getMoneyFeed();
//                    }
//                }
//            }
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}