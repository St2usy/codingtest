package deque;

import java.util.*;

public class q12 {
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop(); // j는 반복중인 인덱스의 가격보다 큰 인덱스의 가격일 때, 인덱스를 반환
                answer[j] = i - j; // 현재 인덱스에서 stack의 인덱스를 빼, 길이를 계산
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 인덱스가 남아있다고? -> 넌 한번도 안떨어졌다
            int j = stack.pop(); // 언제 들어온 놈이야?
            answer[j] = n - 1 - j; // 떨어지지 않은 기간 이니, 전체길이 - 1 - 떨어진 인덱스
        }
        return answer;
    }
}
