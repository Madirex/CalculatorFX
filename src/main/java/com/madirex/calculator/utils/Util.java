package com.madirex.calculator.utils;

public class Util {

    private Util(){
    }

    /**
     * Chequea que el String pasado por parámetro sea un número
     * @param c character
     * @return boolean
     */
    public static boolean isInteger(char c) {
        return c >= '0' && c <= '9';
    }
}
