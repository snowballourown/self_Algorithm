package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Re_N_Queen {



    static int N;
    static boolean [] col;
    static boolean [] dia1;
    static boolean [] dia2;
    static int answer;


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++)
        {
            answer = 0;
            N = Integer.parseInt(br.readLine()); // N을 만나기

            dia1 = new boolean[2 * N -1];
            dia2 = new boolean[2 * N -1];
            col = new boolean [N];
            BackTracking(0);


            sb.append("#" + (i + 1) + " " + answer + "\n");
        }
        System.out.println(sb);
    }



    static void BackTracking(int row) {

        if (row == N) {
            answer++;
            return; }


        for (int i = 0; i < N; i++) {

            if (col[i] || dia1[row + i] || dia2[row - i + N - 1]) { // 해당 컬럼에 i가 들어왔음
                continue; } // 해당 DFS은 자동으로 짤림

            col[i] = true; // 컬럼이 같음
            dia1[row + i] = true; // 왼쪽 대각선은 합이 같음
            dia2[row - i + N - 1] = true; //오른쪽 대각선은 차이가 같음

            BackTracking(row + 1);


            col[i] = false;
            dia1[row + i] = false; // 왼쪽 대각선은 합이 같음
            dia2[row - i + N - 1] = false; //오른쪽 대각선은 차이가 같음


        }














    }
}
