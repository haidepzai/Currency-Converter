package de.hdm_stuttgart.mi.sd1;

public class CurrencyManager {

    static String toBuy1 = "Currency to buy : ";
    static String toSell1 = "Currency to sell: ";
    static String toBuy2 = "not set";
    static String toSell2 = "not set";
    static String buyCurrency;
    static String sellCurrency;

    static double amountToBuy = 0;
    static double amountToSell = 0;

    /**
     * Check before converting the amount whether both currencies are set
     * (used in case 2)
     *
     * @param buyCurrency Represents currency to buy
     * @param sellCurrency Represents currency to sell
     * @return True, if both currencies set, otherwise false
     */

    public static boolean checkCurrencies(String buyCurrency, String sellCurrency) {

        if (buyCurrency == null && sellCurrency == null) {
            ScreenCleaner.clearScreen();
            System.out.println("You have to select a currency to buy and to sell first!\n");
            return true;
        } else if (sellCurrency == null) {
            ScreenCleaner.clearScreen();
            System.out.println("You have to select a currency to sell first!\n");
            return true;
        } else if (buyCurrency == null) {
            ScreenCleaner.clearScreen();
            System.out.println("You have to select a currency to buy first!\n");
            return true;

        }
        return false;

    }

    /**
     * Set the currency according to the given case
     *
     * @param optionMode input Value => buy or sell currency
     * @param currencyToSet Name and the amount of the currency
     */

    public static void setCurrency(String optionMode, String currencyToSet) {
        if (optionMode.equals("0")) {
            buyCurrency = currencyToSet;
            toBuy2 = ArrayManager.getCurrencyName(buyCurrency);

            if(amountToBuy != 0) {

                double buyVal = ArrayManager.getCurrencyValue(buyCurrency);;
                double sellVal = ArrayManager.getCurrencyValue(sellCurrency);

                double result = (amountToBuy / buyVal) * sellVal;
                amountToSell = Math.round(result * 100D) / 100D;
            }

        } else if (optionMode.equals("1")) {
            sellCurrency = currencyToSet;
            toSell2 = ArrayManager.getCurrencyName(sellCurrency);

            if(amountToSell != 0) {

                double sellValue = ArrayManager.getCurrencyValue(buyCurrency);;
                double buyValue = ArrayManager.getCurrencyValue(sellCurrency);

                double result = (amountToBuy * buyValue)/ sellValue;
                amountToSell =  Math.round(result*100D)/100D;
            }

        }
    }

    /**
     * If both currencies are set => change the menu output
     */

    public static void setMenuOutput() {

        if (!toBuy2.equals("not set") && !toSell2.equals("not set")) {

            toBuy1 = "Buying " + amountToBuy + " of ";
            toSell1 = "Selling " + amountToSell + " of ";
        }
    }
}
