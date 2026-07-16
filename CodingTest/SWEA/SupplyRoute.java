package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SupplyRoute {
    static int N;
    static int[][] map;
    static int[][] dist;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int y, x, cost;

        Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for (int y = 0; y < N; y++) {
                String line = br.readLine();

                for (int x = 0; x < N; x++) {
                    map[y][x] = line.charAt(x) - '0';
                    dist[y][x] = Integer.MAX_VALUE;
                }
            }

            int answer = dijkstra();

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll(); //

            if (now.cost > dist[now.y][now.x]) continue;
            // 현재노드를 계산해봤자  다른녀석으로 이동해서 한녀석이 저렴할
            //거기에 시도조차 못하게 막음

            if (now.y == N - 1 && now.x == N - 1) { // 끝까지 도달했기에 return
                return now.cost;
            }

            for (int d = 0; d < 4; d++) { // 상항좌우 이동 하는방법
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                int nextCost = now.cost + map[ny][nx];

                if (nextCost < dist[ny][nx]) { // 비용계산  먼저 간녀석들이  dist로 계산해놓은 녀석보다 작다면 nextnode로 최신화
                    dist[ny][nx] = nextCost;
                    pq.offer(new Node(ny, nx, nextCost)); // 먼저간녀석들보다 작다면 offer로 넣어놓음
                }
            }



        }

        return dist[N - 1][N - 1];
    }
}