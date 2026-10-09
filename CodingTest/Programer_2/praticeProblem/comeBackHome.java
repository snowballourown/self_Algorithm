package CodingTest.Programer_2.praticeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class comeBackHome {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {// 연결 과정
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        // -1: 아직 방문하지 않았거나 도달할 수 없는 지역
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 목적지를 넣음

            for (int next : graph[current]) { // 목적지랑 연결된곳
                if (distance[next] != -1) { //
                    // 거리가 -1 아니라면 무시
                    // 초기화 한번이라도 됐다면 무시
                    continue;
                }

                distance[next] = distance[current] + 1; // 목적지 다음에 +1
                queue.offer(next);// 연결된 다음곳들
            }
        }

        int[] results = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            results[i] = distance[sources[i]];
        }

        return results;
    }
}