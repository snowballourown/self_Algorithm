package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProgramVerify {

    static int row, col;
    static char[][] command;

    // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};


    static class Node {
        int y, x, dir, memory;

        Node(int y, int x, int dir, int memory) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.memory = memory;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            command = new char[row][col];

            for (int i = 0; i < row; i++) {
                String s = br.readLine();
                for (int j = 0; j < col; j++) {
                    command[i][j] = s.charAt(j);
                }
            }

            boolean result = bfs();

            sb.append("#").append(tc).append(" ");
            sb.append(result ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static boolean bfs() {

        boolean[][][][] visited = new boolean[row][col][4][16];
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(0, 0, 0, 0)); // 시작: (0,0), 오른쪽, 메모리 0
        visited[0][0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            char c = command[now.y][now.x];

            if (c == '@') {
                return true;
            }

            if (c == '?') {
                for (int d = 0; d < 4; d++) {
                    move(now.y, now.x, d, now.memory, visited, q);
                }
                continue;
            }

            int nextDir = now.dir;
            int nextMemory = now.memory;

            if (c == '>') {
                nextDir = 0;
            } else if (c == 'v') {
                nextDir = 1;
            } else if (c == '<') {
                nextDir = 2;
            } else if (c == '^') {
                nextDir = 3;
            } else if (c == '_') {
                nextDir = now.memory == 0 ? 0 : 2;
            } else if (c == '|') {
                nextDir = now.memory == 0 ? 1 : 3;
            } else if (c >= '0' && c <= '9') {
                nextMemory = c - '0';
            } else if (c == '+') {
                nextMemory = (now.memory + 1) % 16;
            } else if (c == '-') {
                nextMemory = (now.memory + 15) % 16;
            }

            move(now.y, now.x, nextDir, nextMemory, visited, q);
        }

        return false;
    }

    static void move(int y, int x, int dir, int memory,
                     boolean[][][][] visited, Queue<Node> q) {

        int ny = (y + dy[dir] + row) % row;   //해당 방향에 맞게 이동
        int nx = (x + dx[dir] + col) % col; // 행과 열을 더하는이유는 음수가되는것을 막을려고  if ) 0 + -1수도있으니까

        if (!visited[ny][nx][dir][memory]) {
            visited[ny][nx][dir][memory] = true;
            q.add(new Node(ny, nx, dir, memory));
        }
    }


}
