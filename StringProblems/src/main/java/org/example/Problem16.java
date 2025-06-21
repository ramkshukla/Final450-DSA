package org.example;

import java.util.Stack;

public class Problem16 {
    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println("String is Valid : " + isValid(s));
    }
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
