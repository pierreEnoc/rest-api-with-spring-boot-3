package com.pierre.api_rest_with_spring_3.converter.request;

public class NumberConverter {

    public static Double converToDoube(String strnumber) {

        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value! ");
        String number = strnumber.replace(",",".");//R$5,00 USD 5.00
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strnumber) {
        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value! ");
        String number = strnumber.replace(",",".");//R$5,00 USD 5.00
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
