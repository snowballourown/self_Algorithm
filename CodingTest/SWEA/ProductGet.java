package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductGet {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] number = new int[N][N];

            for (int j = 0; j < N; j++) {
                String string= br.readLine();
                for (int k = 0; k < N; k++) {
                    number[j][k]= string.charAt(k) - '0'; //
                }
            }

            int center  = N/2;
            int sum =0;
            for (int row = 0; row < N; row++) {
                int dist = Math.abs(center - row); // row가 커질시점부터는 중앙을 지나기에 그다음을 생각하면됨
                int end = N -1 - dist; // 뒤에서 dist만큼  뺴는거임

                for (int colum = dist; colum <= end; colum++) {
                    sum += number[row][colum];
                }

            }


            sb.append("#" + (i + 1) + " " + sum + "\n");



        }
        System.out.println(sb);
    }
}