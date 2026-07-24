package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {


    static int N;
    static int answer = 0;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
             N = Integer.parseInt(br.readLine());
            answer =0;

            col = new boolean[N];
            diag1 = new boolean[2 * N - 1];// 최대값이 row 와 col n-1 n-1  2n-2
            diag2 = new boolean[2 * N - 1];//

            DFS(0);


            System.out.println("#" + (i + 1) + " " + answer);

        }

    }

    static void DFS(int row) {
        if (row == N) {
            answer++;
            return;
        }

        // 현재 행에서 모든열 탐색
        for (int i = 0; i < N; i++) {


            if (col[i] || diag1[row + i] || diag1[row - i + N - 1]) { // 같은 대각선 나오면 패스
                continue;
            }

            // 퀸놓기
            col[i] = true;
            diag1[row + i] = true;  // 왼쪽대각선 합이 같음
            diag2[row - i  + N - 1]= true; // 오른쪽 대각선   차이가 같음
            // 같은 대각선들을 이걸로 구별하는거임
            DFS(row + 1);

            // 원상복구(백트래킹)
            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + N - 1] = false;
        }




    }



}

