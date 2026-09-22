package deque;
import java.util.*;

public class q9 {
    public static String solution(int decimal) {
        Deque<Integer> stack = new ArrayDeque<>();
        while(true) {
            if(decimal!=1) {
                stack.push(decimal%2);
                decimal = decimal/2;
            } else {
                stack.push(decimal);
                break;
            }
        }
        String result = new String();
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
