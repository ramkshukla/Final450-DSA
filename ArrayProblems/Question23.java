import java.math.*;
public class Question23 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println("Maximum product subarray: " + maxProduct(nums));
    }
    public static int maxProduct(int[] arr){
        if(arr.length == 0) return 0;
        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for(int i=1; i<arr.length; i++){
            int current = arr[i];
            if(current < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            result = Math.max(result, maxProd);
        }
        return result;
    }
}