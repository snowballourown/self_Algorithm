package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class MineSweeperFind {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] mineCount;

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new char[N][N];
            visited = new boolean[N][N];
            mineCount = new int[N][N];

            for (int y = 0; y < N; y++) {
                String line = br.readLine();
                for (int x = 0; x < N; x++) {
                    map[y][x] = line.charAt(x);
                }
            }

            calculateMineCount();

            int answer = 0;

            // 1. 주변 지뢰가 0개인 칸부터 클릭
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] != '*' && !visited[y][x] && mineCount[y][x] == 0) {
                        bfs(y, x);
                        answer++;
                    }
                }
            }

            // 2. 아직 열리지 않은 숫자 칸들은 각각 한 번씩 클릭
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] != '*' && !visited[y][x]) {
                        answer++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static void calculateMineCount() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '*') continue;

                int count = 0;

                for (int d = 0; d < 8; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                    if (map[ny][nx] == '*') {
                        count++;
                    }
                }

                mineCount[y][x] = count;
            }
        }
    }

    static void bfs(int startY, int startX) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            // 숫자 칸이면 주변으로 더 퍼지지 않음
            if (mineCount[y][x] != 0) continue;

            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == '*') continue;

                visited[ny][nx] = true; // 0이 아닌경우일경우 방문을했던건 추가

                if (mineCount[ny][nx] == 0) { // 0인경우만 추가
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }




}