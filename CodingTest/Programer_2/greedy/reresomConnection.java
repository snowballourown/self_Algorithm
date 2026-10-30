package CodingTest.Programer_2.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class rereSomconnection {


    class Node {

        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }



    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2])); //  cost 낮은순으로 배열을함

        int count = 0 ; //  갯수를 다세면 종료할려고 표시
        int sum = 0 ;  // 비용 더하는용

        Queue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        queue.add(new Node(costs[0][0], 0));

        boolean[] visited = new boolean[n];


        while (!queue.isEmpty()) {
            Node node = queue.poll();


            if (visited[node.to]) {
                continue;
            }


            sum += node.cost;
            visited[node.to] = true;
            count++;

            if (count == n) { // prim으로 다 정렬 끝임
                break;
            }


            for (int[] cost : costs) {
                int start = cost[0];
                int end  = cost[1];
                int edgeCost = cost[2];

                if (start == node.to && !visited[end]) {
                    queue.add(new Node(end, edgeCost));
                } else if (end == node.to && !visited[start]) {
                    queue.add(new Node(start, edgeCost));
                }
            }
        }

        return sum;
    }



}
