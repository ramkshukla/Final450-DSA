package org.example;

public class Problem8 {
    public static void main(String[] args) {
        String str = "babad";
        String result = longestPalindrome(str);
        System.out.println("Longest Palindromic Substring: " + result);
    }
    public static String longestPalindrome(String str){
        if(str == null || str.length() < 1) return "";
        int start=0;
        int end=0;
        for(int i=0; i<str.length(); i++){
            int len1 = expandFromCenter(str, i, i);
            int len2 = expandFromCenter(str, i, i+1);
            int len = Math.max(len1, len2);
            if(len > (end-start)){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return str.substring(start, end + 1);
    }
    public static int expandFromCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
