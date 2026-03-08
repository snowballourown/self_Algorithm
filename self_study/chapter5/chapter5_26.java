package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter5_26 {
    static boolean[] visited;
    static int[] array;
    static int M;
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        visited = new boolean[N];
        array = new int[N];
        backtracking(0);

    }


    private static void backtracking(int length) {
        if (length == M) {
            printArray();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {

                visited[i] = true;
                array[length] = i;  // 해당 배열에다가 i를 넣어버림
                backtracking(length + 1);
                visited[i] = false;

            }
        }
    }



    private static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.println(array[i] + 1 + " ");
        }
    }

}
