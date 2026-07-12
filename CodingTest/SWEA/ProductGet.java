package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProductGet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }

            int mid = N / 2; // 행의 중심 부분
            int sum = 0;

            for (int row = 0; row < N; row++) {
                int dist = Math.abs(mid - row); //

                int start = dist;       // 행의 도입부분
                int end = (N - 1)- dist; // 행의 개수의 마지막

                for (int col = start; col <= end; col++) {
                    sum += farm[row][col];
                }
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}