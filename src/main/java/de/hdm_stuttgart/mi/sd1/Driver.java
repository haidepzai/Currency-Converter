package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        try (Scanner menuInput = new Scanner(System.in)) {
            ScreenCleaner.clearScreen();

            //Endless loop to allow unlimited changes until break/exit
            while (true) {

                CurrencyManager.setMenuOutput();

                //Flexible/Changeable user-menu
                System.out.println(CurrencyManager.toBuy1 + CurrencyManager.toBuy2);
                System.out.println(CurrencyManager.toSell1 + CurrencyManager.toSell2);
                System.out.println("+++++++++++++++++++++++++");
                System.out.println("0: Select currency to buy");
                System.out.println("1: Select currency to sell");
                System.out.println("2: Select amount to be converted\n");
                System.out.print("Please choose an option (>>x<< to exit): ");

                String optionMode = menuInput.next();

                switch (optionMode) {

                    //Select currencies to buy/sell
                    case "0":
                    case "1":

                        //Endless loop => break, if input is true, otherwise not
                        while (true) {
                            System.out.print("Enter a currency's name or part of it(>>xxx<< to exit): ");
                            String enteredName = menuInput.next();
                            System.out.println();

                            //Leave currency converter
                            if (enteredName.equals("xxx")) {
                                System.out.println("You have terminated the currency converter!");
                                System.exit(0);

                            } else {
                                //Read file and return content as Array
                                String[] currencyArray = TextFileReader.readFile("Currencies.txt");

                                //Search through the Array for the entered String from the user
                                ArrayManager.foundArray = ArrayManager.searchEnteredName(enteredName, currencyArray);

                                //Depending on how much currencies found => different further actions
                                // 1) If no currency found
                                if (ArrayManager.nC == 0) {
                                    System.out.println("No suitable currencies found! Try again!\n");

                                    // 2) If just one currency found => found currencies directly added to menu output
                                } else if (ArrayManager.nC == 1) {
                                    CurrencyManager.setCurrency(optionMode, ArrayManager.foundArray[0]);
                                    ScreenCleaner.clearScreen();
                                    break;

                                    // 3) If more than one currency is found
                                } else if (ArrayManager.nC >= 2) {
                                    ScreenCleaner.clearScreen();
                                    System.out.println(CurrencyManager.toBuy1 + CurrencyManager.toBuy2);
                                    System.out.println(CurrencyManager.toSell1 + CurrencyManager.toSell2);
                                    System.out.println("+++++++++++++++++++++++++");

                                    //Print out the Array of found currencies
                                    int t = 0;
                                    for (String fA : ArrayManager.foundArray) {
                                        System.out.println(t + ": " + ArrayManager.getCurrencyName(fA));
                                        t++;
                                    }

                                    //Selection of the found currencies
                                    while (true) {
                                        System.out.print("\nSelect a currency by index: ");

                                        try {
                                            int selectIndex = menuInput.nextInt();
                                            CurrencyManager.setCurrency(optionMode, ArrayManager.foundArray[selectIndex]);

                                            System.out.println("\n");
                                            ScreenCleaner.clearScreen();
                                            break;

                                        } catch (IndexOutOfBoundsException e) {
                                            System.err.println("\nYour index is too high! Try again!");
                                        } catch (InputMismatchException e) {
                                            System.err.println("\nNot a valid Number! Try again!");
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
                        if (CurrencyManager.checkCurrencies(CurrencyManager.buyCurrency, CurrencyManager.sellCurrency))
                            break;
                        else {
                            while (true) {
                                try {
                                    System.out.print("Enter an amount: ");
                                    double amount = menuInput.nextDouble();
                                    System.out.println();
                                    ScreenCleaner.clearScreen();

                                    //Flexible/Changeable user-menu
                                    double buyVal = ArrayManager.getCurrencyValue(CurrencyManager.buyCurrency);
                                    double sellVal = ArrayManager.getCurrencyValue(CurrencyManager.sellCurrency);

                                    //Set amount to sell/buy for the representation in the menu
                                    CurrencyManager.amountToBuy = Calculator.setAmountToBuy(amount);
                                    CurrencyManager.amountToSell = Calculator.convertingAmount(amount, buyVal, sellVal);

                                    break;

                                } catch (InputMismatchException e) {
                                    System.err.println("\nNot a valid amount! Try again!\n");
                                    menuInput.next();
                                }
                            }

                            break;
                        }

                    //Exit the currency converter
                    case "x":
                        System.out.println("You have terminated the currency converter!");
                        System.exit(0);

                    //Instantly wrong input leads to default-case
                    default:
                        ScreenCleaner.clearScreen();
                        System.err.println("Not a valid option! Try again!\n");
                        break;
                }
            }

        } catch (IOException e) {
            System.err.println("Currencies.txt-file not found!");
        }

        ScreenCleaner.clearScreen();
    }

}