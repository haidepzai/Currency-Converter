package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {

        //TODO: ---------------------------------------------------------------------
        //TODO: Reduce nesting in the main-method by creating new classes and methods
        //TODO: ---------------------------------------------------------------------

        /**
         * Creates a menu
         *
         */
        boolean wrongInput = false;
        String setCurrencyToBuy = "not set";
        String setCurrencyToSell = "not set";

        try (Scanner menuInput = new Scanner(System.in)) {


            /**
             * do-while loop for the menu selection
             *
             */

            do {
                System.out.println(" Currency to buy: " + setCurrencyToBuy);
                System.out.println("Currency to sell: " + setCurrencyToSell);
                System.out.println("+++++++++++++++++++++++++");
                System.out.println("0: Select currency to buy");
                System.out.println("1: Select currency to sell");
                System.out.println("2: Select amount to be converted");
                System.out.println("\n");
                System.out.print("Please choose an option (>>x<< to exit): ");

                String inputValue = menuInput.next();

                switch (inputValue) {

                    case "0":
                        wrongInput = false;
                        break;
                    case "1":
                        wrongInput = false;
                        break;
                    case "2":
                        wrongInput = false;
                        break;
                    case "x":
                        System.out.println("You have terminated the currency converter!");
                        System.exit(0);
                    default:
                        System.err.println("Not a valid option! Try again!");
                        wrongInput = true;
                        break;
                }

            } while (wrongInput == true);

            do {

                System.out.print("Enter a currency's name or part of it(>>xxx<< to exit): ");
                String buy = menuInput.next();

                if (buy.equals("xxx")) {
                    System.out.println("You have terminated the currency converter!");
                    System.exit(0);
                } else {
                    //Read file and return content as Array
                    TextFileReader tfr = new TextFileReader();
                    tfr.readFile("Currencies.txt");

                    //Currencies which contain the entered String will be output
                    //TODO: Too much references? Put this stuff back to TextFileReader-class?

                    System.out.println("\n Currency to buy: " + setCurrencyToBuy);
                    System.out.println("Currency to sell: " + setCurrencyToSell);
                    System.out.println("+++++++++++++++++++++++++");

                    int t = 0;
                    for (int i = 0; i < tfr.currArray.length; i++) {
                        if (tfr.currArray[i].toLowerCase().contains(buy.toLowerCase())) {
                            System.out.println(t + ": " + tfr.getCurrencyName(tfr.currArray[i]));
                            t++;
                        }
                    }
                    if (t == 0) {
                        System.err.println("No suitable currencies found! Try again!\n");
                        wrongInput = true;
                    } else {
                        System.out.println("\n");
                        System.out.println("Select a currency by index: ");
                        wrongInput = false;
                        //TODO: Overwrite setCurrencyToBuy or setCurrencyToSell with the selected currency
                    }
                }

            } while (wrongInput == true);


        } catch (IOException e) {
            System.err.println("Currencies.txt-file not found!");
        }
    }
}