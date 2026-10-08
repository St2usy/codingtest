package deque;

import java.util.*;

public class q12 {
    public static int[] solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Map.Entry<Integer, Integer>> stack = new ArrayDeque<>();
        for (int n : arr) {
            map.put(n, 0);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

        }
    }
}
