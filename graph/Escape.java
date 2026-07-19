package graph;

import java.util.*;

public class Escape {

    public static void main(String[] args) {

    }

    private static final int[] dx = { 0, 0, 1, -1 };
    private static final int[] dy = { 1, -1, 0, 0 };

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static char[][] map;
    private static int N, M;

    public static int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        Node start = null;
        Node end = null;
        Node lever = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S')
                    start = new Node(i, j);
                else if (map[i][j] == 'E')
                    end = new Node(i, j);
                else if (map[i][j] == 'L')
                    lever = new Node(i, j);
            }
        }

        int startlever = bfs(start, lever);
        int leverend = bfs(lever, end);

        if (startlever == -1 || leverend == -1)
            return -1;
        else
            return startlever + leverend;
    }

    private static int bfs(Node start, Node end) {
        int[][] dist = new int[N][M];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        dist[start.r][start.c] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if (dist[nr][nc] > 0)
                    continue;

                if (map[nr][nc] == 'X')
                    continue;

                dist[nr][nc] = dist[now.r][now.c] + 1;

                queue.add(new Node(nr, nc));

                if (nr == end.r && nc == end.c) {
                    return dist[end.r][end.c] - 1;
                }
            }
        }

        return -1;
    }
}
