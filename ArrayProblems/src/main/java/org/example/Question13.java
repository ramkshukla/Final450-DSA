// Kadane's Algo [V.V.V.V.V IMP]
public class Question13 {
    static class Result{
        int maxSum;
        int start;
        int end;
        Result(int maxSum, int start, int end){
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    public static Result kadane(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
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
            }else{
                maxEndingHere += arr[i];
            }

            if(maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }


        return new Result(maxSoFar, start, end);
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1: Array = " + arrayToString(arr));
        try{
            Result result = kadane(arr);
            System.out.println("Max Sum: " + result.maxSum);
            System.out.println("Subarray: " + arrayToString(subarray(arr, result.start, result.end)));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int[] subarray(int[] arr, int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = arr[i];
        }
        return result;
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