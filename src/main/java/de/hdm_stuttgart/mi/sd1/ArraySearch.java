package de.hdm_stuttgart.mi.sd1;

import java.util.ArrayList;
import java.util.List;

public class ArraySearch {

    static int nC;

    static String[] foundArray;

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
            if (SplitArray.getCurrencyName(currArray[i]).toLowerCase().contains(enteredName.toLowerCase())) {
                foundCurrencies.add(currArray[i]);
                nC++;
            }
        }
        return foundArray = foundCurrencies.toArray(new String[0]);
    }
}

