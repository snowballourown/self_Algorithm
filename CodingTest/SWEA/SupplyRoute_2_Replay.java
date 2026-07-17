package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SupplyRoute_2_Replay {


    static int N;
    static int[][] number;
    static int[][] dist;

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int cost;

        public Node(int y, int x, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }



        public static void main(String[] args) throws IOException {

            StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC = Integer.parseInt(br.readLine());

            for (int i = 0; i < TC; i++) {
                    N = Integer.parseInt(br.readLine());

                    number = new int[N][N];
                dist = new int[N][N];
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        String a = br.readLine();
                        for (int k = 0; k < N; k++) {
                            number[j][k] = a.charAt(k) - '0';
                            dist[j][k] = Integer.MAX_VALUE;
                        }
                    }
                    // 최적의 경로가 아닌
                    // 최저의 비용을 계산하는 문제이기 dijacktree를 사용


                    int answer = dijkstra();


                sb.append("#" + (i + 1) + " " + answer +  "\n");

            }
            System.out.println(sb);
        }






    static int dijkstra() {
        dist[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        while (!pq.isEmpty()) {
            Node now = pq.poll();


            if (now.cost > dist[now.y][now.x]) { //최적의 비용보다 크다면 굳이 계산 ㄴㄴ
                continue;
            }

            if (now.x == N - 1 && now.y == N - 1) {
                return dist[now.y][now.x];
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }

                int nextCost = number[ny][nx] + now.cost;

                if (nextCost < dist[ny][nx]) {
                    dist[ny][nx] = nextCost;
                    pq.add(new Node(ny, nx, nextCost));
                }

            }





        }


        return dist[N - 1][N - 1];
    }
}
