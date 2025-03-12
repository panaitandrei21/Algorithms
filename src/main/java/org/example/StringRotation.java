package org.example;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) { // O(N^2) n pt for si n pt n pt creearea stringurilor
        for (int i = 0; i < s1.length(); i++) {
            String firstHalf = s1.substring(0, i);
            String secondHalf = s2.substring(i);
            StringBuilder builder = new StringBuilder(secondHalf + firstHalf);
            if (builder.toString().equals(s2)) {
                return true;
            }
        }
        return false;
    }
//    private static boolean isRotationOptimal(String s1, String s2) { // Presupunand ca am isSubstring()
//        String concatenation = s1 + s2;
//        //return isSubstring(concatenation, s2)
//    }

}
