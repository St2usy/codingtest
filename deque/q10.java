package deque;

import java.util.*;

public class q10 {
    public static int solution(String str) {
        int n = str.length();
        str += str;
        int count = 0;
        for (int i = 0; i < n; i++) {
            String rotate = str.substring(i, i + n);
            Deque<Character> stack = new ArrayDeque<>();
            for (char s : rotate.toCharArray()) {
                if (!stack.isEmpty() && s == '}' && stack.peek() == '{')
                    stack.pop();
                else if (!stack.isEmpty() && s == ')' && stack.peek() == '(')
                    stack.pop();
                else if (!stack.isEmpty() && s == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(s);
            }
            if (stack.isEmpty())
                count += 1;
        }
        return count;
    }
}
