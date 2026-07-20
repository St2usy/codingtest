package graph;

import java.util.*;

public class Delivery {
    private static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int solution(int n, int[][] road, int k) {
        ArrayList<Node>[] adjlist = new ArrayList[n + 1];
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }
        for (int[] edge : road) {
            adjlist[edge[0]].add(new Node(edge[1], edge[2]));
            adjlist[edge[1]].add(new Node(edge[0], edge[2]));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        // ArrayDeque<Node> queue = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(1, 0));
        dist[1] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (dist[now.dest] < now.cost)
                continue;

            for (Node next : adjlist[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k)
                answer++;
        }

        return answer;
    }

}
