import java.util.Map;
import java.util.HashMap;

// Given an array of size n and a number k, find all the elements that appear more than n/k times.
public class Question25 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        int k = 4;
        findElements(arr, k);
    }
    public static void findElements(int[] arr, int k){
        int n = arr.length;
        int threshold = n / k;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Elements appearing more than n/k times:");
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > threshold){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}