package org.example;

import java.util.*;

public class Problem18 {
    static final int BASE = 256; // number of characters in input charset
    static final int PRIME = 101; // a prime number

    public static List<Integer> rabinKarp(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        int patHash = 0; // hash value for pattern
        int txtHash = 0; // hash value for text window
        int h = 1;

        // Pre-compute h = (BASE^(m-1)) % PRIME
        for (int i = 0; i < m - 1; i++) {
            h = (h * BASE) % PRIME;
        }

        // Compute initial hash of pattern and first window of text
        for (int i = 0; i < m; i++) {
            patHash = (BASE * patHash + pat.charAt(i)) % PRIME;
            txtHash = (BASE * txtHash + txt.charAt(i)) % PRIME;
        }

        // Slide the pattern over text one character at a time
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, check characters one by one
            if (patHash == txtHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == m) {
                    result.add(i); // match found at index i
                }
            }

            // Compute hash for next window
            if (i < n - m) {
                txtHash = (BASE * (txtHash - txt.charAt(i) * h) + txt.charAt(i + m)) % PRIME;
                // We might get negative value of txtHash, convert to positive
                if (txtHash < 0) {
                    txtHash += PRIME;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String txt = "ababcababcabc";
        String pat = "abc";

        List<Integer> indices = rabinKarp(txt, pat);
        System.out.println("Pattern found at indices: " + indices);
    }
}
