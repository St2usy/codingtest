package graph;

import java.util.*;

public class Shortcut_in_game {

    private static final int[] rx = { 0, 0, 1, -1 };
    private static final int[] ry = { 1, -1, 0, 0 };

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        int[][] dist = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        dist[0][0] = 1;

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1) {
                    continue;
                }

                if (maps[nr][nc] == 0) {
                    continue;
                }

                if (dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.add(new Node(nr, nc));
                }
            }
        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

}