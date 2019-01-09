package de.hdm_stuttgart.mi.sd1;

import java.util.ArrayList;
import java.util.List;

//TODO: NEU ERSTELLT!
public class ArraySearch {

    int nC = 0;

    TextFileReader tfr = new TextFileReader();
    String[] foundArray;

    public String[] searchEnteredName(String enteredName, String[] currArray) {

        List<String> foundCurrencies = new ArrayList<>();

        for (int i = 0; i < currArray.length; i++) {
            if (currArray[i].toLowerCase().contains(enteredName.toLowerCase())) {
                foundCurrencies.add(currArray[i]);
                nC++;
            }
        }
        return foundArray = foundCurrencies.toArray(new String[0]);
    }
}

