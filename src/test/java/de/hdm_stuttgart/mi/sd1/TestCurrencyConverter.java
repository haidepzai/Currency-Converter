package de.hdm_stuttgart.mi.sd1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;


public class TestCurrencyConverter {

    //Calculator-class tests:
    @Test
    public void testSetAmountToBuy() {
        assertEquals(23.45, Calculator.setAmountToBuy(23.446756), 0.001);
        assertEquals(-23.45, Calculator.setAmountToBuy(-23.4451), 0.001);

    }

    @Test
    public void testConvertingAmount(){
        //Test for buying 10 Euros in US Dollar
        assertEquals(11.38,Calculator.convertingAmount(10,1.2181,1.38583),0.001);
        //Test for buying 100 Australian Dollar in Chilean Peso
        assertEquals(49254.19,Calculator.convertingAmount(100,1.92771,949.478),0.001);
        //1000 Japanese Yen in Korean Won
        assertEquals(10058.69,Calculator.convertingAmount(1000,155.906,1568.21),0.001);
    }


    //CurrencyManager-class tests:
    @Test
    public void testCheckCurrencies(){
        assertTrue(CurrencyManager.checkCurrencies(null,null));
        assertTrue(CurrencyManager.checkCurrencies("Euro:   1.2181",null));
        assertTrue(CurrencyManager.checkCurrencies(null,"Euro:   1.2181"));
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
