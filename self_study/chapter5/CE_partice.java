package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CE_partice {
    static ArrayList<Integer>[] A;
    static boolean [] B ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());

        for (int i = 0; i < M; i++) {
            A[i] = new ArrayList<>();
        }
        B = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if (!B[i]) {
                count++;
                DFS(i);
            }
        }
    }


    static void DFS(int s) {
        if (B[s] == true) {
            return;
        }
        B[s] = true;
        for (int e : A[s]) {
            if (B[e] == false) // 이걸안하면 무한 ㄴ반복이야
                DFS(e);
        }
    }
}
