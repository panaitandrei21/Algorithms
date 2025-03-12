package org.example.slidingwindow;

import java.util.HashMap;

public class SlidingWindow {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            if (map.containsKey(current) && map.get(current) >= start) {
                start = map.get(current) + 1;
            }
            map.put(current, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int first = 0;
        int max = 0;
        int last = 0;
        while (last < s.length()) {
            if (!map.containsKey(s.charAt(last))) {
                map.put(s.charAt(last), last);
                max = Math.max(map.size(), max);
                last++;
            } else {
                map.remove(s.charAt(first));
                first++;
            }
        }
        return max;
    }
}
