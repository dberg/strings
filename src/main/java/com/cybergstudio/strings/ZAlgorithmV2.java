package com.cybergstudio.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZAlgorithmV2 {

    public static List<Integer> substrings(String pattern, String text) {
        if (pattern.length() > text.length()) return Collections.emptyList();
        int[] r = processPattern(pattern);
        return processText(r, pattern, text);
    }

    /** Calculate the z-array for the pattern in O(n) using z-boxes. */
    private static int[] processPattern(String p) {
        int l = 0; // z-box left
        int r = 0; // z-box right

        int[] z = new int[p.length()];

        for (int i = 1; i < p.length(); i++) {
            if (i > r) {
                l = r = i;
                while (r < p.length() && p.charAt(r) == p.charAt(r - l)) r++;
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < (r - i + 1)) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < p.length() && p.charAt(r) == p.charAt(r - l)) r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }

        return z;
    }

    /**
     * Calculate the potential indexes where p is found in t.
     *
     * @param z z-array of the pattern
     * @param p pattern
     * @param t text
     */
    private static List<Integer> processText(int[] z, String p, String t) {
        List<Integer> indices = new ArrayList<>();

        int l = 0; // z-box left
        int r = 0; // z-box right

        for (int i = 0; i < t.length(); i++) {
            if (i == 0 || i > r) {
                l = r = i;
                while (r < t.length() && r - l < p.length() && t.charAt(r) == p.charAt(r - l)) r++;
                if ((r - l) == p.length()) indices.add(l);
                r--;
            } else {
                int k = i - l;
                if (z[k] >= (r - i + 1)) {
                    l = i;
                    while (r < t.length() && r - l < p.length() && t.charAt(r) == p.charAt(r - l)) r++;
                    if (r -l == p.length()) indices.add(l);
                    r--;
                }
            }
        }

        return indices;
    }
}
