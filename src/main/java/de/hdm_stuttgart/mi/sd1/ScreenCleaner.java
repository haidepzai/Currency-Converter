package de.hdm_stuttgart.mi.sd1;

public class ScreenCleaner {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
