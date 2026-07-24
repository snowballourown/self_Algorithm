package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMagnetic {
    static int[][] num;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer TC = 10;

        for (int i = 0; i < TC; i++) {


            int N = Integer.parseInt(br.readLine());
            num = new int[N][N];


            for (int j = 0; j < N; j++) { // 데이터 입력
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) {
                    num[j][k] = Integer.parseInt(stn.nextToken());
                }
            }



            // 상태로 입력 받고 그걸로 하는거임
            int answer = 0;

            for (int j = 0; j < N; j++) {
                boolean has_state = false;
                for (int k = 0; k < N; k++) {
                    if (num[k][j] == 1) {
                        has_state = true;
                    }

                    if (num[k][j] == 2) {
                        if (has_state) {
                            answer++;
                            has_state = false;
                        }
                    }


                }
            }


            sb.append("#" + (i + 1) + " " + answer + "\n");

        }

        System.out.println(sb);

    }



}
