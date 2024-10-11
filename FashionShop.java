import java.util.*;

public class FashionShop {
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c",
						"cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}

	public static int orderStatus = -1;
	public static final int processing = 0;
	public static final int delivering = 1;
	public static final int delivered = 2;

	public static String phoneNumber;
	public static double amount;
	public static String tShirtSize;
	public static int qty;

	public static String x = "";
	public static int num = 1;

	public static String[] statusArray = new String[0];
	public static String[] orderIDArray = new String[0];
	public static String[] phoneNumberArray = new String[0];
	public static String[] tShirtSizeArray = new String[0];
	public static int[] qtyArray = new int[0];
	public static double[] amountArray = new double[0];

	public static void extendArrys() {
		String[] tempOrderIDArray = new String[orderIDArray.length + 1];
		String[] tempphoneNumberArray = new String[phoneNumberArray.length + 1];
		String[] temptShirtSizeArray = new String[tShirtSizeArray.length + 1];
		int[] tempqtyArray = new int[qtyArray.length + 1];
		double[] tempamountArray = new double[amountArray.length + 1];

		for (int i = 0; i < phoneNumberArray.length; i++) {
			tempOrderIDArray[i] = orderIDArray[i];
			tempphoneNumberArray[i] = phoneNumberArray[i];
			temptShirtSizeArray[i] = tShirtSizeArray[i];
			tempqtyArray[i] = qtyArray[i];
			tempamountArray[i] = amountArray[i];

		}
		tempOrderIDArray[tempOrderIDArray.length - 1] = x;
		tempphoneNumberArray[tempphoneNumberArray.length - 1] = phoneNumber;
		temptShirtSizeArray[temptShirtSizeArray.length - 1] = tShirtSize;
		tempqtyArray[tempqtyArray.length - 1] = qty;
		tempamountArray[tempamountArray.length - 1] = amount;

		orderIDArray = tempOrderIDArray;
		phoneNumberArray = tempphoneNumberArray;
		tShirtSizeArray = temptShirtSizeArray;
		qtyArray = tempqtyArray;
		amountArray = tempamountArray;

	}

	public static void main(String[] args) {
		homepage();

	}

