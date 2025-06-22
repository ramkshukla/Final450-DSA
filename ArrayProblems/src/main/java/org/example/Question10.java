package org.example;

// Minimum no. of Jumps to reach end of an array
public class Question10 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,1,4};
        System.out.println("Test Case 1: Array = " + arrayToString(arr1));
        try {
            int result1 = minJumps(arr1);
            System.out.println("Minimum jumps: " + (result1 == -1 ? "Unreachable" : result1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static int minJumps(int[] arr){
        if(arr==null || arr.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }
        if (arr.length == 1) {
            return 0;
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        int n = arr.length;

        for(int i=0; i<arr.length-1; i++){
            farthest = Math.max(farthest, i+arr[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd <= i) {
                    return -1;
                }
            }
            if (currentEnd >= n - 1) {
                return jumps;
            }
        }
        return farthest >= n - 1 ? jumps : -1;
    }

    public static String arrayToString(int[] arr){
        if(arr == null) return "null";
        if(arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }
        sb.append("]");
        return  sb.toString();
    }
}
