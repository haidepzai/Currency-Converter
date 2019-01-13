package de.hdm_stuttgart.mi.sd1;

public class Calculator {

    static double result;

    /**
     * Algorithm to convert an amount of the currency to buy to the currency to sell with the help of their SDR values
     *
     * @param amount Amount which shall be converted
     * @param buySDR SDR value of the currency to buy
     * @param sellSDR SDR value of the currency to sell
     * @return The converted amount
     */

    static double convertingAmount (double amount, double buySDR, double sellSDR) {

        result = (amount/buySDR)*sellSDR;
        return Math.round(result*100D)/100D;
    }

    static double setAmountToBuy (double amount) {

        return Math.round(amount * 100D) / 100D;
    }
}


