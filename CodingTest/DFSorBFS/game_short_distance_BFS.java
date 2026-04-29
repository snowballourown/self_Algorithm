package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class game_short_distance_BFS {

    public int solution(int[][] maps) {

        //최대한 빨리 도착하는 것이 유리함 -> 최단거리인뎨? BFS로가야지
        //갈수있는곳과 갈수없는 곳을 체크해야겠네? -> 그리고 방문했던곳을 가면안되고

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});  // 초기값을 설정함
        int n = maps.length;
        int m = maps[0].length;
        boolean[][]visited = new boolean[n][m];
        int []dx = {1, -1, 0, 0};
        int []dy = {0,0,1,-1};
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int []cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];

            if (x == n - 1 && y == m - 1) {
                return dis;
            }


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < n  && ny < m && 0 <= nx && 0 <= ny)
                {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int []{nx, ny, dis + 1});
                    }
                }
            }

        }






        return -1;
    }






}
