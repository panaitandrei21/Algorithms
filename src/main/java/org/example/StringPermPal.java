package org.example;

import java.util.HashMap;
import java.util.Map;

public class StringPermPal {
    public static boolean isPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int evenCounter = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) % 2 != 0) {
                    evenCounter++;
                } else {
                    evenCounter--;
                }
            }
        }

        return evenCounter <= 1;
    }

    public static void main(String[] args) {
        String s1 = "Tact Coa".toLowerCase();
        System.out.println(isPalindrome(s1));
    }
}
