package de.hdm_stuttgart.mi.sd1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    static String[] currArray;

    /**
     * Reads a given file and puts the contained lines into a flexible ArrayList and finally into an Array
     *
     * @param filename Entered filename (in Driver)
     * @return Array with read currencies of the txt-file
     * @throws IOException
     */

    public static String[] readFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));

        List<String> currList = new ArrayList<>();
        String lineItems;

        while ((lineItems = br.readLine()) != null) {
            currList.add(lineItems);
        }

        br.close();

        return currArray = currList.toArray(new String[0]);
    }
}