package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringEditsLessThen2 {
    public static boolean stringEdits(String s1 , String s2) {
        int countEdit = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!Objects.equals(map2.get(entry.getKey()), entry.getValue())) {
                countEdit++;
            }
        }
        return countEdit <= 1;
    }

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "ple";
        System.out.println(stringEdits(s1, s2));
    }


}
