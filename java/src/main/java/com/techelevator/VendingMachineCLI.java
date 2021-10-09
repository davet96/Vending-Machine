package com.techelevator;

import com.techelevator.view.Menu;

import java.util.TreeMap;

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
					int currentDeposit = getDepositTotal();
					System.out.println("You have deposited: $" + (currentDeposit / 100));
				}else if (purchaseSelected.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
	//				vmInventory.listItems();

					selectProduct(vmInventory.getInventoryKey());

				String itemChoice = selectProduct(vmInventory.getInventoryKey()); // result of select product

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

	public String selectProduct(TreeMap<String, Item> inventoryKey) {  // feed money , select product, give change
		String[] productOptions = inventoryKey.keySet().toArray(new String[inventoryKey.size()]); // a1 item, a2 item making it same size of inventory key as a string array
		System.out.println("Please select the product you would like to purchase using the slot number: ");
		String userChoice = (String) menu.getChoiceFromOptions(productOptions);

		return userChoice;
	}

}
// add display of how much change is left before exiting program
// add product name when item is selected