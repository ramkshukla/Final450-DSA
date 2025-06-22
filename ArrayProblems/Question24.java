import java.util.*;
//  longest consecutive subsequence
public class Question24 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        int length = findLongestConsecutiveSubsequence(arr);
        System.out.println("Longest consecutive subsequence length is: " + length);
    }
    public static int findLongestConsecutiveSubsequence(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        int maxLength = 0;
        for(int num : arr){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }
}