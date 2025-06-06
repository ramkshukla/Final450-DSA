package ArrayProblems;

import java.security.interfaces.RSAKey;

//find Largest sum contiguous Subarray [V. IMP]
public class Question8 {
   public static class Result{
        int maxSum;
        int start;
        int end;
        Result(int maxSum, int start, int end){
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        Result result1 = findmaximumSumSubArrayNotRecommanede(arr1);
        Result result1 = findMaximumSumSubArray(arr1);
        System.out.println("Max Sum: " + result1.maxSum);
        System.out.println("Subarray: " + arrayToString(subarray(arr1, result1.start, result1.end)));
    }
//
//    public static Result findmaximumSumSubArrayNotRecommanede(int[] arr){
//       if(arr == null || arr.length == 0){
//           throw  new IllegalArgumentException("Array must not be null or empty");
//       }
//       int maxSum = arr[0];
//       int start = 0, end = 0;
//       for(int i=0; i<arr.length; i++){
//           int currentSum = 0;
//           for(int j=i; j<arr.length; j++){
//               currentSum += arr[j];
//               if(currentSum > maxSum){
//                   maxSum = currentSum;
//                   start = i;
//                   end = j;
//               }
//           }
//       }
//       return  new Result(maxSum, start, end);
//    }
//

    public static Result findMaximumSumSubArray(int[] arr){
        if(arr == null || arr.length == 0){
            throw  new IllegalArgumentException("Array must not be null or empty");
        }
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > maxEndingHere + arr[i]){
                maxEndingHere = arr[i];
                tempStart = i;
            }
            else{
                maxEndingHere += arr[i];
            }

            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        return  new Result(maxSoFar, start, end);
    }

    public  static  int[] subarray(int[] arr, int start, int end){
            int[] result = new int[end-start+1];
            for(int i=start; i<=end; i++){
                result[i - start] = arr[i];
            }
            return  result;
    }

    public  static  String arrayToString(int[] arr){
        if(arr == null) return  "null";
        if(arr.length == 0) return  "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            if(i < arr.length-1) sb.append(", ");
        }
        sb.append("]");
        return  sb.toString();
    }
}
