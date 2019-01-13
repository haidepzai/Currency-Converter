package de.hdm_stuttgart.mi.sd1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {
    static double amountToBuy = 0;
    static double amountToSell = 0;

    static String[] foundArray;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        CurrencyManager currencyManager = new CurrencyManager();

        try (Scanner menuInput = new Scanner(System.in)) {

            //Endless loop to allow unlimited changes until break/exit
            while (true) {

                //If both currencies are set => change the menu output
                if (!CurrencyManager.toBuy2.equals("not set") && !CurrencyManager.toSell2.equals("not set")) {
                    CurrencyManager.toBuy1 = "Buying " + amountToBuy + " of ";
                    CurrencyManager.toSell1 = "Selling " + amountToSell + " of ";
                }
                //Flexible/Changeable user-menu
                System.out.println("\n" + CurrencyManager.toBuy1 + CurrencyManager.toBuy2);
                System.out.println(CurrencyManager.toSell1 + CurrencyManager.toSell2);
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

                        //Endless loop => break, if input is true, otherwise not
                        while (true) {
                            System.out.print("Enter a currency's name or part of it(>>xxx<< to exit): ");
                            String enteredName = menuInput.next();

                            //Leave currency converter
                            if (enteredName.equals("xxx")) {
                                System.out.println("You have terminated the currency converter!");
                                System.exit(0);

                            } else {
                                //Read file and return content as Array
                                String[] currArray = TextFileReader.readFile("Currencies.txt");

                                //Search through the Array for the entered String from the user
                                foundArray = ArraySearch.searchEnteredName(enteredName, currArray);

                                //If no currency found
                                if (ArraySearch.nC == 0) {
                                    System.err.println("No suitable currencies found! Try again!");

                                //If just one currency found => found currencies directly added to menu output
                                } else if (ArraySearch.nC == 1) {
                                    currencyManager.setCurrency(inputValue, foundArray[0]);
                                    break;

                                //If more than one currency is found
                                } else if (ArraySearch.nC >= 2) {
                                    System.out.println("\n" + CurrencyManager.toBuy1 + CurrencyManager.toBuy2);
                                    System.out.println(CurrencyManager.toSell1 + CurrencyManager.toSell2);
                                    System.out.println("+++++++++++++++++++++++++");

                                    //Print out the Array of found currencies
                                    int t = 0;
                                    for (String fA : foundArray) {
                                        System.out.println(t + ": " + SplitArray.getCurrencyName(fA));
                                        t++;
                                    }

                                    //Selection of the found currencies
                                    while (true) {
                                        System.out.println("\n");
                                        System.out.print("Select a currency by index: ");

                                        try {
                                            int selectCurrency = menuInput.nextInt();
                                            currencyManager.setCurrency(inputValue, foundArray[selectCurrency]);

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

                        if (currencyManager.checkCurrencies(CurrencyManager.buyCurrency, CurrencyManager.sellCurrency))
                            break;
                        else {
                            while (true) {
                                try {
                                    System.out.print("Enter an amount: ");

                                    double amount = menuInput.nextDouble();

                                    System.out.println("\n");

                                    //Flexible/Changeable user-menu
                                    double buyVal = SplitArray.getCurrencyValue(CurrencyManager.buyCurrency);
                                    double sellVal = SplitArray.getCurrencyValue(CurrencyManager.sellCurrency);

                                    //Set amount to sell/buy for the representation in the menu
                                    amountToBuy = Calculator.setAmountToBuy(amount);
                                    amountToSell = Calculator.convertingAmount(amount, buyVal, sellVal);

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
