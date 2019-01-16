package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import java.io.IOException;

public class TestTextFileReader {
    @Test(expected = IOException.class)
    public void testIOException() throws IOException {
        TextFileReader.readFile("Currencis.txt");
    }
}
