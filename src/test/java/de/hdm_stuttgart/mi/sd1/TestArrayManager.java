package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import java.lang.reflect.Array;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestArrayManager {


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

    /*@Test
    public void testSearchEnteredName() {
        final String[] inputArray = {"Chinese Yuan:   9.56032", "Euro:   1.2181", "Japanese Yen:   155.906"};
        assertEquals("Euro", ArrayManager.searchEnteredName("eur", inputArray));

    }
    */
}
