//// rearrange an array in alternating positive and negative items
//public class Question20 {
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, -4, -1, 4};
//        rearrange(arr);
//        System.out.print("Rearranged Array: ");
//        for (int num : arr) System.out.print(num + " ");
//    }
//
//    public static void rearrange(int[] arr) {
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            // If index is even, expect positive number
//            if (i % 2 == 0 && arr[i] < 0) {
//                int j = i + 1;
//                // Find the next positive number
//                while (j < n && arr[j] < 0) j++;
//                if (j == n) break; // no positive number found
//                rotateRight(arr, i, j);
//            }
//            // If index is odd, expect negative number
//            else if (i % 2 == 1 && arr[i] >= 0) {
//                int j = i + 1;
//                // Find the next negative number
//                while (j < n && arr[j] >= 0) j++;
//                if (j == n) break; // no negative number found
//                rotateRight(arr, i, j);
//            }
//        }
//    }
//
//    private static void rotateRight(int[] arr, int start, int end) {
//        int temp = arr[end];
//        for (int i = end; i > start; i--) {
//            arr[i] = arr[i - 1];
//        }
//        arr[start] = temp;
//    }
//}

import java.util.*;

public class Question20 {
    public static void rearrange(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Step 1: Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        // Step 2: Merge alternatively
        int i = 0, p = 0, n = 0;
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = neg.get(n++);
            arr[i++] = pos.get(p++);
        }

        // Step 3: Append remaining elements
        while (n < neg.size()) arr[i++] = neg.get(n++);
        while (p < pos.size()) arr[i++] = pos.get(p++);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrange(arr);
        System.out.println("Rearranged Array: " + Arrays.toString(arr));
    }
}
