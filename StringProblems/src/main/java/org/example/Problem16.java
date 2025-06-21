package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem16 {
    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println("String is Valid : " + isValid(s));
    }
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                char top = stack.isEmpty() ? '#' : stack.pop(); // '#' acts as dummy if stack is empty
                if (top != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch); // opening brackets
            }
        }

        return stack.isEmpty(); // all brackets matched
    }

//
//    public static boolean isValid(String str){
//        Stack<Character> stack = new Stack<>();
//        for(char ch : str.toCharArray()){
//            if(ch == '(' || ch == '{' || ch == '['){
//                stack.push(ch);
//            }
//            else {
//                if(stack.isEmpty()) return false;
//                char top = stack.pop();
//                if ((ch == ')' && top != '(') ||
//                        (ch == '}' && top != '{') ||
//                        (ch == ']' && top != '[')) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

}
