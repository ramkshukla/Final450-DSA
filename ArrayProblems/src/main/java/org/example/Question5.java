package org.example;

// Move all the negative elements to one side of the array
public class Question5 {
    public static void main(String[] args) {
        int[] arr1 = {1, -2, 3, -4, 5, -6};
        System.out.println("Test Case 1: Array = " + arrayToString(arr1));
        moveNegativesToLeft(arr1);
        System.out.println("After moving negatives: " + arrayToString(arr1));
    }
    public static void moveNegativesToLeft(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int left = 0;
        int right = 0;

        while (right < arr.length) {
            if (arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right++;
            } else {
                right++;
            }
        }
    }
    public static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        if (arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
