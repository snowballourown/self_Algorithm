package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chapter5_27_NQueen {
    static int[] A;
    static int N;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        //  NxN를 할 N값을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }


    private static void backtracking(int row) {


        if (row == N) { //행 이 N까지 다내려간경우
            cnt++;
            return;
        }


        for (int i = 0; i < N; i++) {
            A[row] = i;
            if (check(row)) {
                backtracking(row+1);
            }
        }

    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == A[row]) return false; // 열이 같은게 존재하는지 확인
            if (Math.abs(row - i) == Math.abs(A[i] - A[row])) return false;// 여기서 알아야할게 대각선은 행과 열의 차가 같다
        }
        return true;
    }


}
