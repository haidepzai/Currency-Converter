package de.hdm_stuttgart.mi.sd1;

import java.io.*;

public class TextFileReader {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("Currencies.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile;

        while ((zeile = br.readLine()) != null) {
            System.out.println(zeile);
        }

        br.close();

    }
}
