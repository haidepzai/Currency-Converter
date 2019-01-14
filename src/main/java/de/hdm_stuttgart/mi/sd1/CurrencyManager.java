package de.hdm_stuttgart.mi.sd1;

public class CurrencyManager {

    static String toBuy1 = " Currency to buy: ";
    static String toSell1 = "Currency to sell: ";
    static String toBuy2 = "not set";
    static String toSell2 = "not set";
    static String buyCurrency;
    static String sellCurrency;

    static double amountToBuy = 0;
    static double amountToSell = 0;

    /**
     * Check before converting the amount whether both currencies are set
     *
     * @param buyCurrency Represents currency to buy
     * @param sellCurrency Represents currency to sell
     * @return True, if both currencies set, otherwise false
     */

    public static boolean checkCurrencies(String buyCurrency, String sellCurrency) {


        if (buyCurrency == null && sellCurrency == null) {
            System.out.println("\nYou have to select a currency to buy and to sell first!\n");
            return true;
        } else if (sellCurrency == null) {
            System.out.println("\nYou have to select a currency to sell first!\n");
            return true;
        } else if (buyCurrency == null) {
            System.out.println("\nYou have to select a currency to buy first!\n");
            return true;

        }
        return false;

    }

    /**
     * Set the currency according to the given case
     * @param mode input Value
     * @param currency Name and the amount of the currency
     */

    public static void setCurrency(String mode, String currency) {
        if (mode.equals("0")) {
            buyCurrency = currency;
            toBuy2 = SplitArray.getCurrencyName(buyCurrency);

            if(amountToBuy == 0) {

            } else {
                double value = SplitArray.getCurrencyValue(buyCurrency);

                double buyVal = value;
                double sellVal = SplitArray.getCurrencyValue(sellCurrency);

                double result = (amountToBuy / buyVal) * sellVal;
                amountToSell = Math.round(result * 100D) / 100D;
            }

        } else if (mode.equals("1")) {
            sellCurrency = currency;
            toSell2 = SplitArray.getCurrencyName(sellCurrency);

            if(amountToSell == 0) {

            } else {

                double value = SplitArray.getCurrencyValue(buyCurrency);

                double sellVal = value;
                double buyVal = SplitArray.getCurrencyValue(sellCurrency);

                double result = (amountToBuy *buyVal)/ sellVal;
                amountToSell =  Math.round(result*100D)/100D;
            }

        }
    }

}
