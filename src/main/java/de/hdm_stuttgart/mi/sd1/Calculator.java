package de.hdm_stuttgart.mi.sd1;

public class Calculator {

    float result;

    /**
     * Algorithm to convert an amount of one currency to another with the help of their SDR values
     *
     * @param amount Amount which shall be converted
     * @param buySDR SDR value of the currency to buy
     * @param sellSDR SDR value of the currency to sell
     * @return The converted amount
     */

    public float convertingAmount (float amount, float buySDR, float sellSDR) {

        result = (amount/buySDR)*sellSDR;
        return result;
    }
}


