package com.cybergstudio.strings;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class BCR {

    public static boolean issubstringv1(String pattern, String text) {
        int n = text.length() - pattern.length();
        for (int i = 0; i <= n; i++) {
            int j = i, k = 0;
            while (k < pattern.length() && text.charAt(j++) == pattern.charAt(k++));
            if (k == pattern.length()) return true;
        }
        return false;
    }

    public static boolean issubstringv2(String pattern, String text) {
        Map<Character, Integer> r = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
            r.put(pattern.charAt(i), i);
        int n = text.length() - pattern.length();
        for (int i = 0; i <= n;) {
            int j = i + pattern.length() - 1;
            int k = pattern.length() - 1;
            while (k >= 0 && text.charAt(j--) == pattern.charAt(k--));
            if (k < 0) return true;
            char c = text.charAt(++j);
            if (r.containsKey(c)) {
                i += Math.max(k - r.get(c) + 1, 1);
            } else {
                i++;
            }
        }
        return false;
    }

    public static boolean issubstringv3(String pattern, String text) {
        Map<Character, LinkedList<Integer>> r = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!r.containsKey(c))
                r.put(c, new LinkedList<Integer>());
            LinkedList<Integer> l = r.get(c);
            l.addFirst(i);
        }
        int n = text.length() - pattern.length();
        for (int i = 0; i <= n;) {
            int j = i + pattern.length() - 1;
            int k = pattern.length() - 1;
            while (k >= 0 && text.charAt(j--) == pattern.charAt(k--));
            if (k < 0) return true;
            char c = text.charAt(++j);
            if (r.containsKey(c)) {
                k++;
                int step = -1;
                LinkedList<Integer> l = r.get(c);
                for (int p : l) {
                    if (p < k) {
                        step = k - p;
                        break;
                    }
                }
                i += Math.max(step, 1);
            } else {
                i++;
            }
        }
        return false;
    }

}