	public static void homepage() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.println(
				" /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
		System.out.println(
				"| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
		System.out.println(
				"| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
		System.out.println(
				"| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println(
				"| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println(
				"| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println(
				"| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println(
				"|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
		System.out.println(
				"                                                                                                | $$      ");
		System.out.println(
				"                                                                                                | $$      ");
		System.out.println(
				"                                                                                                |__/      ");
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");

		System.out.println();
		System.out.println("\t\t[1] Place Order\t\t\t\t[2] Search Customer");
		System.out.println();
		System.out.println("\t\t[3] Search Order\t\t\t[4] View Reports");
		System.out.println();
		System.out.println("\t\t[5] Set Order Status\t\t\t[6] Delect Order");
		System.out.println();

		System.out.print("\t\tInput Option : ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				clearConsole();
				placeOrder();
				break;

			case 2:
				clearConsole();
				searchCustomer();
				break;

			case 3:
				clearConsole();
				searchOrder();
				break;

			case 4:
				clearConsole();
				viewReports();
				break;

			case 5:
				clearConsole();
				setOrderStatus();
				break;

			case 6:
				clearConsole();
				delectOrder();
				break;

			default:
				System.exit(0);

		}

	}

	public static void placeOrder() {

		System.out.println();
		System.out.println("  _____  _                   ____          _           ");
		System.out.println(" |  __ \\| |                 / __ \\        | |          ");
		System.out.println(" | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println(" |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println(" | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println(" |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println();

		incrementOrderID();
		phoneNumber();
		tShirtSize();

	}

	public static void incrementOrderID() {

		if (num < 10) {
			x = ("ODR#0000" + num++);

		} else if (num < 100) {
			x = ("ODR#000" + num++);

		} else if (num < 1000) {
			x = ("ODR#00" + num++);

		} else if (num < 10000) {
			x = ("ODR#0" + num++);

		}

		System.out.println("Enter Order ID : " + x);

	}

	public static void phoneNumber() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter Customer Phone Number : ");
		phoneNumber = scanner.nextLine();

		if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {

		} else {
			System.out.println("\nInvalid Phone Number... Try Again");
			System.out.println();
			System.out.print("Do you want to enter phone number again (Y/N) : ");
			char yn = scanner.next().charAt(0);

			if (yn == 'Y' || yn == 'y') {
				clearConsole();
				phoneNumber();

			} else if (yn == 'N' || yn == 'n') {
				clearConsole();
				homepage();

			}

		}

	}

	public static void tShirtSize() {
		Scanner scanner = new Scanner(System.in);

		double xsPrice = 600.00;
		double sPrice = 800.00;
		double mPrice = 900.00;
		double lPrice = 1000.00;
		double xlPrice = 1100.00;
		double xxlPrice = 1200.00;

		System.out.print("\nEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
		tShirtSize = scanner.nextLine();

		System.out.print("\nEnter QTY : ");
		qty = scanner.nextInt();

		amount = 0.00;

		switch (tShirtSize.toUpperCase()) {
			case "XS":
				amount = xsPrice * qty;
				break;

			case "S":
				amount = sPrice * qty;
				break;

			case "M":
				amount = mPrice * qty;
				break;

			case "L":
				amount = lPrice * qty;
				break;

			case "XL":
				amount = xlPrice * qty;
				break;

			case "XXL":
				amount = xxlPrice * qty;
				break;

			default:
				System.out.println("\nInvalid T-Shirt Size...");

				System.out.print("\nDo you want to enter T-Shirt size again (Y/N) : ");
				char yn = scanner.next().charAt(0);

				if (yn == 'Y' || yn == 'y') {
					clearConsole();
					tShirtSize();
					break;

				} else if (yn == 'N' || yn == 'n') {
					clearConsole();
					homepage();

				}
				break;
		}
		System.out.println("\nAmount : " + amount + "0");

		System.out.print("\nDo you want to place this order (Y/N) : ");
		char yn = scanner.next().charAt(0);

		if (yn == 'Y' || yn == 'y') {
			System.out.println("\n\tOrder Placed...!");

			orderStatus = processing;

			extendArrys();

			System.out.print("\nDo you want to place another order (Y/N) : ");
			char yn1 = scanner.next().charAt(0);

			if (yn1 == 'Y' || yn1 == 'y') {
				clearConsole();
				placeOrder();

			} else if (yn1 == 'N' || yn1 == 'n') {
				clearConsole();
				homepage();

			}

		} else if (yn == 'N' || yn == 'n') {
			clearConsole();
			homepage();

		}

	}

	public static void searchCustomer() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   _____                     _        _____          _                            ");
		System.out.println("  / ____|                   | |      / ____|        | |                           ");
		System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
		System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
		System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
		System.out
				.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println();

		checkOrderID();

	}

	public static void checkOrderID() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter Customer Phone Number : ");
		String phoneNumber = scanner.nextLine();

		int tempXS = 0;
		int tempS = 0;
		int tempM = 0;
		int tempXL = 0;
		int tempXXL = 0;
		int tempL = 0;

		boolean isCorrect = false;

		for (int i = 0; i < phoneNumberArray.length; i++) {

			if (phoneNumber.equals(phoneNumberArray[i])) {

				isCorrect = true;

				if (tShirtSizeArray[i].equals("XS")) {
					tempXS += qtyArray[i];

				} else if (tShirtSizeArray[i].equals("S")) {
					tempS += qtyArray[i];

				} else if (tShirtSizeArray[i].equals("M")) {
					tempM += qtyArray[i];

				} else if (tShirtSizeArray[i].equals("L")) {
					tempL += qtyArray[i];

				} else if (tShirtSizeArray[i].equals("XL")) {
					tempXL += qtyArray[i];

				} else if (tShirtSizeArray[i].equals("XXL")) {
					tempXXL += qtyArray[i];

				}

			}

		}

		if (isCorrect == false) {
			System.out.println("\n\tInvalid Input...");

			System.out.print("\nDo you want to search another customer report (Y/N) : ");
			char yn1 = scanner.next().charAt(0);

			if (yn1 == 'Y' || yn1 == 'y') {
				clearConsole();
				searchCustomer();

			} else if (yn1 == 'N' || yn1 == 'n') {
				clearConsole();
				homepage();

			}

		}

		searchCustomerTable(tempXS, tempS, tempM, tempXL, tempXXL, tempL);

	}

	public static void searchCustomerTable(int tempXS, int tempS, int tempM, int tempXL, int tempXXL, int tempL) {
		Scanner scanner = new Scanner(System.in);

		double tempMAmount = tempM * 900;
		double tempXLAmount = tempXL * 1100;
		double tempXXLAmount = tempXXL * 1200;
		double tempXSAmount = tempXS * 600;
		double tempSAmount = tempS * 800;
		double tempLAmount = tempL * 1000;
		double tempTotalAmount = tempMAmount + tempXLAmount + tempXXLAmount + tempXSAmount + tempSAmount + tempLAmount;

		System.out.printf("\n+-----------+-----------+---------------------+");
		System.out.printf("\n|%10s |%10s |%20s |", "Size", "QTY", "Amount");
		System.out.printf("\n+-----------+-----------+---------------------+");
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "M", tempM, tempMAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "XL", tempXL, tempXLAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "XXL", tempXXL, tempXXLAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "XS", tempXS, tempXSAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "S", tempS, tempSAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n|%10s |%10s |%20.2f |", "L", tempL, tempLAmount);
		System.out.printf("\n|%10s |%10s |%20s |", "", "", "");
		System.out.printf("\n+-----------+-----------+---------------------+");
		System.out.printf("\n|%22s |%20.2f |", "Total Amount", tempTotalAmount);
		System.out.printf("\n+-----------+-----------+---------------------+");

		System.out.print("\nDo you want to search another customer report (Y/N) : ");
		char yn1 = scanner.next().charAt(0);

		if (yn1 == 'Y' || yn1 == 'y') {
			clearConsole();
			searchCustomer();

		} else if (yn1 == 'N' || yn1 == 'n') {
			clearConsole();
			homepage();

		}

	}

	public static void searchOrder() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   _____                     _        ____          _           ");
		System.out.println("  / ____|                   | |      / __ \\        | |          ");
		System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
		System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
		System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("");
		System.out.println("----------------------------------------------------------------");

		System.out.print("\nEnter Order ID : ");
		String orderID = scanner.nextLine();

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else if (orderStatus == 0) {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);

				System.out.print("\nDo you want to search another order (Y/N) : ");
				char yn1 = scanner.next().charAt(0);

				if (yn1 == 'Y' || yn1 == 'y') {
					clearConsole();
					searchOrder();

				} else if (yn1 == 'N' || yn1 == 'n') {
					clearConsole();
					homepage();

				}

			}

		}

	}

