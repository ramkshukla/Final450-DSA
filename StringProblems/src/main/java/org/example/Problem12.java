package org.example;

//public class Problem12 {
//    public static void main(String[] args) {
//        String binaryString = "0100110101";
//        int result = maxSplitBinaryString(binaryString);
//        System.out.println("Maximum number of substrings: " + result);
//    }
//    public static int maxSplitBinaryString(String s){
//        int count0 = 0;
//        int count1 = 0;
//        int result = 0;
//
//        for(int i=0; i<s.length(); i++){
//            char ch = s.charAt(i);
//            if(ch == '0') count0++;
//            else if (ch == '1') count1++;
//            if (count0 == count1) {
//                result++;
//            }
//        }
//        if (count0 != count1) {
//            return -1;  // Cannot be split into balanced substrings
//        }
//        return result;
//    }
//}


public class Problem12 {

    public static int splitAndPrintBalancedSubstrings(String s) {
        int count0 = 0, count1 = 0, result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '0') count0++;
            else if (ch == '1') count1++;

            if (count0 == count1) {
                // Found a balanced substring
                String substring = s.substring(start, i + 1);
                System.out.println("Substring " + (result + 1) + ": " + substring);
                result++;
                start = i + 1;
            }
        }

        // If the entire string was not balanced
        if (count0 != count1) {
            System.out.println("Cannot split the string into balanced substrings.");
            return -1;
        }

        return result;
    }

    public static void main(String[] args) {
        String binaryString = "0100110101";
        int result = splitAndPrintBalancedSubstrings(binaryString);
        System.out.println("Total substrings: " + result);
    }
}
