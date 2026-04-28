package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class game_short_distance_BFS {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // x, y, 거리

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) { // 상하좌우 다 한번씩ㄱ가봄
                int nx = x + dx[i]; //  좌표 더함 (1,-1,0,0)
                int ny = y + dy[i]; // 좌표더함 (0,0,1,-1)

                // 범위 체크 + 길 + 방문 안한 곳
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) { // n,m를 초과하지않게
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) { // 갈수있는길인가 check + 왔던곳인가를 체크
                        visited[nx][ny] = true; // 왔던곳인걸 체크하고
                        queue.offer(new int[]{nx, ny, dist + 1}); // 가도되는길이기에 ㄱㄱ
                    }
                }
            }
        }

        return -1; // 도달 불가
    }
}
