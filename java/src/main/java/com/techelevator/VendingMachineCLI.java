package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

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

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	Inventory vmInventory = new Inventory();
	VendingMachine vendoMatic800 = new VendingMachine();

	public void run() {
		vmInventory.inventoryInput();
		while (true) {
			String userChoice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vmInventory.listItems();

			} else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean isInPurchaseMenu = true;

			while(isInPurchaseMenu){
				String purchaseSelected = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(purchaseSelected.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)){
					int currentDeposit = vendoMatic800.getDepositTotal();
					System.out.println("You have deposited: " + currentDeposit);
				}else if (purchaseSelected.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){

				}else if(purchaseSelected.equals(PURCHASE_MENU_OPTION_END_TRANSACTION)){

				}else {
					isInPurchaseMenu = false;
				}
			}
			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				//exit the program
			} else if (userChoice.equals(PURCHASE_MENU_OPTION_RETURN_TO_MAIN)) {

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


}