	public static void delectOrder() {
		Scanner scanner = new Scanner(System.in);

		boolean delete = false;

		System.out.println("  _____       _      _          ____          _           ");
		System.out.println(" |  __ \\     | |    | |        / __ \\        | |          ");
		System.out.println(" | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
		System.out.println(" | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println(" | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
		System.out.println(" |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("");
		System.out.println("----------------------------------------------------------");

		System.out.print("\nEnter Order ID : ");
		String orderID = scanner.nextLine();

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);

				System.out.print("\nDo you want to delete this order (Y/N) : ");
				char yn = scanner.next().charAt(0);

				if (yn == 'Y' || yn == 'y') {
					delete = true;

					deleteOrderID(i);
					System.out.println("\n\tOrder Deleted...!");

				} else if (yn == 'N' || yn == 'n') {
					clearConsole();
					homepage();

				}
				System.out.print("\nDo you want to delete another order (Y/N) : ");
				char yn1 = scanner.next().charAt(0);

				if (yn1 == 'Y' || yn1 == 'y') {
					clearConsole();
					delectOrder();

				} else if (yn1 == 'N' || yn1 == 'n') {
					clearConsole();
					homepage();

				}

			}

		}
		if (delete == false) {
			System.out.println("\n\tInvalid Order ID...");

			System.out.print("\nDo you want to delete another order (Y/N) : ");
			char yn1 = scanner.next().charAt(0);

			if (yn1 == 'Y' || yn1 == 'y') {
				clearConsole();
				delectOrder();

			} else if (yn1 == 'N' || yn1 == 'n') {
				clearConsole();
				homepage();

			}

		}

	}

	public static void deleteOrderID(int index) {
		String[] deleteOrderIDArray = new String[orderIDArray.length - 1];
		String[] deletePhoneNumberArray = new String[phoneNumberArray.length - 1];
		String[] deleteTShirtSizeArray = new String[tShirtSizeArray.length - 1];
		int[] deleteQTYArray = new int[qtyArray.length - 1];
		double[] deleteAmountArray = new double[amountArray.length - 1];

		for (int i = 0, j = 0; i < orderIDArray.length; i++) {
			if (i != index) {
				deleteOrderIDArray[j] = orderIDArray[i];
				deletePhoneNumberArray[j] = phoneNumberArray[i];
				deleteTShirtSizeArray[j] = tShirtSizeArray[i];
				deleteQTYArray[j] = qtyArray[i];
				deleteAmountArray[j] = amountArray[i];

				j++;
			}
		}

		orderIDArray = deleteOrderIDArray;
		phoneNumberArray = deletePhoneNumberArray;
		tShirtSizeArray = deleteTShirtSizeArray;
		qtyArray = deleteQTYArray;
		amountArray = deleteAmountArray;

	}

