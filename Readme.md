# Currency Converter

## Introduction

> A set of predefined currencies shall be mutually converted. The user will be able to choose both a “buy” and a “sell” currency. The desired “buy” amount shall than be converted into the corresponding “sell” currency amount.

## Detailed Function

> The programm is able to convert the desired "buy" amount into the corresponding "sell" currency amount with help of the SDR currency units which is saved in a simple text data (Currencies.txt). 
The currencies among with their rates can be read and stored through a class in a suitable array.
A Calculator class is able to convert the amount of the currency to buy to the currency sell with the help of their SDR values.

Calculator method:


    static double convertingAmount(double amount, double buySDR, double sellSDR) {

        result = (amount / buySDR) * sellSDR;
        return Math.round(result * 100D) / 100D;
    }


## How to Use

1. Press either 0 or 1 to set the currencies name. You have to set both currencies first to continue with option 2 
2. Select the desired currency name. You can either write the full name of the currency or just a part of it. In last case, a list with the currencies are shown, which you can select by its index
3. After set both - buy and sell currencies - you can convert the amount with option 2
4. Enter the desired amount and the program will convert the amount to the selected currency

> To exit the programm you have to press "x" and enter your input in the main menu or "xxx" while you are in a selection!

