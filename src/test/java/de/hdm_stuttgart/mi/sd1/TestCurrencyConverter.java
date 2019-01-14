package de.hdm_stuttgart.mi.sd1;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestCurrencyConverter {

    @Test
    public void testSetAmountToBuy() {
        assertEquals(23.45, Calculator.setAmountToBuy(23.446756), 0.001);
        assertEquals(-23.45, Calculator.setAmountToBuy(-23.4451), 0.001);

    }

    @Test
    public void testCheckCurrencies(){
        assertTrue(CurrencyManager.checkCurrencies(CurrencyManager.buyCurrency,CurrencyManager.sellCurrency));
        assertTrue(CurrencyManager.checkCurrencies(null,null));
        assertTrue(CurrencyManager.checkCurrencies("Euro",CurrencyManager.sellCurrency));
        assertTrue(CurrencyManager.checkCurrencies(CurrencyManager.buyCurrency,"Euro"));

    }

}
