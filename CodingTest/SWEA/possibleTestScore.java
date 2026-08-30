package CodingTest.SWEA;

import java.io.*;
import java.util.*;

public class possibleTestScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] scores = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int total = 0;
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                total += scores[i];
            }

            boolean[] possible = new boolean[total + 1];
            possible[0] = true;

            for (int score : scores) {
                for (int sum = total - score; sum >= 0; sum--) {
                    if (possible[sum]) {
                        possible[sum + score] = true;
                    }
                }
            }

            int count = 0;
            for (boolean p : possible) {
                if (p) count++;
            }

            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}