	public static void viewReports() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" __      ___                 _____                       _       ");
		System.out.println(" \\ \\    / (_)               |  __ \\                     | |      ");
		System.out.println("  \\ \\  / / _  _____      __ | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("    \\  /  | |  __/\\ V  V /  | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("     \\/   |_|\\___| \\_/\\_/   |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("                                       | |                       ");
		System.out.println("                                       |_|                       ");
		// System.out.println("");
		System.out.println("-----------------------------------------------------------------");

		System.out.println("\n\t[1] Customer Reports");
		System.out.println("\n\t[2] Item Reports");
		System.out.println("\n\t[3] Order Reports");

		System.out.print("\nEnter Option : ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				clearConsole();
				customerReport();
				break;

			case 2:
				clearConsole();
				itemReports();
				break;

			case 3:
				clearConsole();
				orderReports();
				break;

			default:
				break;
		}
	}

	public static void customerReport() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   _____          _                              _____                       _   ");
		System.out.println("  / ____|        | |                            |  __ \\                     | |  ");
		System.out.println(" | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ");
		System.out.println(" | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
		System.out.println(" | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ ");
		System.out
				.println("  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
		System.out.println("                                                           | |                   ");
		System.out.println("                                                           |_|                   ");
		System.out.println("---------------------------------------------------------------------------------");

		System.out.println("\n\t[1] Best in Customers");
		System.out.println("\n\t[2] View Customers");
		System.out.println("\n\t[3] All Customer Reports");

		System.out.print("\nEnter Option : ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				clearConsole();
				bestInCustomers();
				break;

			case 2:
				clearConsole();
				viewCustomers();
				break;

			case 3:
				clearConsole();
				allCustomerReports();
				break;

			default:
				break;
		}
	}

	public static void bestInCustomers() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("  ____            _     _          _____          _                                ");
		System.out.println(" |  _ \\          | |   (_)        / ____|        | |                               ");
		System.out.println(" | |_) | ___  ___| |_   _ _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println(" |  _ < / _ \\/ __| __| | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println(" | |_) |  __/\\__ \\ |_  | | | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out
				.println(" |____/ \\___||___/\\__| |_|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println("-----------------------------------------------------------------------------------");

		String[][] customerData = new String[phoneNumberArray.length][3];
		int uniqueCustomers = 0;

		for (int i = 0; i < phoneNumberArray.length; i++) {
			boolean isNewCustomer = true;
			int customerIndex = -1;
			for (int j = 0; j < uniqueCustomers; j++) {
				if (phoneNumberArray[i].equals(customerData[j][0])) {
					isNewCustomer = false;
					customerIndex = j;
					break;
				}
			}
			if (isNewCustomer) {
				customerData[uniqueCustomers][0] = phoneNumberArray[i];
				customerData[uniqueCustomers][1] = String.valueOf(qtyArray[i]);
				customerData[uniqueCustomers][2] = String.valueOf(amountArray[i]);
				uniqueCustomers++;
			} else {
				customerData[customerIndex][1] = String
						.valueOf(Integer.parseInt(customerData[customerIndex][1]) + qtyArray[i]);
				customerData[customerIndex][2] = String
						.valueOf(Double.parseDouble(customerData[customerIndex][2]) + amountArray[i]);
			}
		}
		for (int i = 0; i < uniqueCustomers - 1; i++) {
			for (int j = 0; j < uniqueCustomers - i - 1; j++) {
				if (Double.parseDouble(customerData[j][2]) < Double.parseDouble(customerData[j + 1][2])) {
					String[] temp = customerData[j];
					customerData[j] = customerData[j + 1];
					customerData[j + 1] = temp;
				}
			}
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");
		System.out.printf("\t| %-13s | %-13s | %-13s |\n", "Customer ID", "All QTY", "Total Amount");
		System.out.printf("\t+---------------+---------------+---------------+\n");

		for (int i = 0; i < uniqueCustomers; i++) {
			System.out.printf("\t|               |               |               |\n");
			System.out.printf("\t| %-13s | %-13s | %-13s |\n", customerData[i][0], customerData[i][1],
					customerData[i][2]);
		}
		System.out.printf("\t+---------------+---------------+---------------+\n");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}
	}

	public static void viewCustomers() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" __      ___                  _____          _                                ");
		System.out.println(" \\ \\    / (_)                / ____|        | |                               ");
		System.out.println("  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println("-----------------------------------------------------------------------------------");

		String[][] customerDetails = new String[phoneNumberArray.length][3];

		for (int i = 0; i < phoneNumberArray.length; i++) {
			String customerID = phoneNumberArray[i];
			int totalQTY = qtyArray[i];
			double totalAmount = amountArray[i];

			boolean exists = false;

			for (int j = 0; j < i; j++) {
				if (phoneNumberArray[i].equals(customerDetails[j][0])) {
					totalQTY += Integer.parseInt(customerDetails[j][1]);
					totalAmount += Double.parseDouble(customerDetails[j][2]);

					customerDetails[j][1] = String.valueOf(totalQTY);
					customerDetails[j][2] = String.valueOf(totalAmount);

					exists = true;
					break;
				}
			}

			if (!exists) {
				customerDetails[i][0] = phoneNumberArray[i];
				customerDetails[i][1] = String.valueOf(qtyArray[i]);
				customerDetails[i][2] = String.valueOf(amountArray[i]);
			}

		}
		System.out.printf("\n\t+----------------------------------------------------------------------+");
		System.out.printf("\n\t|%20s |%15s |%30s |", "Customer ID", "All QTY", "Total Amount");
		System.out.printf("\n\t+---------------------+----------------+-------------------------------+");
		System.out.printf("\n\t|%20s |%15s |%30s |", "", "", "");

		for (int i = 0; i < phoneNumberArray.length; i++) {
			if (customerDetails[i][0] != null) {
				System.out.printf("\n\t|%20s |%15s |%30.2f |", customerDetails[i][0], customerDetails[i][1],
						Double.parseDouble(customerDetails[i][2]));
				System.out.printf("\n\t|%20s |%15s |%30s |", "", "", "");
			}
		}

		System.out.printf("\n\t+----------------------------------------------------------------------+");

		System.out.print("\nTo access the main menu, please enter 0 : ");
		int yn = scanner.nextInt();

		if (yn == 0) {
			clearConsole();
			viewReports();

		}
	}

	public static void allCustomerReports() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"            _ _    _____          _                              _____                       _       ");
		System.out.println(
				"      /\\   | | |  / ____|        | |                            |  __ \\                     | |      ");
		System.out.println(
				"     /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println(
				"    / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(
				"   / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(
				"  /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println(
				"                                                                           | |                       ");
		System.out.println(
				"                                                                           |_|                       ");
		System.out.println(
				"------------------------------------------------------------------------------------------------------");

		String[][] customerData = new String[phoneNumberArray.length][8];
		int uniqueCustomers = 0;

		for (int i = 0; i < phoneNumberArray.length; i++) {
			boolean isNewCustomer = true;
			int customerIndex = -1;

			for (int j = 0; j < uniqueCustomers; j++) {
				if (phoneNumberArray[i].equals(customerData[j][0])) {
					isNewCustomer = false;
					customerIndex = j;
					break;
				}
			}

			if (isNewCustomer) {
				customerData[uniqueCustomers][0] = phoneNumberArray[i];
				for (int k = 1; k <= 6; k++) {
					customerData[uniqueCustomers][k] = "0";
				}
				customerData[uniqueCustomers][7] = "0.0";
				customerIndex = uniqueCustomers;
				uniqueCustomers++;
			}

			int currentQty = Integer.parseInt(customerData[customerIndex][1]);
			if (tShirtSizeArray[i].equalsIgnoreCase("XS")) {
				customerData[customerIndex][1] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][1]) + qtyArray[i]);
			} else if (tShirtSizeArray[i].equalsIgnoreCase("S")) {
				customerData[customerIndex][2] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][2]) + qtyArray[i]);
			} else if (tShirtSizeArray[i].equalsIgnoreCase("M")) {
				customerData[customerIndex][3] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][3]) + qtyArray[i]);
			} else if (tShirtSizeArray[i].equalsIgnoreCase("L")) {
				customerData[customerIndex][4] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][4]) + qtyArray[i]);
			} else if (tShirtSizeArray[i].equalsIgnoreCase("XL")) {
				customerData[customerIndex][5] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][5]) + qtyArray[i]);
			} else if (tShirtSizeArray[i].equalsIgnoreCase("XXL")) {
				customerData[customerIndex][6] = Integer
						.toString(Integer.parseInt(customerData[customerIndex][6]) + qtyArray[i]);
			}

			customerData[customerIndex][7] = Double
					.toString(Double.parseDouble(customerData[customerIndex][7]) + amountArray[i]);
		}

		System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");
		System.out.printf("\t| Phone Number  | XS | S  | M  | L  | XL | XXL |  Total Amount |\n");
		System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");

		for (int i = 0; i < uniqueCustomers; i++) {
			System.out.printf("\t|               |    |    |    |    |    |     |               |\n");
			System.out.printf("\t| %-13s | %-2s | %-2s | %-2s | %-2s | %-2s | %-3s |   %-12.2f|\n",
					customerData[i][0], customerData[i][1], customerData[i][2], customerData[i][3],
					customerData[i][4], customerData[i][5], customerData[i][6], Double.parseDouble(customerData[i][7]));
		}

		System.out.printf("\t+---------------+----+----+----+----+----+-----+---------------+\n");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}
	}

	public static void itemReports() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("  _____ _                   _____                       _       ");
		System.out.println(" |_   _| |                 |  __ \\                     | |      ");
		System.out.println("   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println("   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println("  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(" |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("                                      | |                       ");
		System.out.println("                                      |_|                       ");
		System.out.println("----------------------------------------------------------------");

		System.out.println("\n\t[1] Best Selling Categories Sorted by QTY");
		System.out.println("\n\t[2] Best Selling Categories Sorted by Amount");

		System.out.print("\nEnter Option ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				clearConsole();
				sortedByQTY();
				break;

			case 2:
				clearConsole();
				sortedByAmount();
				break;

			default:
				break;
		}
	}

	public static void sortedByQTY() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   _____            _           _   _              ____ _________     __");
		System.out.println("  / ____|          | |         | | | |            / __ \\__   __\\ \\   / /");
		System.out.println(" | (___   ___  _ __| |_ ___  __| | | |__  _   _  | |  | | | |   \\ \\_/ / ");
		System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | | '_ \\| | | | | |  | | | |    \\   /  ");
		System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   ");
		System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |_.__/ \\__, |  \\___\\_\\ |_|     |_|   ");
		System.out.println("                                           __/ |                        ");
		System.out.println("                                          |___/                         ");
		System.out.println("------------------------------------------------------------------------");

		String[][] qty2DArray = new String[6][3];
		qty2DArray[0][0] = "M";
		qty2DArray[1][0] = "XL";
		qty2DArray[2][0] = "XS";
		qty2DArray[3][0] = "S";
		qty2DArray[4][0] = "XXL";
		qty2DArray[5][0] = "L";

		qty2DArray[0][1] = "0";
		qty2DArray[1][1] = "0";
		qty2DArray[2][1] = "0";
		qty2DArray[3][1] = "0";
		qty2DArray[4][1] = "0";
		qty2DArray[5][1] = "0";

		int Mqty = 0;
		int XLqty = 0;
		int XSqty = 0;
		int Sqty = 0;
		int XXLqty = 0;
		int Lqty = 0;

		double Mtotal = 0;
		double XLtotal = 0;
		double XStotal = 0;
		double Stotal = 0;
		double XXLtotal = 0;
		double Ltotal = 0;

		for (int i = 0; i < phoneNumberArray.length; i++) {
			if (tShirtSizeArray[i].equalsIgnoreCase("M")) {
				Mqty += qtyArray[i];
				qty2DArray[0][1] = String.valueOf(Mqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XL")) {
				XLqty += qtyArray[i];
				qty2DArray[1][1] = String.valueOf(XLqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XS")) {
				XSqty += qtyArray[i];
				qty2DArray[2][1] = String.valueOf(XSqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("S")) {
				Sqty += qtyArray[i];
				qty2DArray[3][1] = String.valueOf(Sqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XXL")) {
				XXLqty += qtyArray[i];
				qty2DArray[4][1] = String.valueOf(XXLqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("L")) {
				Lqty += qtyArray[i];
				qty2DArray[5][1] = String.valueOf(Lqty);

			}
		}

		Mtotal = Mqty * 900.00;
		XLtotal = XLqty * 1100.00;
		XStotal = XSqty * 600.00;
		Stotal = Sqty * 800.00;
		XXLtotal = XXLqty * 1200.00;
		Ltotal = Lqty * 1000.00;

		qty2DArray[0][2] = String.valueOf(Mtotal);
		qty2DArray[1][2] = String.valueOf(XLtotal);
		qty2DArray[2][2] = String.valueOf(XStotal);
		qty2DArray[3][2] = String.valueOf(Stotal);
		qty2DArray[4][2] = String.valueOf(XXLtotal);
		qty2DArray[5][2] = String.valueOf(Ltotal);

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(qty2DArray[j][1]) < Integer.parseInt(qty2DArray[j + 1][1])) {

					int temp = Integer.parseInt(qty2DArray[j + 1][1]);
					qty2DArray[j + 1][1] = qty2DArray[j][1];
					qty2DArray[j][1] = String.valueOf(temp);
				}
			}
		}

		System.out.printf("\n+-----------------------------------------------------------------+");
		System.out.printf("\n|%15s |%15s |%30s |", "Size", "QTY", "Total Amount");
		System.out.printf("\n+----------------+----------------+-------------------------------+");
		System.out.printf("\n|%15s |%15s |%30s |", "", "", "");

		for (int i = 0; i < phoneNumberArray.length; i++) {
			System.out.printf("\n|%15s |%15s |%30.2f |", qty2DArray[i][0], qty2DArray[i][1],
					Double.parseDouble(qty2DArray[i][2]));
			System.out.printf("\n|%15s |%15s |%30s |", "", "", "");
		}

		System.out.printf("\n+-----------------------------------------------------------------+");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}
	}

	public static void sortedByAmount() {
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("   _____            _           _   _                                                  _   ");
		System.out.println(
				"  / ____|          | |         | | | |               /\\                               | |  ");
		System.out.println(
				" | (___   ___  _ __| |_ ___  __| | | |__  _   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println(
				"  \\___ \\ / _ \\| '__| __/ _ \\/ _` | | '_ \\| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println(
				"  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println(
				" |_____/ \\___/|_|   \\__\\___|\\__,_| |_.__/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out
				.println("                                           __/ |                                           ");
		System.out
				.println("                                          |___/                                            ");
		System.out
				.println("-------------------------------------------------------------------------------------------");

		String[][] qty2DArray = new String[6][3];
		qty2DArray[0][0] = "M";
		qty2DArray[1][0] = "XL";
		qty2DArray[2][0] = "XS";
		qty2DArray[3][0] = "S";
		qty2DArray[4][0] = "XXL";
		qty2DArray[5][0] = "L";

		qty2DArray[0][1] = "0";
		qty2DArray[1][1] = "0";
		qty2DArray[2][1] = "0";
		qty2DArray[3][1] = "0";
		qty2DArray[4][1] = "0";
		qty2DArray[5][1] = "0";

		int Mqty = 0;
		int XLqty = 0;
		int XSqty = 0;
		int Sqty = 0;
		int XXLqty = 0;
		int Lqty = 0;

		int Mtotal = 0;
		int XLtotal = 0;
		int XStotal = 0;
		int Stotal = 0;
		int XXLtotal = 0;
		int Ltotal = 0;

		for (int i = 0; i < phoneNumberArray.length; i++) {
			if (tShirtSizeArray[i].equalsIgnoreCase("M")) {
				Mqty += qtyArray[i];
				qty2DArray[0][1] = String.valueOf(Mqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XL")) {
				XLqty += qtyArray[i];
				qty2DArray[1][1] = String.valueOf(XLqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XS")) {
				XSqty += qtyArray[i];
				qty2DArray[2][1] = String.valueOf(XSqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("S")) {
				Sqty += qtyArray[i];
				qty2DArray[3][1] = String.valueOf(Sqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("XXL")) {
				XXLqty += qtyArray[i];
				qty2DArray[4][1] = String.valueOf(XXLqty);

			} else if (tShirtSizeArray[i].equalsIgnoreCase("L")) {
				Lqty += qtyArray[i];
				qty2DArray[5][1] = String.valueOf(Lqty);

			}
		}

		Mtotal = Mqty * 900;
		XLtotal = XLqty * 1100;
		XStotal = XSqty * 600;
		Stotal = Sqty * 800;
		XXLtotal = XXLqty * 1200;
		Ltotal = Lqty * 1000;

		qty2DArray[0][2] = String.valueOf(Mtotal);
		qty2DArray[1][2] = String.valueOf(XLtotal);
		qty2DArray[2][2] = String.valueOf(XStotal);
		qty2DArray[3][2] = String.valueOf(Stotal);
		qty2DArray[4][2] = String.valueOf(XXLtotal);
		qty2DArray[5][2] = String.valueOf(Ltotal);

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(qty2DArray[j][2]) < Integer.parseInt(qty2DArray[j + 1][2])) {

					int temp = Integer.parseInt(qty2DArray[j + 1][2]);
					qty2DArray[j + 1][2] = qty2DArray[j][2];
					qty2DArray[j][2] = String.valueOf(temp);
				}
			}
		}

		System.out.printf("\n+-----------------------------------------------------------------+");
		System.out.printf("\n|%15s |%15s |%30s |", "Size", "QTY", "Total Amount");
		System.out.printf("\n+----------------+----------------+-------------------------------+");
		System.out.printf("\n|%15s |%15s |%30s |", "", "", "");

		for (int i = 0; i < phoneNumberArray.length; i++) {
			System.out.printf("\n|%15s |%15s |%30.2f |", qty2DArray[i][0], qty2DArray[i][1],
					Double.parseDouble(qty2DArray[i][2]));
			System.out.printf("\n|%15s |%15s |%30s |", "", "", "");
		}

		System.out.printf("\n+-----------------------------------------------------------------+");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}
	}

	public static void orderReports() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   ____          _             _____                       _       ");
		System.out.println("  / __ \\        | |           |  __ \\                     | |      ");
		System.out.println(" | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
		System.out.println(" | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(" | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println("                                         | |                       ");
		System.out.println("                                         |_|                       ");
		System.out.println("-------------------------------------------------------------------");

		System.out.println("\n\t[1] All Orders");
		System.out.println("\n\t[2] Orders by Amount");

		System.out.print("\nEnter Option : ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				clearConsole();
				allOrders();
				break;

			case 2:
				clearConsole();
				ordersByAmount();
				break;

			default:
				break;
		}
	}

	public static void allOrders() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" __      ___                  ____          _               ");
		System.out.println(" \\ \\    / (_)                / __ \\        | |              ");
		System.out.println("  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
		System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
		System.out.println("    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
		System.out.println("     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
		System.out.println("------------------------------------------------------------");

		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");
		System.out.printf("\n|%15s |%15s |%10s |%10s |%15s |%15s |", "Order ID", "Customer ID", "Size", "QTY", "Amount",
				"Status");
		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");
		System.out.printf("\n|%15s |%15s |%10s |%10s |%15s |%15s |", "", "", "", "", "", "");

		for (int i = phoneNumberArray.length - 1; i >= 0; i--) {
			System.out.printf("\n|%15s |%15s |%10s |%10s |%15.2f |%15s |", orderIDArray[i], phoneNumberArray[i],
					tShirtSizeArray[i].toUpperCase(), qtyArray[i], amountArray[i], "");
			System.out.printf("\n|%15s |%15s |%10s |%10s |%15s |%15s |", "", "", "", "", "", "");
		}

		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}
	}

	public static void ordersByAmount() {
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("   ____          _                 ____                                               _   ");
		System.out.println(
				"  / __ \\        | |               |  _ \\            /\\                               | |  ");
		System.out
				.println(" | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
		System.out.println(
				" | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println(
				" | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
		System.out.println(
				"  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out
				.println("                                          __/ |                                           ");
		System.out
				.println("                                         |___/                                            ");
		System.out
				.println("------------------------------------------------------------------------------------------");

		for (int i = phoneNumberArray.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (amountArray[j] < amountArray[j + 1]) {
					double temp = amountArray[j];
					amountArray[j] = amountArray[j + 1];
					amountArray[j + 1] = temp;

					String tempOrderID = orderIDArray[j];
					orderIDArray[j] = orderIDArray[j + 1];
					orderIDArray[j + 1] = tempOrderID;

					String tempCustomerID = phoneNumberArray[j];
					phoneNumberArray[j] = phoneNumberArray[j + 1];
					phoneNumberArray[j + 1] = tempCustomerID;

					String tempSize = tShirtSizeArray[j];
					tShirtSizeArray[j] = tShirtSizeArray[j + 1];
					tShirtSizeArray[j + 1] = tempSize;

					int tempQTY = qtyArray[j];
					qtyArray[j] = qtyArray[j + 1];
					qtyArray[j + 1] = tempQTY;
				}
			}
		}

		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");
		System.out.printf("\n|%15s |%15s |%10s |%10s |%15s |%15s |", "Order ID", "Customer ID", "Size", "QTY", "Amount",
				"Status");
		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");

		for (int i = 0; i < phoneNumberArray.length; i++) {
			System.out.printf("\n|%15s |%15s |%10s |%10s |%15.2f |%15s |", orderIDArray[i], phoneNumberArray[i],
					tShirtSizeArray[i].toUpperCase(), qtyArray[i], amountArray[i], "");
			System.out.printf("\n|%15s |%15s |%10s |%10s |%15s |%15s |", "", "", "", "", "", "");
		}

		System.out.printf(
				"\n+----------------+----------------+-----------+-----------+----------------+----------------+");

		System.out.print("\nTo access the main Menu, please enter 0 : ");
		int toMenuInput = scanner.nextInt();

		if (toMenuInput == 0) {
			clearConsole();
			homepage();
		}

	}

	public static void setOrderStatus() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("   ____          _              _____ _        _             ");
		System.out.println("  / __ \\        | |            / ____| |      | |            ");
		System.out.println(" | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
		System.out.println(" | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
		System.out.println(" | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
		System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
		System.out.println("-------------------------------------------------------------");

		System.out.print("\nEnter Order ID : ");
		String orderID = scanner.nextLine();

		boolean isExit = false;

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				isExit = true;

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);
			}
		}

		if (!isExit) {
			System.out.println("\nThere is no order with this Order ID...");

			System.out.print("\nDo you want to enter Order ID again (Y/N) : ");
			char yn1 = scanner.next().charAt(0);

			if (yn1 == 'Y' || yn1 == 'y') {
				clearConsole();
				setOrderStatus();
			} else {
				clearConsole();
				homepage();
			}
		}

		System.out.print("\n\nDo you want to change this order status? (Y/N) : ");
		char yn = scanner.next().charAt(0);

		if (yn == 'Y' || yn == 'y') {
			System.out.println("\n\t[1] Order Delivering");
			System.out.println("\n\t[2] Order Delivered");

			System.out.print("\nEneter Option : ");
			int option = scanner.nextInt();

			switch (option) {
				case 1:
					clearConsole();
					orderDelivering(orderID);
					break;

				case 2:
					clearConsole();
					orderDelivered1(orderID);
					break;

				default:
					break;
			}
		}
	}

	public static void orderDelivering(String orderID) {
		Scanner scanner = new Scanner(System.in);

		orderStatus = 1;

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);
			}
		}

		System.out.print("\n\nDo you want to change this order status? (Y/N) : ");
		char yn = scanner.next().charAt(0);

		if (yn == 'Y' || yn == 'y') {
			System.out.println("\n\t[1] Order Delivered");

			System.out.print("\nEneter Option : ");
			int option = scanner.nextInt();

			switch (option) {
				case 1:
					clearConsole();
					orderDelivered(orderID);
					break;

				default:
					break;
			}
		}
	}

	public static void orderDelivered(String orderID) {
		Scanner scanner = new Scanner(System.in);

		orderStatus = 2;

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);
			}
		}

		System.out.println("\n\tCan't change this order status, Order already delivered...!");

		System.out.print("\n\nDo you want to change this order status? (Y/N) : ");
		char yn = scanner.next().charAt(0);

		if (yn == 'Y' || yn == 'y') {
			clearConsole();
			setOrderStatus();
		} else {
			clearConsole();
			homepage();
		}
	}

	public static void orderDelivered1(String orderID) {
		Scanner scanner = new Scanner(System.in);

		orderStatus = 2;

		for (int i = 0; i < orderIDArray.length; i++) {

			if (orderID.equals(orderIDArray[i])) {
				System.out.println("\nPhone Number : " + phoneNumberArray[i]);
				System.out.println("\nSize         : " + tShirtSizeArray[i]);
				System.out.println("\nQTY          : " + qtyArray[i]);
				System.out.println("\nAmount       : " + amountArray[i]);

				String status = "";

				if (orderStatus == 1) {
					status = "Delivering";

				} else if (orderStatus == 2) {
					status = "Delivered";

				} else {
					status = "Processing";

				}
				System.out.println("\nStatus       : " + status);
			}
		}

		System.out.println("\n\tCan't change this order status, Order already delivered...!");

		System.out.print("\n\nDo you want to change this order status? (Y/N) : ");
		char yn = scanner.next().charAt(0);

		if (yn == 'Y' || yn == 'y') {
			clearConsole();
			setOrderStatus();
		} else {
			clearConsole();
			homepage();
		}
	}
}
