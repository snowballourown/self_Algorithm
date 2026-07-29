package CodingTest.SWEA;

import java.io.*;
import java.util.*;

public class ToOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            long[] x = new long[N];
            long[] y = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            boolean[] visited = new boolean[N];
            long[] minDist = new long[N];
            Arrays.fill(minDist, Long.MAX_VALUE); //최대값으로 다채움

            minDist[0] = 0; // 0부터 시작하니까 0끼리는 인듯
            long total = 0;

            for (int i = 0; i < N; i++) {

                int minIndex = -1;
                long minValue = Long.MAX_VALUE; //초기화

                for (int j = 0; j < N; j++) {
                    if (!visited[j] && minDist[j] < minValue) { //방문하지 않아쓰면서 거리가 최소인것들을 찾는거임
                        minValue = minDist[j]; // 맨터음에 minvalue다시 0으로 들어감
                        minIndex = j; // 0
                    }
                }

                visited[minIndex] = true;
                total += minValue; // 굳이 따지면 이순간에 이동하는거로 생각하면되겠네

                for (int j = 0; j < N; j++) {
                    if (!visited[j]) { //새로 추가된 index에 가서 길이를 잰다 그리고 최소길이이라면 기록한다.
                        long dx = x[minIndex] - x[j];  // x 축차이
                        long dy = y[minIndex] - y[j]; // y축차이
                        long dist = dx * dx + dy * dy;

                        if (dist < minDist[j]) { //여기서 max였던 애들의 거리를 0에서부터의 거리로 바꿈
                            minDist[j] = dist;
                        }
                    }
                }
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(Math.round(total * E))
                    .append("\n");
        }

        System.out.print(sb);
    }
}