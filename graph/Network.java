package graph;

import java.util.*;

public class Network {

    private static boolean[] visited;

    private static ArrayList<Integer>[] adjlist;

    public static int solution(int n, int[][] maps) {
        adjlist = new ArrayList[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1) {
                    adjlist[i].add(j);
                }
            }
        }
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i);
            answer += 1;
        }

        return answer;
    }

    private static void dfs(int now) {
        visited[now] = true;
        for (int next : adjlist[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}