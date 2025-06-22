package org.example;

// Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
public class Question4 {
    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0};
        sort01(array);
        printArray(array);
    }

    public static void sort01(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid <= high){
            switch (arr[mid]){
                case 0:
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public  static  void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
