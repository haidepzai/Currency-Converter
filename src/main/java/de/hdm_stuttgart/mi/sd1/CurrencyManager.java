package de.hdm_stuttgart.mi.sd1;

public class CurrencyManager {

    /**
     * Check before converting the amount whether both currencies are set
     *
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

}
