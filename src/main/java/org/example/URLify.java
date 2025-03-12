package org.example;

import java.util.Arrays;

public class URLify {
    public static void replaceSpaces(char[] str, int trueLength) {
        int count = 0;
        int fullIndex = str.length - 1;
        for(int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[fullIndex] = '0';
                str[fullIndex-1] = '2';
                str[fullIndex-2] = '%';
                fullIndex = fullIndex - 3;
            } else {
                str[fullIndex] = str[i];
                fullIndex--;
           }

        }
    }

    public static void main(String[] args) {
        char[] input =
        "Mr John Smith    ".toCharArray();
        char[] input2 =
                "an de  ".toCharArray();
        int trueLength = 13;
        int trueLength2 = 5;
        replaceSpaces(input, trueLength);
        System.out.println(input);
    }
}
