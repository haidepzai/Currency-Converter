package de.hdm_stuttgart.mi.sd1;

public class Calculator {

    double result;

    /**
     * Algorithm to convert an amount of one currency to another with the help of their SDR values
     *
     * @param amount Amount which shall be converted
     * @param buySDR SDR value of the currency to buy
     * @param sellSDR SDR value of the currency to sell
     * @return The converted amount
     */

    public double convertingAmount (double amount, double buySDR, double sellSDR) {

        result = (amount/buySDR)*sellSDR;

        return Math.round(result*100D)/100D;
    }
}


