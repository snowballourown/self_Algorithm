package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking_NM {

    static int M;
    static int N;
    static int []S;
    static boolean []V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
         N = Integer.parseInt(stn.nextToken());
         M = Integer.parseInt(stn.nextToken());
        S = new int[M];
        V = new boolean[N];
        backTracking(0);
    }


    static void backTracking(int length) {
        if (length == M) {
            printArray();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;
                S[length] = i;
                backTracking(length + 1);
                V[i] = false;
            }
        }



    }

    static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(S[i] + 1 + " ");
        }
        System.out.println();
    }
}
