package org.example;

public class Problem12 {
    public static void main(String[] args) {
        String binaryString = "0100110101";
        int result = maxSplitBinaryString(binaryString);
        System.out.println("Maximum number of substrings: " + result);
    }
    public static int maxSplitBinaryString(String s){
        int count0 = 0;
        int count1 = 0;
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '0') count0++;
            else if (ch == '1') count1++;
            if (count0 == count1) {
                result++;
            }
        }
        if (count0 != count1) {
            return -1;  // Cannot be split into balanced substrings
        }
        return result;
    }
}
