package deque;
import java.util.*;

public class q8 {
    public static boolean solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char s : str.toCharArray()) {
            if(!(stack.isEmpty()) && s==')') {
                stack.pop();
            } else stack.push(s);
        }
        return stack.isEmpty();
    }
}
