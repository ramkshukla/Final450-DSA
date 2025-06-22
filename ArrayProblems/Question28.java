import java.util.*;
// To find a triplet in an array that sums to a given value,
// you can use a sorting + two-pointer approach for optimal performance.
public class Question28 {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        int target = 24;

        findTriplet(arr, target);
    }
    public static boolean findTriplet(int[] arr, int target){
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    return true;
                } else if (sum < target) {
                    left++; // Need a bigger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        System.out.println("No triplet found");
        return false;
    }
}