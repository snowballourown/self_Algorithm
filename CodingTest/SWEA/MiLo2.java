package CodingTest.SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MiLo2 {

    static int path[][];
    static boolean [][] visited;
    static int N;
    static class Node {
    int x;
    int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
           int tc = Integer.parseInt(br.readLine());

            N = 100;

            path = new int[N + 1][N + 1];
            visited = new boolean[N + 1][N + 1];
            int start_x = 0;
            int start_y = 0;
            for (int j = 1; j <= N ; j++) {
                String s =br.readLine();
                for (int k = 0; k < N ; k++) {
                    path[j][k] = s.charAt(k) - '0';

                    if (path[j][k] == 2) {
                        start_x = k;
                        start_y = j;
                    }

                }
            }

            int answer = BFS(start_y, start_x);



            //BFS로?
            sb.append("#" + tc + " " + answer + "\n");

        }
        System.out.println(sb);

    }


    static  int BFS(int start_y, int start_x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start_y, start_x));

        int nx[] = {0, 0, 1, -1};
        int ny[] = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.y][node.x] || path[node.y][node.x] == 1 ) {
                continue;
            }

            if (path[node.y][node.x] == 3) {
                return 1;
            }


            for (int i = 0; i < 4; i++) {
                int dx = node.x + nx[i];
                int dy = node.y + ny[i];

                if (dx > N || dy > N || dx <= 0 || dy <= 0) {
                    break;
                }

                visited[node.y][node.x] = true;


                queue.add(new Node(dy, dx));



            }







        }


        return  0;
    }



}
