package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {

        /**
         * Creates a menu
         *
         */
        System.out.println(" Currency to buy: not set");
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

                String inputValue = menuInput.nextLine();

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
                        wrongInput = false;
                        System.out.println("You have terminated the currency converter!");

                        System.exit(0);
                    default:
                        System.err.println("Not a valid option!");
                        wrongInput = true;
                }


            } while (wrongInput == true);

        }


        System.out.print("Enter a currency's name or a part of it(>>xxx<< to exit): ");

        try (Scanner secondMenuInput = new Scanner(System.in)) {

            //Read file and return content as Array
            TextFileReader tfr = new TextFileReader();
            tfr.readFile("Currencies.txt");

            String inputValue = secondMenuInput.nextLine();

            //TODO: How to search through the Array for the inputValue and print out the found currencies?

        } catch (IOException e) {
            System.err.println("File not found!");
        }


    }

}