package de.hdm_stuttgart.mi.sd1;

public class SplitArray {

    /**
     * Get only the first part of an Array's entry, the name of a currency
     * @param currency Variable which represents an entire entry
     * @return Return only the name of a currency by cutting the value of the currency after the ":"
     */

    public static String getCurrencyName(String currency) {
        return currency.substring(0, currency.indexOf(":"));
    }

    /**
     * Get only the second part of an Array's entry, the value of a currency
     * @param currency Variable which represents an entire entry
     * @return Return only the SDR value of a currency by cutting the value of the currency after the ":"
     */
    public static double getCurrencyValue(String currency) {
        String partValue = currency.substring(currency.indexOf(":") + 1);
        return Double.parseDouble(partValue.trim());
    }

}

