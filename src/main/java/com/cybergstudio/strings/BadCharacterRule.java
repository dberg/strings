package com.cybergstudio.strings;

import java.util.*;

public class BadCharacterRule {

    // Naive O(nm) implementation.
    public static List<Integer> substringV1(String pattern, String text) {
        List<Integer> indices = new ArrayList<>();
        int n = text.length() - pattern.length();
        for (int i = 0; i <= n; i++) {
            int j = i, k = 0;
            while (k < pattern.length() && text.charAt(j++) == pattern.charAt(k++));
            if (k == pattern.length()) indices.add(i);
        }
        return indices;
    }

    // Bad character rule.
    public static List<Integer> substringV2(String pattern, String text) {
        List<Integer> indices = new ArrayList<>();
        if (pattern.length() > text.length()) return indices;

        // For each character x in the alphabet, let R(x) be the position of
        // the right-most occurrence of character x in P. R(x) is defined to
        // be zero if x does not occur in P.
        Map<Character, Integer> r = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
            r.put(pattern.charAt(i), i);

        // Suppose for a particular alignment of P against T, the right-most
        // n - i characters of P match their counterparts in T, but the next
        // character to the left, P(i), mismatches with its counterpart, say
        // in position k of T. The bad character rule says that P should be
        // shifted right by max[1, i - R(T(k))] places. That is, if the
        // right-most occurrence in P of character T(k) is in position j < i
        // (including the possibility that j = 0), then shift P so that
        // character j of P is below character k of T. Otherwise, shift P by
        // one position.
        for (int n = pattern.length() - 1; n < text.length();) {
            int k = n; // index on text
            int i = pattern.length() - 1; // index on pattern
            while (i >= 0 && text.charAt(k) == pattern.charAt(i)) { i--; k--; }
            if (i < 0) {
                indices.add(k + 1);
                n = n + 1;
            } else {
                n = n + Math.max(1, i - r.getOrDefault(text.charAt(k), 0));
            }
        }

        return indices;
    }

    // Extended bad character rule.
    public static List<Integer> substringV3(String pattern, String text) {
        List<Integer> indices = new ArrayList<>();
        if (pattern.length() > text.length()) return indices;

        Map<Character, LinkedList<Integer>> r = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!r.containsKey(c))
                r.put(c, new LinkedList<>());
            LinkedList<Integer> l = r.get(c);
            l.addFirst(i);
        }

        for (int n = pattern.length() - 1; n < text.length();) {
            int k = n; // index on text
            int i = pattern.length() - 1; // index on pattern
            while (i >= 0 && text.charAt(k) == pattern.charAt(i)) { i--; k--; }
            if (i < 0) {
                indices.add(k + 1);
                n = n + 1;
            } else {
                int ii = i;
                int l = r.getOrDefault(text.charAt(k), new LinkedList<>())
                        .stream()
                        .filter(j -> j < ii)
                        .findFirst()
                        .orElse(0);

                n = n + Math.max(1, i - l);
            }
        }

        return indices;
    }

}
