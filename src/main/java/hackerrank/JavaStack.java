package hackerrank;

import java.util.Scanner;
import java.util.Stack;

class JavaStack {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        char c;


        while (sc.hasNext()) {
            String input = sc.next();

            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                if (s.empty())
                    if (c == ')' || c == '}' || c == ']') {
                    s.push(c);
                    break;
                }
                if (c == '(' || c == '{' || c == '[') s.push(c);
                else if (c == ')' && s.peek() == '(' || c == '}' && s.peek() == '{' || c == ']' && s.peek() == '[')
                    s.pop();
            }
            System.out.println(s.empty());
            s.clear();
        }
    }
}
