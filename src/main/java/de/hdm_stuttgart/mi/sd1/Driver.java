package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {

        /**
         * Creates a menu
         *
         */
        System.out.println("Currency to buy: not set");
        System.out.println("Currency to sell: not set");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("0: Select currency to buy");
        System.out.println("1: Select currency to sell");
        System.out.println("2: Select amount to be converted");
        System.out.println("\n");


        try (Scanner menuInput = new Scanner(System.in)) {


            /**
             * do-while loop for the menu selection
             *
             */

            boolean wrongInput = false;

            do {

                System.out.print("Please choose an option (>>x<< to exit): ");

                String inputValue = menuInput.next();

                switch (inputValue) {

                    case "0":
                        wrongInput = false;
                        System.out.print("Enter a currency's name or a part of it(>>xxx<< to exit): ");
                        String buy = menuInput.next();

                        //Read file and return content as Array
                        TextFileReader tfr = new TextFileReader();
                        tfr.readFile("Currencies.txt");

                        //Currencies which contain the entered String will be output
                        //TODO: Too much references? Put this stuff back to TextFileReader-class?

                        int t = 0;
                        for (int i = 0; i < tfr.currArray.length; i++) {
                            if (tfr.currArray[i].toLowerCase().contains(buy.toLowerCase())) {
                                System.out.println(t + ": " + tfr.getCurrencyName(tfr.currArray[i]));
                                t++;
                            }
                        }
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
                        System.err.println("Not a valid option!");
                        wrongInput = true;
                        break;
                }

            } while (wrongInput == true);

        } catch (IOException i) {
            System.err.println("Currencies.txt-file not found!");
        }
    }
}