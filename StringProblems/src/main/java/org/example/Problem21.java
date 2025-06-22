package org.example;

import java.util.Stack;

// Minimum number of bracket reversals needed to make an expression balanced.
public class Problem21 {
    public static void main(String[] args) {
        String expr = "}}{{";
        System.out.println("Minimum reversals needed: " + countBracketReversals(expr));
    }

    public static int countBracketReversals(String expr){
        int n = expr.length();
        if(n%2 !=0) return -1;
        Stack<Character> stack = new Stack<>();
        for(char ch : expr.toCharArray()){
            if(ch == '{'){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        // Now stack contains unbalanced brackets
        int open = 0, close = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') open++;
            else close++;
        }

        // ceil(open/2) + ceil(close/2) = (open + 1)/2 + (close + 1)/2
        return (open + 1) / 2 + (close + 1) / 2;
    }
}
