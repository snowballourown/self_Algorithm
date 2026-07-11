package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int TC = 10;
        int[][] number = new int[101][101];
        StringTokenizer stn;

        for (int i = 1; i <= TC; i++) {
            String z = br.readLine();

            for (int j = 1; j <= 100; j++) { // 입력 부분
                stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= 100; k++) {
                    number[j][k] = Integer.parseInt(stn.nextToken());}
            }


            // 각행부분의 최대값
            // 각열부분의 최대값
            // 대각선 부분의 합
            int[] W_sum = new int[101];
            int[] H_sum = new int[101];
            int L_LEFT_sum=0; // 왼쪽 대각선
            int L_right_sum=0; // 오른쪽 대각선
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    W_sum[j] += number[j][k];
                    H_sum[j] += number[k][j];
                    if (j == k) {
                        L_right_sum += number[k][k];
                    }
                    if (k + j == 101) {
                        L_LEFT_sum += number[k][j];
                    }
                }
            }
            int max = 0;

            for (int i1 : W_sum) {
                if (max < i1) {
                    max = i1;
                }
            }
            for (int i1 : H_sum) {
                if (max < i1) {
                    max = i1;
                }
            }
            if (max < L_right_sum) {
                max = L_right_sum;
            }
            if (max < L_LEFT_sum) {
                max = L_LEFT_sum;
            }

            sb.append("#" + i + " " + max + "\n");



        }
        System.out.println(sb);
    }




}
