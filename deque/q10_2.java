package deque;

import java.util.*;

class q10_2 {
    public int solution(String str) {
        Stack<Character> stack = new Stack<>();
        ArrayDeque<Character> deq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            deq.add(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            for (char c : deq) {
                if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                    stack.pop();

                } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    stack.pop();

                } else if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();

                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty())
                count += 1;
            deq.add(deq.poll());
            stack.clear();
        }
        return count;
    }
}