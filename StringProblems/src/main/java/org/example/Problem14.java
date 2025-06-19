package org.example;

public class Problem14 {

    public static int minEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // delete all
        for (int j = 0; j <= n; j++) dp[0][j] = j; // insert all

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(dp[i][j - 1], // insert
                                    dp[i - 1][j]) // delete
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";

        System.out.println("Minimum Edit Distance: " + minEditDistance(str1, str2));
    }
}

