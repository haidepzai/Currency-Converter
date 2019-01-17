package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;


import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TestCurrencyManager {

    /**
     * CurrencyManager-class tests:
     */

    @Test
    public void testCheckCurrencies() {

        assertTrue(CurrencyManager.checkCurrencies(null, null));
        assertTrue(CurrencyManager.checkCurrencies("Euro:   1.2181", null));
        assertTrue(CurrencyManager.checkCurrencies(null, "Euro:   1.2181"));
        assertFalse(CurrencyManager.checkCurrencies("Euro:   1.2181", "Australian Dollar:   1.92771"));

    }
}