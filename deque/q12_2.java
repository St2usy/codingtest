package deque;

public class q12_2 {
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] <= prices[j]) {
                    result[i] += 1;
                }
            }
        }
        return result;
    }
}
