package CodingTest.Programer_2.greedy;

import java.util.*;

public class somConnection {

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        boolean[] visited = new boolean[n];

        PriorityQueue<Node> queue =
                new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        int sum = 0;
        int count = 0;

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.to]) { // 출발지가 방문한 적있으면 페스
                continue;
            }

            visited[node.to] = true;
            sum += node.cost;
            count++;

            if (count == n) { // 마지막 node 이면 페스
                break;
            }

            for (int[] cost : costs) { // 다음 행선지 비교 대상 넣기
                int start = cost[0];   //  시작 지점
                int end = cost[1];  // 마지막 지점
                int edgeCost = cost[2]; //  비용

                if (start == node.to && !visited[end]) {  // 방문하지않은 도착지점
                    queue.add(new Node(end, edgeCost));
                } else if (end == node.to && !visited[start]) { // 방문하지않은 출발지점
                    queue.add(new Node(start, edgeCost));
                }
            }
        }

        return sum;
    }
}