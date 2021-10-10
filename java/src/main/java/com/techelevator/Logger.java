package com.techelevator;

import com.techelevator.view.Menu;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logger {

    public void writeToFile(String message) {
        try {

            File transactionLog = new File("Log.txt");
            if (!transactionLog.exists()) {
                transactionLog.createNewFile();
            }
            PrintWriter logWriter = new PrintWriter(new FileOutputStream("Log.txt", true));  // basic log method

            logWriter.printf("\n%tm/%td/%tY %tI:%tM:%tS %s", LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), message);
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        public void logFinancial(int currentDeposit, int currentBalance){
//
//        try {
//
//            File transactionLog = new File("Log.txt");
//            if (!transactionLog.exists()) {
//                transactionLog.createNewFile();
//            }
//            PrintWriter logWriter = new PrintWriter(new FileOutputStream("log.txt", true));  // basic log method
//
//            logWriter.printf("\n%tm/%td/%tY %tI:%tM:%tS %s %o %o", LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "FEED MONEY:", currentDeposit, currentBalance);
//
//            logWriter.flush();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        }

//    public void logProduct(String productName, String slotLocation ,int currentBalance, int newBalance){
//
//        try {
//            File transactionLog = new File("Log.txt");
//            if (!transactionLog.exists()) {
//                transactionLog.createNewFile();
//            }
//            PrintWriter logWriter = new PrintWriter(new FileOutputStream("log.txt", true));  // basic log method
//
//            logWriter.printf("\n%tm/%td/%tY %tI:%tM:%tS %s %s %o %o", LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
//            logWriter.flush();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}