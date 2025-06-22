package org.example;

// find duplicate in an array of N+1 Integers
public class Question11 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println("Test case 1 := " + arrayToString(arr));
        try{
            int result1 = findDuplicate(arr);
            System.out.println("Duplicate: " + result1);
        }
        catch (Exception e){
            System.out.println("Error " + e.toString());
        }
    }
    public static int findDuplicate(int[] arr){
        if(arr == null || arr.length < 2){
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        int n = arr.length - 1;
        for(int num : arr){
            if(num < 1 || num > n){
                throw new IllegalArgumentException("Array elements must be in range [1, " + n + "]");
            }
        }

        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow != fast);

        slow = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
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
