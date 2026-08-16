package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class optimalPath {
    static int x[];
    static int y[];
    static int N;
    static boolean visited[];

    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            answer = Integer.MAX_VALUE;
            //consumer
            N = Integer.parseInt(br.readLine());
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            //방문해야되는 위치
            x= new int[N+2];
            y = new int[N+2];
            visited = new boolean[N + 2];
            //DFS에 backtracking으로 가야할듯?

            x[0] = Integer.parseInt(stn.nextToken());
            y[0] = Integer.parseInt(stn.nextToken());


            x[1] = Integer.parseInt(stn.nextToken());
            y[1] = Integer.parseInt(stn.nextToken());


            for (int j = 2; j < N+2; j++) {
                x[j] = Integer.parseInt(stn.nextToken());
                y[j] = Integer.parseInt(stn.nextToken());
            }



            DFS(0, 0, 0);





            sb.append("#" + (i + 1) + " " + answer + "\n");
        }
        System.out.println(sb);
        
    }


    static void DFS(int current, int count, int sum) {
        if (sum >= answer) {
            return;
        }

        if (count == N) {
            sum += distance(current, 1); // 마지막 고객 -> 집
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 2; i < N + 2; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, count + 1, sum + distance(current, i));
                visited[i] = false;
            }
        }
    }

    static int distance(int a, int b) {
        return Math.abs(x[a] - x[b]) + Math.abs(y[a] - y[b]);
    }
}
