package hackerrank;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {

    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    char popVal = stack.pop();
                    if (s.charAt(i) == ')' && popVal != '(') {
                        return "NO";
                    } else if (s.charAt(i) == ']' && popVal != '[') {
                        return "NO";
                    } else if (s.charAt(i) == '}' && popVal != '{') {
                        return "NO";
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
