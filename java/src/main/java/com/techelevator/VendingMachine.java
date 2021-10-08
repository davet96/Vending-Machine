package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Map;

public class VendingMachine{

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String DISPLAY_MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";

    private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Add money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End transaction";
    private static final String PURCHASE_MENU_OPTION_RETURN_TO_MAIN = "Main menu";

    private static final String DEPOSIT_MENU_OPTION_ONE = "$1";
    private static final String DEPOSIT_MENU_OPTION_TWO = "$2";
    private static final String DEPOSIT_MENU_OPTION_FIVE = "$5";
    private static final String DEPOSIT_MENU_OPTION_TEN = "$10";



    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
    private static final String[] DISPLAY_MENU_OPTIONS = {DISPLAY_MENU_OPTION_RETURN_TO_MAIN};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_DEPOSIT_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_END_TRANSACTION, PURCHASE_MENU_OPTION_RETURN_TO_MAIN};
    private static final String[] DEPOSIT_MENU_OPTIONS = {DEPOSIT_MENU_OPTION_ONE, DEPOSIT_MENU_OPTION_TWO, DEPOSIT_MENU_OPTION_FIVE, DEPOSIT_MENU_OPTION_TEN};


    private Menu menu;


    Inventory inventory;
    Bank bank;
    Item item;

    public VendingMachine(){}


    public int getDepositTotal(){
        System.out.println("Please select options 1, 2, 5, 10");
        String depositMoneySelected = (String) menu.getChoiceFromOptions(DEPOSIT_MENU_OPTIONS);
        if(depositMoneySelected.equals(DEPOSIT_MENU_OPTION_ONE)){
            return 100;
        }else if(depositMoneySelected.equals(DEPOSIT_MENU_OPTION_TWO)){
            return 200;
        }else if(depositMoneySelected.equals(DEPOSIT_MENU_OPTION_FIVE)){
            return 500;
        }else if(depositMoneySelected.equals(DEPOSIT_MENU_OPTION_TEN)){
            return 1000;
        }
        return 0;
    }

    public void selectProduct(){
        System.out.println("Please select the product you would like to purchase using the slot number: ");
        String selectProductSelected = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION_SELECT_PRODUCT);

            String userChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTION_SELECT_PRODUCT);
            if(inventory.getInventoryKey().containsKey(userChoice)){
               int productCost = inventory.getInventoryKey().get(userChoice).getPrice(); //how to access price from TreeMap
                bank.getCurrentBalance() -= productCost;
            }
    }

    public void dispenseItem(){
        String userChoice = (String) menu.getChoiceFromOptions();
        if(inventory.getInventoryKey().containsKey(userChoice)){
            int currentItemCount = inventory.getInventoryKey().get(userChoice).getCount();
            currentItemCount -= 1;
        }

    }






}
