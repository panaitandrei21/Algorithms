package org.example.palindromemaxsubstirng;

public class PalindromeMaxSubs {
    public static String palindrome(String s, int left, int right) {
        int start = 0;
        int length = 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int currLength = right - left + 1;
            if (currLength > length) {
                length = currLength;
                start = left;
            }
            left--;
            right++;
        }
        return s.substring(start, start + length);
    }
    public static void main(String[] args) {
        String s = "ac";

        String maxSubstring ="";
        for(int i = 0; i < s.length(); i++) {
            String even = palindrome(s, i - 1, i);
            String odd = palindrome(s, i, i);
            if (even.length() >= odd.length() && maxSubstring.length() <= even.length()) {
                maxSubstring = even;
            } else if (odd.length() > even.length() && maxSubstring.length() <= odd.length()) {
                maxSubstring = odd;
            }
        }

        System.out.println(maxSubstring);
    }
}
