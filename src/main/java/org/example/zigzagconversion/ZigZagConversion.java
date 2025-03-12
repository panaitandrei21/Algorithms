package org.example.zigzagconversion;

public class ZigZagConversion {
    public static String zigZagConversion(int row, String s) {
        if (row == 1)
            return s;
        String[] res = new String[row];


        int next_row = 0;
        int counter = 0;
        boolean switcher = false;
        while (counter < s.length()) {
            String helper = res[next_row];
            if (helper != null)
                res[next_row] = helper + s.charAt(counter);
            else
                res[next_row] = String.valueOf(s.charAt(counter));

            if (row - 1 == next_row)
                switcher = true;
            else if (next_row == 0)
                switcher = false;

            if (switcher) {
                next_row--;
            } else {
                next_row++;
            }
            counter++;

        }
        StringBuilder finalString = new StringBuilder();
        for (String resString : res) {
            if (resString != null)
                finalString.append(resString);
        }
        return finalString.toString();
    }
}
