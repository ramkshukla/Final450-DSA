package org.example;

public class Problem15 {

    public static void findNext(char[] digits) {
        int n = digits.length;

        int i;
        // Step 1: Find the pivot
        for (i = n - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
        }

        // Step 2: If no such index found
        if (i < 0) {
            System.out.println("Not possible");
            return;
        }

        // Step 3: Find the smallest digit on right side of i and greater than digits[i]
        int j;
        for (j = n - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                break;
            }
        }

        // Step 4: Swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 5: Reverse the rest
        reverse(digits, i + 1, n - 1);

        // Output the result
        System.out.println("Next number with same set of digits: " + new String(digits));
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String number = "218765";
        findNext(number.toCharArray());
    }
}
