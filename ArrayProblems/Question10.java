package ArrayProblems;

// Minimum no. of Jumps to reach end of an array
public class Question10 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,1,4};
        System.out.println("Test Case 1: Array = " + arrayToString(arr1));
        try {
            int result1 = minJumps(arr1);
            System.out.println("Minimum jumps: " + (result1 == -1 ? "Unreachable" : result1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static int minJumps(int[] arr){
        if(arr==null || arr.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }
        if (arr.length == 1) {
            return 0; // No jumps needed for single element
        }
        int jumps = 0;         // Number of jumps
        int currentEnd = 0;    // Farthest index reachable with current jumps
        int farthest = 0;      // Farthest index reachable from current range
        int n = arr.length;

        for(int i=0; i<arr.length-1; i++){
            farthest = Math.max(farthest, i+arr[i]);
            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we can't move forward, end is unreachable
                if (currentEnd <= i) {
                    return -1; // Indicates end is unreachable
                }
            }

            // Optimization: If we can reach the end, no need to continue
            if (currentEnd >= n - 1) {
                return jumps;
            }
        }
        return farthest >= n - 1 ? jumps : -1;
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
