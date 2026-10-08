package deque;

import java.util.*;

public class q11 {
    public static int solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char s : str.toCharArray()) {
            if (!stack.isEmpty() && s == stack.peek()) {
                stack.pop();
            } else
                stack.push(s);
        }
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }
}