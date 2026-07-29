package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReToOne_Prim {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++) {

            int N = Integer.parseInt(br.readLine());
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            long x[] = new long[N];
            long y[] = new long[N];

            for (int j = 0; j < N; j++) {
                x[j] = Integer.parseInt(stn.nextToken());
            }

            stn = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                y[j] = Integer.parseInt(stn.nextToken());
            }

            int E = Integer.parseInt(br.readLine());  //입력완료

            boolean visited[] = new boolean[N];
            long minDist[] = new long[N];
            Arrays.fill(minDist, Integer.MAX_VALUE); // 초기값을 아예
            long total = 0;


            for (int k = 0; k<N; k++)
            {
                long minValue = Integer.MAX_VALUE;
                int minIndex = -1;



                for (int j = 0; j < N; j++) {
                    if (!visited[j] && minDist[j] < minValue) {
                        // 여기서 가장 작은
                        minValue = minDist[j];
                        minIndex = j;
                    }
                }

                visited[minIndex] = true;
                total += minValue;

                for (int j = 0; j < N; j++) {
                if (!visited[j])
                {
                    long dx = x[minIndex] - x[j];
                    long dy = y[minIndex] - y[j];

                    long cost = (dx * dx) + (dy * dy);


                    if (cost < minDist[j]) { // 거리가 가장 작은녀석들을 갱신
                        minDist[j] = cost;
                    }

                }

                }
            }
























        }


    }
}
