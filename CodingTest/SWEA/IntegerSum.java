package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long answer = 0;

            for (int cdSum = 2; cdSum <= 2 * N; cdSum++) { //cd합을 올림
                int abSum = cdSum + K; // a + b = k + c + d

                if (abSum < 2 || abSum > 2 * N) {  // a+b 각각 1이상이기에 넘어야함  && a,b가 최대 2N이상이면안도기ㅣ에 패스
                    continue;
                }

                answer += countPair(N, cdSum) * countPair(N, abSum);
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }




    static long countPair(int N, int sum) {
//        이건 1 ~ N 사이의 두 숫자로 sum을 만드는 경우의 수를 구하는 함수야.
        if (sum <= N + 1) {
            return sum - 1;
        }
        return 2L * N + 1 - sum;
    }
}