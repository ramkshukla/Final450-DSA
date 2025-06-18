package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

// Find the Union and Intersection of the two sorted arrays.
public class Question6 {
    static class Result{
        List<Integer> union;
        List<Integer> intersection;
        Result(List<Integer> union, List<Integer> intersection){
            this.union = union;
            this.intersection = intersection;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = {2,3,5,7};
        System.out.println("Test Case 1: arr1 = " + arrayToString(arr1) + ", arr2 = " + arrayToString(arr2));
        Result result1 = findUnionAndIntersection(arr1, arr2);
        System.out.println("Union: " + result1.union);
        System.out.println("Intersection: " + result1.intersection);
    }

    public  static  Result findUnionAndIntersection(int[] arr1, int[] arr2){
        List<Integer> union = new ArrayList<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        if(arr1 == null || arr2 == null){
            throw new IllegalArgumentException("Arrays can not be null");
        }
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            while(i > 0 && i<arr1.length && arr1[i]==arr1[i-1]){
                i++;
            }
            while (j > 0 && j < arr2.length && arr2[j] == arr2[j - 1]) {
                j++;
            }
            if (i >= arr1.length || j >= arr2.length) {
                break;
            }
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } else {
                // Equal elements: add to both union and intersection
                union.add(arr1[i]);
                intersection.add(arr1[i]);
                i++;
                j++;
            }

        }
        while (i < arr1.length) {
            if (i == 0 || arr1[i] != arr1[i - 1]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2 to union
        while (j < arr2.length) {
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return new Result(union, intersection);
    }
    public static String arrayToString(int[] arr){
        if(arr == null) return "null";
        if(arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i< arr.length; i++){
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }
        sb.append("]");
        return  sb.toString();
    }
}
