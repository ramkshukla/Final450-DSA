import java.util.Set;
import java.util.HashSet;
// all pairs whose sum equals the target
public class Question18 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 7, 8, 9};
        int target = 7;
        findPairs(arr, target);
    }

    public static void findPairs(int[] arr, int target){
        Set<Integer> seen = new HashSet<>();
        Set<String> printedPairs = new HashSet<>();
        for(int num : arr){
            int complement = target - num;
            if(seen.contains(complement)){
                int first = Math.min(num, complement);
                int second = Math.max(num, complement);
                String pair = first + "," + second;
                if (!printedPairs.contains(pair)) {
                    System.out.println("(" + first + ", " + second + ")");
                    printedPairs.add(pair);
                }
            }
            seen.add(num);
        }
    }

//    public static void findPairs(int[] arr, int target){
//        for(int i=0; i<arr.length-1; i++){
//            for(int j=i+1; j<arr.length; j++){
//                if(arr[i] + arr[j] == target){
//                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
//                }
//            }
//        }
//    }
}