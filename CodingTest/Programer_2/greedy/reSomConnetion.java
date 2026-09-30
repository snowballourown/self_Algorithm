package CodingTest.Programer_2.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class reSomConnetion {

    class Node {

        int cost;
        int to;

        public Node(int to, int cost) {
            this.cost = cost;
            this.to = to;
        }

    }

    public int solution(int n, int[][] costs) {


        Queue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        boolean  [] visited = new boolean[n];

        int count = 0;
        int sum = 0;


        queue.add(new Node(0, 0));


        while (!queue.isEmpty()) {

            Node node = queue.poll();


            if (visited[node.to]) {
                continue;
            }

            count++;
            sum += node.cost;
            visited[node.to] = true;

            if (n == count) {
                break;
            }


            for (int[] cost : costs) {
                int start = cost[0];
                int end = cost[1];
                int edgeCost = cost[2];

                if (end == node.to && !visited[end]) {
                    queue.add(new Node(end, edgeCost));
                } else if (start == node.to && !visited[start]) {
                    queue.add(new Node(start, edgeCost));
                }
            }

        }



        return sum;

    }
}
