package de.hdm_stuttgart.mi.sd1;

public class CurrencyManager {

    static String toBuy1 = " Currency to buy: ";
    static String toSell1 = "Currency to sell: ";
    static String toBuy2 = "not set";
    static String toSell2 = "not set";
    static String buyCurrency;
    static String sellCurrency;

    /**
     * Check before converting the amount whether both currencies are set
     * @param buyCurrency Represents currency to buy
     * @param sellCurrency Represents currency to sell
     * @return True, if both currencies set, otherwise false
     */

    public boolean checkCurrencies(String buyCurrency, String sellCurrency) {


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

    public void setCurrency(String case, String currency) {
        if (case.equals("0")) {
            buyCurrency = currency;
            toBuy2 = SplitArray.getCurrencyName(buyCurrency);
        } else if (case.equals("1")) {
            sellCurrency = currency;
            toSell2 = SplitArray.getCurrencyName(sellCurrency);
        }
    }

}
