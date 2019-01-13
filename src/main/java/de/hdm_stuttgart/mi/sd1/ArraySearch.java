package de.hdm_stuttgart.mi.sd1;

import java.util.ArrayList;
import java.util.List;

public class ArraySearch {

    static int nC;

    static String[] foundArray;

    public static String[] searchEnteredName(String enteredName, String[] currArray) {

        nC = 0;
        List<String> foundCurrencies = new ArrayList<>();
        nC = 0;

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

