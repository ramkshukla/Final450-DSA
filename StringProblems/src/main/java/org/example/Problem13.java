package org.example;

public class Problem13 {

    final static int INF = Integer.MAX_VALUE;

    public static void wordWrap(int[] words, int maxWidth) {
        int n = words.length;

        int[][] extras = new int[n + 1][n + 1];
        int[][] lineCost = new int[n + 1][n + 1];
        int[] cost = new int[n + 1];
        int[] result = new int[n + 1];

        // Calculate extra spaces
        for (int i = 1; i <= n; i++) {
            extras[i][i] = maxWidth - words[i - 1];
            for (int j = i + 1; j <= n; j++) {
                extras[i][j] = extras[i][j - 1] - words[j - 1] - 1;
            }
        }

        // Calculate line cost
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (extras[i][j] < 0)
                    lineCost[i][j] = INF;
                else if (j == n)
                    lineCost[i][j] = 0;
                else
                    lineCost[i][j] = extras[i][j] * extras[i][j];
            }
        }

        // Calculate minimum cost and result
        cost[0] = 0;
        for (int j = 1; j <= n; j++) {
            cost[j] = INF;
            for (int i = 1; i <= j; i++) {
                if (cost[i - 1] != INF && lineCost[i][j] != INF &&
                        cost[i - 1] + lineCost[i][j] < cost[j]) {
                    cost[j] = cost[i - 1] + lineCost[i][j];
                    result[j] = i;
                }
            }
        }

        printSolution(result, n);
        System.out.println("Minimum total cost: " + cost[n]);
    }

    // Print wrapped lines
    private static void printSolution(int[] result, int n) {
        if (result[n] == 1) {
            System.out.print("Line " + 1 + ": " + result[n] + " to " + n + "\n");
        } else {
            printSolution(result, result[n] - 1);
            System.out.print("Line " + (count + 1) + ": " + result[n] + " to " + n + "\n");
        }
        count++;
    }

    static int count = 0;

    public static void main(String[] args) {
        int[] wordLengths = {3, 2, 2, 5};
        int maxWidth = 6;
        wordWrap(wordLengths, maxWidth);
    }
}

