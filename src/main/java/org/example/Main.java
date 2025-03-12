package org.example;


import java.util.*;

public class Main {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for(int l = k + 1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (target == sum) {
                            List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            Collections.sort(list);
                            if (!res.contains(list)) {
                                res.add(list);
                            }
                        }
                    }
                }
            }

        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        String s = "ABC";
        int k = 2;
//        permutationHelper(s);
        permutari("", s);
//        System.out.println(pairsOfDifferenceK(nums, k));
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

