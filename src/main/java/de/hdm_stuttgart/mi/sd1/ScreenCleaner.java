package de.hdm_stuttgart.mi.sd1;

public class ScreenCleaner {

    /**
     * Clears the screen after several user-inputs but ONLY when using jar-file in console
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
