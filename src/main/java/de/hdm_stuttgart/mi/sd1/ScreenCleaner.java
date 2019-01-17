package de.hdm_stuttgart.mi.sd1;


public class ScreenCleaner {

    /**
     * Clear screen for better overview only in terminal when using jar-file
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
