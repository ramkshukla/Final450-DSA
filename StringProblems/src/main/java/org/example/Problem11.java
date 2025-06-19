package org.example;

public class Problem11 {
    public static void main(String[] args) {
        String input = "abc";
        printPermutations(input, "");
    }
    public static void printPermutations(String input, String result){
        if(input.length() == 0){
            System.out.println(result);
            return;
        }
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i + 1);
            printPermutations(remaining, result + ch);
        }
    }
}
