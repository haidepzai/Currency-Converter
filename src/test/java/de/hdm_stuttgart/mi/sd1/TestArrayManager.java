package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayManager {

    /**
     * ArrayManager-class tests:
     */

    @Test
    public void testGetCurrencyName() {

        assertEquals("Canadian Dollar", ArrayManager.getCurrencyName("Canadian Dollar:   1.8645"));
        assertEquals("Kazakhstani Tenge", ArrayManager.getCurrencyName("Kazakhstani Tenge:   514.575"));
        assertEquals("Sri Lankan Rupee", ArrayManager.getCurrencyName("Sri Lankan Rupee:   249.237"));

    }

    @Test
    public void testGetCurrencyValue() {

        assertEquals(1.8645, ArrayManager.getCurrencyValue("Canadian Dollar:   1.8645"), 0.00001);
        assertEquals(514.575, ArrayManager.getCurrencyValue("Kazakhstani Tenge:   514.575"), 0.00001);
        assertEquals(249.237, ArrayManager.getCurrencyValue("Sri Lankan Rupee:   249.237"), 0.00001);

    }

    @Test
    public void testSearchEnteredName() {

        final String[] inputArray = {"Chinese Yuan:   9.56032", "Euro:   1.2181", "U.S. Dollar:   1.38583", "Norwegian Krone:   12.0392"};

        assertEquals(new String[]{"Euro:   1.2181"}, ArrayManager.searchEnteredName("eur", inputArray));
        assertEquals(new String[]{"Chinese Yuan:   9.56032", "Norwegian Krone:   12.0392"}, ArrayManager.searchEnteredName("n", inputArray));
        assertEquals(new String[]{}, ArrayManager.searchEnteredName("xxx", inputArray));
        assertEquals(new String[]{},ArrayManager.searchEnteredName("0", inputArray));

    }

}
