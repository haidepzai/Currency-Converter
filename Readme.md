# Currency Converter

## Introduction

> A set of predefined currencies shall be mutually converted. The user will be able to choose both a “buy” and a “sell” currency. The desired “buy” amount shall than be converted into the corresponding “sell” currency amount.

## Detailed Function

> The programm is able to convert the desired "buy" amount into the corresponding "sell" currency amount with help of the SDR currency units which is saved in a simple text data (Currencies.txt). 
The TextFileReader class is able to read and store the currencies among with their rates in a suitable array.

Text File Reader:

    public static String[] readFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));

        List<String> currList = new ArrayList<>();
        String lineItems;

        while ((lineItems = br.readLine()) != null) {
            currList.add(lineItems);
        }

        br.close();

        return currArray = currList.toArray(new String[0]);
    }
    
> A Calculator class is able to convert the amount of the currency to buy to the currency sell with the help of their SDR values.

Calculator method:


    static double convertingAmount(double amount, double buySDR, double sellSDR) {

        result = (amount / buySDR) * sellSDR;
        return Math.round(result * 100D) / 100D;
    }
    
> Program runs in an endless loop, unless user exits through 'x'    


## How to Use

1. Press either 0 or 1 to set the currencies' name. You have to set both currencies first to continue with option 2 
2. Select the desired currency name. You can either write the full name of the currency or just a part of it. In last case, a list with the currencies will be shown, which you can select by its index
3. After set both - buy and sell currencies - you can convert the amount with option 2
4. Enter the desired amount and the program will convert the amount to the selected currency

> To exit the program press "x" and enter your input in the main menu or "xxx" while you are in a selection!

## Team

| <a href="https://gitlab.mi.hdm-stuttgart.de/sv048" target="_blank">**Vu Son Hai**</a> | <a href="https://gitlab.mi.hdm-stuttgart.de/lh108" target="_blank">**Heinrich Leon**</a> | <a href="https://gitlab.mi.hdm-stuttgart.de/sd114" target="_blank">**Dubiel Sebastian**</a> |
| :---: |:---:| :---:|
| [![Hai](https://gitlab.mi.hdm-stuttgart.de/uploads/-/system/user/avatar/1055/avatar.png?width=400)](https://gitlab.mi.hdm-stuttgart.de/sv048)    | [![Leon](https://gitlab.mi.hdm-stuttgart.de/uploads/-/system/user/avatar/1210/avatar.png?width=400)](https://gitlab.mi.hdm-stuttgart.de/lh108) | [![Sebastian](https://secure.gravatar.com/avatar/fdf84a6071fa8157dc44f162a001cea6?s=200&d=identicon)](https://gitlab.mi.hdm-stuttgart.de/sd114)  |
| <a href="https://gitlab.mi.hdm-stuttgart.de/sv048" target="_blank">`https://gitlab.mi.hdm-stuttgart.de/sv048`</a> | <a href="https://gitlab.mi.hdm-stuttgart.de/lh108" target="_blank">`https://gitlab.mi.hdm-stuttgart.de/lh108`</a> | <a href="https://gitlab.mi.hdm-stuttgart.de/sd114" target="_blank">`https://gitlab.mi.hdm-stuttgart.de/sd114`</a> |
