package org.example.letterCombinationsOfPhoneNrPermutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombination {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();
        String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while (!queue.isEmpty()) {
            String prefix = queue.poll();
            if (prefix.length() == digits.length()) {
                result.add(prefix);
            } else {
                int getDigit = Character.getNumericValue(digits.charAt(prefix.length()));
                for (Character ch : numbers[getDigit].toCharArray()) {
                    queue.add(prefix + ch.toString());
                }
            }
        }
        return result;
    }
}
