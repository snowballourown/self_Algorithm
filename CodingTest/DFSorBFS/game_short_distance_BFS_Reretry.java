package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class game_short_distance_BFS_Reretry {

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;


        while (!queue.isEmpty())
        {
            int a[] = queue.poll();
            int x = a[0];
            int y = a[1];
            int distance = a[2];

            if ((x == n - 1) && (y == m - 1))
            { return distance;}

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < n && ny < m && 0 <= ny && 0 <= nx) {//
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, distance + 1});
                    }
                }


            }

        }

        return -1;
    }


}
