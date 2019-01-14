package de.hdm_stuttgart.mi.sd1;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestCurrencyConverter {

    @Test
    public void testSetAmountToBuy() {
        assertEquals(23.45, Calculator.setAmountToBuy(23.446756), 0.001);
        assertEquals(-23.45, Calculator.setAmountToBuy(-23.4451), 0.001);

    }

}
