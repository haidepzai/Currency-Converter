package de.hdm_stuttgart.mi.sd1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {

    //Calculator-class tests:

    @Test
    public void testSetAmountToBuy() {
        assertEquals(23.45, Calculator.setAmountToBuy(23.446756), 0.001);
        assertEquals(-23.45, Calculator.setAmountToBuy(-23.4451), 0.001);

    }

    @Test
    public void testConvertingAmount() {
        //Test for buying 10 Euros in US Dollar
        assertEquals(11.38, Calculator.convertingAmount(10, 1.2181, 1.38583), 0.001);
        //Test for buying 100 Australian Dollar in Chilean Peso
        assertEquals(49254.19, Calculator.convertingAmount(100, 1.92771, 949.478), 0.001);
        //1000 Japanese Yen in Korean Won
        assertEquals(10058.69, Calculator.convertingAmount(1000, 155.906, 1568.21), 0.001);
    }


}
