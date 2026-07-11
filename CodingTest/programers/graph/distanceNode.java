package CodingTest.programers.graph;


import java.util.*;

public class distanceNode {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int[] distance;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];

            graph[s].add(e);
            graph[e].add(s);
        }

        BFS(1);

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (max < distance[i]) {
                max = distance[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == max) {
                answer++;
            }
        }

        return answer;
    }

    void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
