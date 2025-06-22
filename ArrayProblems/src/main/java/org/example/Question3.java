package org.example;
import java.util.*;
// Find the Kth max and min Element in an Array
public class Question3 {
    public static void main(String[] args) {
        Integer[] arr = {4,1,7,0,6};
        int k = 2;
        Arrays.sort(arr);
        System.out.println("Kth Minimum Element : " + arr[k-1]);
        System.out.println("Kth Maximum Element : " + arr[arr.length-k]);
    }   
}
