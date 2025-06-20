package org.example;

// Reverse a String
public class Problem1 {
    public static void main(String[] args) {
//  ✅Using a Char Array
    String str = "Hello World";
    char[] chars = str.toCharArray();
    for(int i=0, j=chars.length-1; i<j; i++,j--){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    System.out.println("Reversed : " + new String(chars));

//  ✅Using a Loop
//        String str = "Hello World";
//        String reversed = "";
//        for(int i=str.length()-1; i>=0; i--){
//            reversed += str.charAt(i);
//        }
//        System.out.println("Reversed: " + reversed);
//  ✅Using StringBuilder (Most Efficient)
//        String str = "Hello World";
//        String reversed = new StringBuilder(str).reverse().toString();
//        System.out.println("Reversed : " + reversed);
    }
}
