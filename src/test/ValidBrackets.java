package test;

import java.util.*;

public class ValidBrackets {
    public static boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (char aChar : brackets.toCharArray()) {
            if (aChar == ')' || aChar == '}' || aChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char bChar = stack.peek();
                if (bChar == '(' && aChar == ')' || bChar == '[' && aChar == ']' || bChar == '{' && aChar == '}') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(aChar);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(ValidBrackets.isValid("[{()}]"));
        System.out.println(ValidBrackets.isValid("(]"));
        System.out.println(ValidBrackets.isValid("([)]"));
        System.out.println(ValidBrackets.isValid("(((((((((((((((((("));
        System.out.println(ValidBrackets.isValid("]"));
    }
}