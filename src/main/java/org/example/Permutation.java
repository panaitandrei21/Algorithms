package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        // Caz de bază: dacă șirul este gol, returnăm o listă cu un șir gol
        if (str.isEmpty()) {
            result.add("");
            return result;
        }

        char lastChar = str.charAt(str.length() - 1); // Extragem ultimul caracter
        String rest = str.substring(0, str.length() - 1); // Luăm restul șirului
        List<String> previousPermutations = getPermutations(rest); // Generăm permutările pentru rest

        // Inserăm `lastChar` în toate pozițiile fiecărei permutări existente
        for (String perm : previousPermutations) {
            for (int i = 0; i <= perm.length(); i++) {
                String newPerm = perm.substring(0, i) + lastChar + perm.substring(i);
                result.add(newPerm);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "ABC";
//        System.out.println(s.substring(0, 0));
        List<String> perm = getPermutations(s);
        System.out.println(perm);
    }

    public static void permutari(String prefix, String str) {
        System.out.println(prefix);
        if (str.isEmpty()) {
//            System.out.println(prefix);  // Afișează permutarea completă
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);  // Alegem un caracter
            String restul = str.substring(0, i) + str.substring(i + 1);  // Eliminăm caracterul ales
            permutari(prefix + ch, restul);  // Apel recursiv cu noul prefix
        }
    }

    private static void permutationHelper(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        permutation(sb, res, 0);
        for (String r : res) {
            System.out.println(r);
        }
    }

    private static void permutation(StringBuilder s, List<String> res, int index) {
        if (index == s.length()) {
            res.add(s.toString());
            return;
        }

        // Swap the current index with all
        // possible indices and recur
        for (int i = index; i < s.length(); i++) {
            swap(s, index, i);
            permutation(s, res, index + 1);
            swap(s, index, i);
        }
    }
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
    private static List<List<Integer>> pairsOfDifferenceK(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res.add(Arrays.asList(nums[i], nums[j]));
                }
            }
        }

        return res;
    }
}
