package org.example;

import java.util.HashMap;
import java.util.Map;

public class StringComprehension {
    public static void main(String[] args) {
        String a = "aabcccccaaa";
        System.out.println(stringCompressed(a));
    }

    private static String stringCompressed(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char nextC = s.charAt(i + 1);
            if (c == nextC) {
                counter++;
                if (i == s.length() - 2) {
                    sb.append(c);
                    sb.append(counter);
                }
            } else {
                sb.append(c);
                sb.append(counter);
                counter = 1;
            }
        }
        if (sb.length() < s.length()) {
            return s;
        }
        return sb.toString();
    }
}
