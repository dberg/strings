package com.cybergstudio.strings;

public class ZAlgorithm {

    private static void calculateZ(int[] z, char[] s , int ini, int end) {
        int l = 0; // z-box left
        int r = 0; // z-box right

        for (int i = ini; i <= end; i++) {
            if (i > r) {
                l = r = i;
                while (r <= end && s[r] == s[r - l]) r++;
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < (r - i + 1)) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r <= end && s[r] == s[r - l]) r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }

    private static int[] zarray(String pattern, String text) {
        int plen = pattern.length();
        int tlen = text.length();
        int slen = plen + tlen + 1;
        char[] s = new char[slen];
        pattern.getChars(0, plen - 1, s, 0);
        text.getChars(0, tlen - 1, s, plen + 1);
        int[] r = new int[slen];
        calculateZ(r, s, 1, plen - 1); // pattern
        calculateZ(r, s, plen + 1, slen - 1); // text
        return r;
    }

    public static boolean issubstring(String pattern, String text) {
        if (pattern.length() > text.length()) return false;
        int[] z = zarray(pattern, text);
        for (int i = pattern.length() + 1; i < z.length; i++)
            if (z[i] == pattern.length())
                return true;

        return false;
    }

}