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
         *
         */

        TextFileReader tfr = new TextFileReader();
        SplitArray splitArray = new SplitArray();
        ArraySearch arraySearch = new ArraySearch();


        boolean wrongInput = false;

        try (Scanner menuInput = new Scanner(System.in)) {


            /**
             * do-while loop for the menu selection
             *
             */
            while (true) {

                do {

                    if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {
                        toBuy1 = "Buying " + amountToBuy + " of ";
                        toSell1 = "Selling " + amountToSell + " of ";
                    }

                    System.out.println(toBuy1 + toBuy2);
                    System.out.println(toSell1 + toSell2);
                    System.out.println("+++++++++++++++++++++++++");
                    System.out.println("0: Select currency to buy");
                    System.out.println("1: Select currency to sell");
                    System.out.println("2: Select amount to be converted");
                    System.out.println("\n");
                    System.out.print("Please choose an option (>>x<< to exit): ");

                    String inputValue = menuInput.next();

                    switch (inputValue) {

                        //Select currencies to buy/sell
                        case "0":
                        case "1":

                            do {
                                System.out.print("Enter a currency's name or part of it(>>xxx<< to exit): ");
                                String enteredName = menuInput.next();

                                if (enteredName.equals("xxx")) {
                                    System.out.println("You have terminated the currency converter!");
                                    System.exit(0);
                                } else {
                                    //Read file and return content as Array

                                    String[] currArray = tfr.readFile("Currencies.txt");

                                    /**
                                     * Search in the currArray for currencies which contain the entered String
                                     */

                                    foundArray = arraySearch.searchEnteredName(enteredName, currArray);

                                    if (arraySearch.nC == 0) {
                                        System.err.println("No suitable currencies found! Try again!\n");
                                        wrongInput = true;

                                        //If just one currency found
                                    } else if (arraySearch.nC == 1) {
                                        if (inputValue.equals("0")) {
                                            buyCurrency = foundArray[0];
                                            toBuy2 = splitArray.getCurrencyName(buyCurrency);

                                        } else if (inputValue.equals("1")) {
                                            sellCurrency = foundArray[0];
                                            toSell2 = splitArray.getCurrencyName(sellCurrency);
                                        }

                                        System.out.println("\n");

                                        if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {
                                            toBuy1 = "Buying " + amountToBuy + " of ";
                                            toSell1 = "Selling " + amountToSell + " of ";
                                        }

                                        wrongInput = false;

                                        //If more than one currency is found
                                    } else if (arraySearch.nC >= 2) {
                                        System.out.println("\n" + toBuy1 + toBuy2);
                                        System.out.println(toSell1 + toSell2);
                                        System.out.println("+++++++++++++++++++++++++");

                                        //Print out the Array of found currencies
                                        int t = 0;
                                        for (String fA : foundArray) {
                                            System.out.println(t + ": " + splitArray.getCurrencyName(fA));
                                            t++;
                                        }

                                        do {
                                            System.out.println("\n");
                                            System.out.print("Select a currency by index: ");
                                            Boolean validTest = true;
                                            do {
                                                try {

                                                    int selectCurrency = menuInput.nextInt();

                                                    //Overwrite "Currency to buy/sell" with the selected currency
                                                    try {
                                                        if (inputValue.equals("0")) {
                                                            buyCurrency = foundArray[selectCurrency];
                                                            toBuy2 = splitArray.getCurrencyName(buyCurrency);
                                                        } else if (inputValue.equals("1")) {
                                                            sellCurrency = foundArray[selectCurrency];
                                                            toSell2 = splitArray.getCurrencyName(sellCurrency);
                                                        }

                                                        System.out.println("\n");

                                                        if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {
                                                            toBuy1 = "Buying " + amountToBuy + " of ";
                                                            toSell1 = "Selling " + amountToSell + " of ";
                                                        }


                                                        wrongInput = false;
                                                    } catch (IndexOutOfBoundsException b) {
                                                        System.err.println("Your index was too high!");
                                                        wrongInput = true;
                                                    }
                                                    validTest = false;


                                                } catch (InputMismatchException i) {
                                                    System.out.println("Not a valid Number!\nTry again.");
                                                    validTest = true;
                                                    menuInput.next();
                                                }

                                            } while (validTest);
                                        } while (wrongInput);
                                    }

                                }

                            } while (wrongInput);


                            wrongInput = false;
                            break;

                        //Select an amount which shall be converted
                        case "2":
                            Boolean validTest = true;
                            CurrencyManager currencyManager = new CurrencyManager();
                            if(currencyManager.checkCurrencies(buyCurrency,sellCurrency))
                                break;
                            else {
                                do {
                                    try {
                                        System.out.print("Enter an amount: ");

                                        double amount = menuInput.nextDouble();

                                        System.out.println("\n");

                                        Calculator calc = new Calculator();


                                        double buyVal = splitArray.getCurrencyValue(buyCurrency);
                                        double sellVal = splitArray.getCurrencyValue(sellCurrency);


                                        amountToBuy = Math.round(amount * 100D) / 100D;
                                        amountToSell = calc.convertingAmount(amount, buyVal, sellVal);

                                        wrongInput = false;
                                        validTest = false;


                                    } catch (InputMismatchException i) {
                                        System.out.println("Not a valid amount");
                                        validTest = true;
                                        menuInput.next();

                                    }

                                } while (validTest);

                                break;
                            }

                            //Exit the currency converter
                        case "x":
                            System.out.println("You have terminated the currency converter!");
                            System.exit(0);

                        default:
                            System.err.println("Not a valid option! Try again!");
                            wrongInput = true;
                            break;

                    }

                } while (wrongInput == true);

            }

        } catch (IOException i) {
            System.err.println("Currencies.txt-file not found!");
        }
    }
}


