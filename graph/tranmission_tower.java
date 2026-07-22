package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class tranmission_tower {
    private static ArrayList<Integer>[] adjlist;
    private static boolean[] visited;
    private static int N, answer;

    public static int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
        adjlist = new ArrayList[n + 1];
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }
        for (int[] node : wires) {
            adjlist[node[0]].add(node[1]);
            adjlist[node[1]].add(node[0]);
        }
        visited = new boolean[n + 1];
        dfs(1);

        return answer;

    }

    private static int dfs(int start) {
        visited[start] = true;
        int sum = 0;
        for (int next : adjlist[start]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum += cnt;
            }
        }
        return sum + 1;
    }
}
