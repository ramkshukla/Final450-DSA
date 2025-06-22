//Given:
//
//An array arr[] of n integers where each element represents the number of chocolates in a packet.
//An integer m representing the number of students.
//Distribute m packets such that:
//Each student gets exactly one packet.
//The difference between the maximum and minimum chocolates given to students is minimum.

import java.util.*;
public class Question30 {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;

        System.out.println("Minimum difference is: " + minDifference(arr, m));
    }
    public static int minDifference(int[] arr, int m){
        int n = arr.length;
        if(m==0 || n==0) return 0;
        Arrays.sort(arr);
        if (m > n) return -1; // Not enough packets
        int minDiff = Integer.MAX_VALUE;
        // Find the minimum difference between max and min of m-size windows
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}