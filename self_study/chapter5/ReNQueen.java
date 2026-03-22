package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReNQueen {
    static int[] A;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        //배열을 만들음, index 랑 그안에 값을 넣는 위치를 만듬
        //depth만 체크 하셈
        //check 함수 만들어서 같은 행렬이랑 대각선에 해당하는 값이 있는지 산출
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        backtracking(0);
        System.out.println(cnt);

    }

    static public void backtracking(int i) {
        if (i == N) {
            cnt++;
            return;
        }


        for (int j = 0; j < N; j++) {// 열에 넣을 자리를 찾는거임
            A[i] = j;
            if (check(j)) { // 행체크 여기안에 들어가는게 열이야
                backtracking(i + 1); }
        }
    }

    static public boolean check(int j) {
        //같은행 인지 확인
        // 열이야
        for (int i = 0; i < N; i++) {
            if (A[j] == A[i]){  return false;} // 열있는애를 차는거임 ->  행은 굳이 안차아도되고
            if (Math.abs(j - i) == Math.abs(A[i] - A[j])) return false;
        }
        //대각선 인지 확인
        return true;
    }


}
