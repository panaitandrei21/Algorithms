package org.example.reverseIntCheckMaxMin;

public class ReverseInt {
    public static int reverse(int x) {
        int reverse = 0;
        int pop;
        while (x != 0) {
            pop = x%10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (reverse  < Integer.MIN_VALUE / 10 || reverse == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            reverse = reverse*10 + pop;
        }

        return reverse;
    }
}
