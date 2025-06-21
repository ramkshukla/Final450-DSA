package org.example;


import java.util.*;

public class Problem19 {
    public static List<Integer> kmpSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        List<Integer> result = new ArrayList<>();

        // Preprocess the pattern to get LPS array
        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j); // match found
                j = lps[j - 1]; // continue searching
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // fall back in pattern
                } else {
                    i++; // move forward in text
                }
            }
        }

        return result;
    }

    // Builds the LPS array
    private static int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String txt = "ababcababcabc";
        String pat = "abc";

        List<Integer> indices = kmpSearch(txt, pat);
        System.out.println("Pattern found at indices: " + indices);
    }
}
