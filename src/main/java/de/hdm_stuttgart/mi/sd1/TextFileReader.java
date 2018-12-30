package de.hdm_stuttgart.mi.sd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    /**
     *  Reads a given file and puts the contained lines into a flexible ArrayList and finally into an Array
     */

    String[] currArray;

    public String[] readFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<String> currList = new ArrayList<>();
        String lineItems;

        while ((lineItems = br.readLine()) != null) {
            currList.add(lineItems);
        }

        br.close();
        return currArray = currList.toArray(new String[0]);
    }

    /**
     * Get only the first part of an Array's entry, the name of a currency
     * @param currency Variable which represents an entire entry
     * @return Return only the name of a currency by cutting the the value of the currency after the ":"
     */
    public String getCurrencyName(String currency) {
        return currency.substring(0,currency.indexOf(':'));
    }
}