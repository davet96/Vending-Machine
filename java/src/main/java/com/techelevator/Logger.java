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


        public void logFinancial(int currentDeposit, int currentBalance){

        try {

            File transactionLog = new File("Log.txt");
            if (!transactionLog.exists()) {
                transactionLog.createNewFile();
            }
            PrintWriter logWriter = new PrintWriter(new FileOutputStream("log.txt", true));  // basic log method
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
            LocalDate today = LocalDate.now();
            LocalDateTime time = LocalDateTime.now();

            logWriter.println(dateFormat.format(today) + " " + timeFormat.format(time) + " FEED MONEY: " + currentDeposit + " " + currentBalance);
            logWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    public void logProduct(String productName, String slotLocation ,int currentBalance, int newBalance){

        try {
            File transactionLog = new File("Log.txt");
            if (!transactionLog.exists()) {
                transactionLog.createNewFile();
            }
            PrintWriter logWriter = new PrintWriter(new FileOutputStream("log.txt", true));  // basic log method
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
            LocalDate today = LocalDate.now();
            LocalDateTime time = LocalDateTime.now();
            logWriter.println(dateFormat.format(today) + " " + timeFormat.format(time) + productName + " " + slotLocation + " " + currentBalance + " " + newBalance);

            logWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}