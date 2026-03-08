package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter5_26re1 {
    static boolean[] visited;
    static int[] array;
    static int M; //배열 크기
    static int N; // 숫자 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

         N = Integer.parseInt(stn.nextToken());
         M = Integer.parseInt(stn.nextToken());

        array = new int[M];
        visited = new boolean[N];

         backtracking(0
         );

    }


    static void backtracking(int length) {
        if (length == M) {
            PrintArray();
            return;
        }


        for (int i = 0; i < N; i++) {

            if (!visited[i])
            {
                visited[i] = true;
                array[length] = i;
                backtracking(length+1);
                visited[i] = false;
            }


        }




    }


    static void PrintArray() {
        for (int i : array) {
            System.out.print(i +1 + " ");


        }
        System.out.println("");
    }
}
