package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS2 {

    static public ArrayList<Integer>[] A;
    static public boolean B[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());

        A = new ArrayList[N + 1];
        B = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            A[s].add(e); // 양옆에 추가하는 이유는서로 표시해주지않으면 이동시 접근했는지 안했는지 알수없음
            A[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if (B[i] == false) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }


    static public void DFS(int i) {
        if (B[i] == true) {
            return;
        }

        B[i] = true;
            // i에 false인게 온거가 rmf

        for (int j : A[i]) {
            if (!B[j]) { // false인걸 탐지해짢아?
                DFS(j);;
            }
        }







    }
}
