package de.hdm_stuttgart.mi.sd1;

import java.util.ArrayList;
import java.util.List;

public class ArrayManager {

    static int nC;
    static String[] foundArray;

    /**
     * Get only the first part of an Array's entry, the name of a currency
     *
     * @param currency Variable which represents an entire entry
     * @return Return only the name of a currency by cutting the value of the currency after the ":"
     */

    public static String getCurrencyName(String currency) {
        return currency.substring(0, currency.indexOf(":"));
    }

    /**
     * Get only the second part of an Array's entry, the value of a currency
     *
     * @param currency Variable which represents an entire entry
     * @return Return only the SDR value of a currency by cutting the value of the currency after the ":"
     */
    public static double getCurrencyValue(String currency) {
        String partValue = currency.substring(currency.indexOf(":") + 1);
        return Double.parseDouble(partValue.trim());
    }


    /**
     * Search through the read Array for an entered String
     *
     * @param enteredName Entered String which shall be searched in the Array
     * @param currArray Complete Array which was read out the txt-file
     * @return Array filled with currencies which contain the entered String (except numeric input)
     */

    public static String[] searchEnteredName(String enteredName, String[] currArray) {

        nC = 0;
        List<String> foundCurrencies = new ArrayList<>();

        for (int i = 0; i < currArray.length; i++) {
            //getCurrencyName: to prevent equalities according number-inputs
            //toLowerCase: to make sure that the case of the input is irrelevant
            if (getCurrencyName(currArray[i]).toLowerCase().contains(enteredName.toLowerCase())) {
                foundCurrencies.add(currArray[i]);
                nC++;
            }
        }
        return foundArray = foundCurrencies.toArray(new String[0]);
    }
}

