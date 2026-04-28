package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class game_short_distance_BFSretry {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {1, -1, 0, 0}; // 좌우
        int[] dy = {0, 0, 1, -1};// 상하

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 현재 위치 입력

        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[y];

                if (nx < n && ny < m && 0 <= nx && 0 <= ny) {
                    if (!visited[nx][ny] && (maps[nx][ny] == 1))
                    {
                        visited[nx][ny] = true; // 왔던곳인걸 체크하고
                        queue.offer(new int[]{nx, ny, dist + 1});
                    }
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
