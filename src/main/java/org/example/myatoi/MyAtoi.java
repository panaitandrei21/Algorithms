package org.example.myatoi;

public class MyAtoi {
    public static int myAtoi(String s) {
        int res = 0;
        boolean isNegative = false;
        boolean gotZero = false;
        boolean gotDash = false;
        boolean gotPlus = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int z = c - 48;
            if (gotPlus && c == '+')
                return 0;
            if (gotZero && c == '+')
                return 0;
            if (isNegative && c == '-' && res == 0)
                return 0;
            if (isNegative && gotPlus)
                return 0;
            if (c == ' ' && res!=0)
                break;
            if (c == ' ' && !gotZero && !gotDash && !gotPlus)
                continue;
            if (z == 0 && res == 0) {
                gotZero = true;
                continue;
            }
            if (c == '+' && res == 0) {
                gotPlus = true;
                continue;
            }
            if (gotZero && c =='-')
                break;
            if (c == '-' && res == 0  ) {
                isNegative = true;
                continue;
            }
            if (z < 0 || z > 9 && c != ' ' && c != '0')
                break;
            if ((res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && z > 7) && !isNegative) {
                return Integer.MAX_VALUE;
            }
            if ((res * -1  < Integer.MIN_VALUE / 10 || res * -1 == Integer.MIN_VALUE / 10 && z > 8) && isNegative)  {
                return Integer.MIN_VALUE;
            }


            res = res * 10 + z;
        }
        if (isNegative)
            res = res * -1;
        return res;
    }
}
