package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestCurrencyManager {

    //CurrencyManager-class tests:
    @Test
    public void testCheckCurrencies() {
        assertTrue(CurrencyManager.checkCurrencies(null, null));
        assertTrue(CurrencyManager.checkCurrencies("Euro:   1.2181", null));
        assertTrue(CurrencyManager.checkCurrencies(null, "Euro:   1.2181"));
        assertFalse(CurrencyManager.checkCurrencies("Euro:   1.2181", "Australian Dollar:   1.92771"));

    }


    @Test
    public void testGetCurrencyName() {
        assertEquals("Canadian Dollar", ArrayManager.getCurrencyName("Canadian Dollar:   1.8645"));
        assertEquals("Kazakhstani Tenge", ArrayManager.getCurrencyName("Kazakhstani Tenge:   514.575"));
        assertEquals("Sri Lankan Rupee", ArrayManager.getCurrencyName("Sri Lankan Rupee:   249.237"));
    }

    @Test
    public void testGetCurrencyValue() {
        assertEquals(1.8645, ArrayManager.getCurrencyValue("Canadian Dollar:   1.8645"), 0.001);
        assertEquals(514.575, ArrayManager.getCurrencyValue("Kazakhstani Tenge:   514.575"), 0.001);
        assertEquals(249.237, ArrayManager.getCurrencyValue("Sri Lankan Rupee:   249.237"), 0.001);
    }

    @Test(expected = IOException.class)
    public void testIOException() throws IOException {
        TextFileReader.readFile("Currencis.txt");
    }
}