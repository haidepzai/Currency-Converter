package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import java.io.IOException;

public class TestTextFileReader {

    /**
     * Tests for TextFileReader-class:
     *
     * @throws IOException
     */

    @Test(expected = IOException.class)
    public void testReadFile() throws IOException {

        TextFileReader.readFile("Curenciss.txt");

    }
}