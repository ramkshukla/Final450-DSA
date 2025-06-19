public class Question15 {
    public static void main(String[] args) {
        // Test case 1: Normal permutation
        int[] arr1 = {1, 2, 3};
        System.out.println("Test Case 1: Array = " + arrayToString(arr1));
        nextPermutation(arr1);
        System.out.println("Next Permutation: " + arrayToString(arr1));
    }
    // Method to find the next lexicographical permutation
    public static void nextPermutation(int[] arr) {
        // Check for invalid inputs
        if (arr == null || arr.length <= 1) {
            return; // No permutation possible
        }

        int n = arr.length;
        // Step 1: Find the pivot (first i where arr[i] < arr[i+1] from right)
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If pivot found, find smallest arr[j] > arr[i] from right
        if (i >= 0) {
            int j = n - 1;
            while (j > i && arr[j] <= arr[i]) {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 4: Reverse the suffix from i+1 to end
        reverse(arr, i + 1, n - 1);
    }

    // Helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to reverse subarray from start to end
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    // Helper method to print array as string
    private static String arrayToString(int[] arr) {
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