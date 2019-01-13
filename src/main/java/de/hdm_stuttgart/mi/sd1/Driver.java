package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

    static String toBuy1 = " Currency to buy: ";
    static String toSell1 = "Currency to sell: ";
    static String toBuy2 = "not set";
    static String toSell2 = "not set";
    static double amountToBuy = 0;
    static double amountToSell = 0;

    static String buyCurrency;
    static String sellCurrency;

    static String[] foundArray;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        //TODO: ---------------------------------------------------------------------
        //TODO: Reduce nesting in the main-method by creating new classes and methods
        //TODO: ---------------------------------------------------------------------

        /**
         * Creates a menu
         */

        try (Scanner menuInput = new Scanner(System.in)) {


            /**
             * do-while loop for the menu selection
             */
            while (true) {

                if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {
                    toBuy1 = "Buying " + amountToBuy + " of ";
                    toSell1 = "Selling " + amountToSell + " of ";
                }

                System.out.println("\n" + toBuy1 + toBuy2);
                System.out.println(toSell1 + toSell2);
                System.out.println("+++++++++++++++++++++++++");
                System.out.println("0: Select currency to buy");
                System.out.println("1: Select currency to sell");
                System.out.println("2: Select amount to be converted\n\n");
                System.out.print("Please choose an option (>>x<< to exit): ");

                String inputValue = menuInput.next();

                switch (inputValue) {

                    //Select currencies to buy/sell
                    case "0":
                    case "1":

                        while (true) {
                            System.out.print("Enter a currency's name or part of it(>>xxx<< to exit): ");
                            String enteredName = menuInput.next();

                            if (enteredName.equals("xxx")) {
                                System.out.println("You have terminated the currency converter!");
                                System.exit(0);

                            } else {
                                //Read file and return content as Array

                                String[] currArray = TextFileReader.readFile("Currencies.txt");

                                /**
                                 * Search in the currArray for currencies which contain the entered String
                                 */

                                foundArray = ArraySearch.searchEnteredName(enteredName, currArray);

                                //No currency found
                                if (ArraySearch.nC == 0) {
                                    System.err.println("No suitable currencies found! Try again!");

                                    //If just one currency found
                                } else if (ArraySearch.nC == 1) {

                                    //Currency to buy selected ("0")=> found currency added as currency to buy
                                    if (inputValue.equals("0")) {
                                        buyCurrency = foundArray[0];
                                        toBuy2 = SplitArray.getCurrencyName(buyCurrency);

                                        //Currency to sell selected ("1") => found currency added as currency to sell
                                    } else if (inputValue.equals("1")) {
                                        sellCurrency = foundArray[0];
                                        toSell2 = SplitArray.getCurrencyName(sellCurrency);
                                    }

                                    break;

                                    //If more than one currency is found
                                } else if (ArraySearch.nC >= 2) {
                                    System.out.println("\n" + toBuy1 + toBuy2);
                                    System.out.println(toSell1 + toSell2);
                                    System.out.println("+++++++++++++++++++++++++");

                                    //Print out the Array of found currencies
                                    int t = 0;
                                    for (String fA : foundArray) {
                                        System.out.println(t + ": " + SplitArray.getCurrencyName(fA));
                                        t++;
                                    }

                                    while (true) {
                                        System.out.println("\n");
                                        System.out.print("Select a currency by index: ");

                                        try {

                                            int selectCurrency = menuInput.nextInt();

                                            //Overwrite "Currency to buy/sell" with the selected currency
                                            if (inputValue.equals("0")) {
                                                buyCurrency = foundArray[selectCurrency];
                                                toBuy2 = SplitArray.getCurrencyName(buyCurrency);
                                            } else if (inputValue.equals("1")) {
                                                sellCurrency = foundArray[selectCurrency];
                                                toSell2 = SplitArray.getCurrencyName(sellCurrency);
                                            }

                                            System.out.println("\n");
                                            break;

                                        } catch (IndexOutOfBoundsException i) {
                                            System.err.println("Your index is too high! Try again!");
                                        } catch (InputMismatchException i) {
                                            System.err.println("Not a valid Number!Try again!");
                                            menuInput.next();
                                        }
                                    }

                                    break;
                                }

                            }
                        }

                        break;

                        //Select an amount which shall be converted
                        case "2":
                            CurrencyManager currencyManager = new CurrencyManager();
                            if (currencyManager.checkCurrencies(buyCurrency, sellCurrency))
                                break;
                            else {
                                while (true) {
                                    try {
                                        System.out.print("Enter an amount: ");

                                        double amount = menuInput.nextDouble();

                                        System.out.println("\n");

                                    double buyVal = SplitArray.getCurrencyValue(buyCurrency);
                                    double sellVal = SplitArray.getCurrencyValue(sellCurrency);

                                    amountToBuy = Calculator.setAmountToBuy(amount);
;                                   amountToSell = Calculator.convertingAmount(amount, buyVal, sellVal);

                                    break;

                                } catch (InputMismatchException i) {
                                    System.out.println("Not a valid amount! Try again!");
                                    menuInput.next();
                                }
                            }

                            break;
                        }

                        //Exit the currency converter
                    case "x":
                        System.out.println("You have terminated the currency converter!");
                        System.exit(0);

                    default:
                        System.err.println("Not a valid option! Try again!");
                        break;
                }
            }

        } catch (IOException i) {
            System.err.println("Currencies.txt-file not found!");
        }
    }
}
