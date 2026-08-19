package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class reOptimalPath {

     static  boolean visited[];
     static int answer;
     static int x[];
     static int y[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++) {
            answer = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N+2];
            x = new int[N+2];
            y = new int[N+2];

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            // 회사
            x[0] = Integer.parseInt(stn.nextToken());
            y[0] = Integer.parseInt(stn.nextToken());

            // 집
            x[1] = Integer.parseInt(stn.nextToken());
            y[1] = Integer.parseInt(stn.nextToken());


            for (int j = 2; j < x.length; j++) {
                x[j] = Integer.parseInt(stn.nextToken());
                y[j] = Integer.parseInt(stn.nextToken());
            }


            DFS(0,0,0);

            sb.append("#" + (i + 1) + " " + answer + "\n");
        }

        System.out.println(sb);



    }


    static void DFS(int i, int sum, int path) { // i = 현재 위치 용

        if (sum >= answer) {
            return;
        }

        if (path == visited.length - 2) {
            sum += distance(i, 1);
            answer = Math.min(answer, sum);

            return;
        }



        for (int j = 2; j < visited.length; j++) {

            if (!visited[j]) {
                visited[j] = true;
                DFS(j, sum + distance(i, j) , path+1);
                visited[j] = false;
            }

        }





    }


    static int distance(int current,int index) {
       return Math.abs(x[current] - x[index]) + Math.abs(y[current] - y[index]);
    }
}
