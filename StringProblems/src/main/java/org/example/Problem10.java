package org.example;

public class Problem10 {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("All Subsequences of \"" + str + "\":");
        printSubsequences(str, "");
     }
    public static void printSubsequences(String input, String output){
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        printSubsequences(input.substring(1), output + input.charAt(0));
        printSubsequences(input.substring(1), output);
    }
}
