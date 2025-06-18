package org.example;

public class Problem2 {
    public static void main(String[] args) {
//  ✅ Optional: Ignore Case and Spaces
        String str = "A man a plan a canal Panama";
        str = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

//  ✅ Example 2: Using a Loop (without reverse function)
//        String str = "level";
//        boolean isPalindrome = true;
//        for(int i=0; i<str.length()/2; i++){
//            if(str.charAt(i) != str.charAt(str.length()-1-i)){
//                isPalindrome = false;
//                break;
//            }
//        }
//        if(isPalindrome){
//            System.out.println(str + " is a palindrome");
//        }
//        else{
//            System.out.println(str + " is not palindrome");
//        }

//  ✅ Example 1: Using StringBuilder
//        String str = "madam";
//        String reversed = new StringBuilder(str).reverse().toString();
//        if(str.equals(reversed)){
//            System.out.println(str + " is a palindrome");
//        }
//        else{
//            System.out.println(str + " is not a palindrome");
//        }
    }
}
