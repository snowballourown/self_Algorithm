package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re_Square {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {

            int N = Integer.parseInt(br.readLine());

            int[] row = new int[N*N +1];
            int[] col = new int[N*N +1];

            for (int j = 0; j < N; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    int value = Integer.parseInt(stn.nextToken());
                    row[value] = j; // 값에 행을 입력해
                    col[value] = k; // 값에 열을 입력해

                }
            }

            int answerRoom = 1;
            int answerLength = 1;
            int length=1;
            int start =1;



             for (int j = 0; j < N * N; j++) {
                int dist =  Math.abs(row[j] - row[j + 1])
                        + Math.abs(col[j] - col[j + 1]);
                // 얼마나 떨어져있는지 확인하는거임
                // 여기서 값이 1정도 떨어져있는지 && 바로옆에붙어있는지
                if (dist == 1) {

                    length++;

                } else {
                    if (length > answerLength) {
                        answerLength = length;
                        answerRoom = start;
                    }

                    start = j +1;
                    length = 1;
                }
            }


            if (length > answerLength) {
                answerLength =length;
                answerRoom = start;
            }

            sb.append("#")
                    .append(TC)
                    .append(" ")
                    .append(answerRoom)
                    .append(" ")
                    .append(answerLength)
                    .append("\n");






        }
        System.out.println(sb);

    }
}
