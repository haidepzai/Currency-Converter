package de.hdm_stuttgart.mi.sd1;

public class SplitArray {

    /**
     * Get only the first part of an Array's entry, the name of a currency
     * @param currency Variable which represents an entire entry
     * @return Return only the name of a currency by cutting the the value of the currency after the ":"
     */



    public String getCurrencyName(String currency) {
        return currency.substring(0, currency.indexOf(":"));
    }

    public String getCurrencyValue(String currency) {
        String partValue = currency.substring(currency.indexOf(":") + 1);
        return partValue.trim();
    }

}

