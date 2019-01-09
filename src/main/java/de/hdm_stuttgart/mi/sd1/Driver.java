package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                                String buy = menuInput.next();

                                if (buy.equals("xxx")) {
                                    System.out.println("You have terminated the currency converter!");
                                    System.exit(0);
                                } else {
                                    //Read file and return content as Array

                                    tfr.readFile("Currencies.txt");

                                    /**
                                     * Search in the currArray for currencies which contain the entered String
                                     */

                                    int nC = 0; //nC: Variable for the number of found currencies
                                    List<String> foundCurrencies = new ArrayList<>();

                                    for (int i = 0; i < tfr.currArray.length; i++) {
                                        if (tfr.currArray[i].toLowerCase().contains(buy.toLowerCase())) {
                                            foundCurrencies.add(tfr.currArray[i]);
                                            nC++;
                                        }
                                    }
                                    String[] foundArray = foundCurrencies.toArray(new String[0]);

                                    //If no currency found
                                    if (nC == 0) {
                                        System.err.println("No suitable currencies found! Try again!\n");
                                        wrongInput = true;

                                        //If just one currency found
                                    } else if (nC == 1) {
                                        if (inputValue.equals("0")) {
                                            buyCurrency = foundCurrencies.get(0);
                                            toBuy2 = splitArray.getCurrencyName(buyCurrency);

                                        } else if (inputValue.equals("1")) {
                                            sellCurrency = foundCurrencies.get(0);
                                            toSell2 = splitArray.getCurrencyName(sellCurrency);
                                        }

                                        System.out.println("\n");

                                        if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {
                                            toBuy1 = "Buying " + amountToBuy + " of ";
                                            toSell1 = "Selling " + amountToSell + " of ";
                                        }

                                        wrongInput = false;

                                        //If more than one currency is found
                                    } else {
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
                                                                                            //Todo: Try-Catch anstatt regex
                                                String validCurrency = menuInput.next();
                                                if (validCurrency.matches("[0-9]+$") && validCurrency.length() > 0){

                                                    int selectCurrency = Integer.parseInt(validCurrency);

                                                    //Overwrite "Currency to buy/sell" with the selected currency
                                                    try {
                                                        if (inputValue.equals("0")) {
                                                            buyCurrency = foundCurrencies.get(selectCurrency);
                                                            toBuy2 = splitArray.getCurrencyName(buyCurrency);
                                                        } else if (inputValue.equals("1")) {
                                                            sellCurrency = foundCurrencies.get(selectCurrency);
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
                                                } else {

                                                    System.out.println("Not a valid Number!\nTry again.");

                                                }


                                            } while(validTest == true);

                                        }while (wrongInput == true);
                                    }

                                }

                            } while (wrongInput == true);


                            wrongInput = false;
                            break;

                        //Select an amount which shall be converted
                        case "2":      //Todo: Try-Catch anstatt regex
                            Boolean validTest = true;
                            if(buyCurrency == null) {
                                System.out.println("\nYou have to select a currency to buy first!\n");

                            }else if (sellCurrency == null) {

                                System.out.println("\nYou have to select a currency to sell first!\n");

                            }
                            if (buyCurrency == null && sellCurrency == null) {

                               System.out.println("\nYou have to select a currency to buy and to sell first!\n");
                                    break;
                            } else {
                                do {
                                    System.out.print("Enter an amount: ");

                                    String validAmount = menuInput.next();

                                    if (validAmount.matches("^[0-9]+[.]?[0-9]*$") && validAmount.length() > 0) {

                                        double amount = Double.parseDouble(validAmount);

                                        System.out.println("\n");

                                        Calculator calc = new Calculator();

                                        double buyVal = Double.parseDouble(splitArray.getCurrencyValue(buyCurrency));
                                        double sellVal = Double.parseDouble(splitArray.getCurrencyValue(sellCurrency));

                                        amountToBuy = amount;
                                        amountToSell = calc.convertingAmount(amount, buyVal, sellVal);

                                        wrongInput = false;
                                        validTest = false;
                                    } else {
                                        System.out.println("Not a valid amount");
                                    }

                                } while (validTest == true);

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


