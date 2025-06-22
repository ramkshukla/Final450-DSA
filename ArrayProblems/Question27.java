import java.util.*;
// Find whether an array is a subset of another array
public class Question27 {
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        System.out.println("Is arr2 a subset of arr1? " + isSubset(arr1, arr2));
    }
// HashSet
    public static boolean isSubset(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }

    // Two Pointers
//    public static boolean isSubset(int[] arr1, int[] arr2){
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        int i = 0, j = 0;
//        int m = arr1.length, n = arr2.length;
//
//        while (i < m && j < n) {
//            if (arr1[i] < arr2[j]) {
//                i++;
//            } else if (arr1[i] == arr2[j]) {
//                i++;
//                j++;
//            } else {
//                return false; // arr2[j] not found in arr1
//            }
//        }
//
//        return (j == n);
//    }

    // HashMap
//    public static boolean isSubset(int[] arr1, int[] arr2){
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int num : arr1){
//            map.put(num, map.getOrDefault(num, 0)+1);
//        }
//
//        for(int num : arr2){
//            if(!map.containsKey(num) || map.get(num) == 0){
//                return false;
//            }
//            map.put(num, map.get(num) - 1);
//        }
//        return true;
//    }
}