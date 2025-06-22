package org.example;

import java.util.Arrays;

// Minimise the maximum difference between heights [V.IMP]

public class Question9 {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        int result1 = minimizeMaxDifference(arr1, k1);
        System.out.println("Minimum max difference: " + result1);
    }

    public static int minimizeMaxDifference(int[] arr, int k){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if(k < 0){
            throw new IllegalArgumentException("K must be greater than 0");
        }
        if(arr.length == 1){
            return  0;
        }
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        int n = sortedArray.length;
        int result = sortedArray[n-1] - sortedArray[0];

        for(int i=0; i<n-1; i++){
            int minHeight = sortedArray[i] + k;
            int maxHeight = sortedArray[n-1] - k;

            if(minHeight > maxHeight){
                continue;
            }

            boolean feasible = true;
            for(int j=0; j<n; j++){
                if(sortedArray[j]+k  < minHeight || sortedArray[j] - k > maxHeight){
                    feasible = false;
                    break;
                }
            }

            if(feasible){
                result = Math.min(result, maxHeight - minHeight);
            }
        }
        return  result;
    }
}
