package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_PPRATICE_0426 {


    static boolean visited[];
    static ArrayList<Integer>[] array;
    static ArrayList<Integer> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken()); // node
        int M = Integer.parseInt(stn.nextToken()); // edge
        int start = Integer.parseInt(stn.nextToken()); // start

        array = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            // 리스트 초기화해줌
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(stn.nextToken());
            int E = Integer.parseInt(stn.nextToken());
            array[A].add(E);
            array[E].add(A);
        }
        
        

    }


    void DFS(int i) {

        System.out.print(i + " ");
        visited[i] = true;
        for (int b : array[i]) {
            if (!visited[b]) {
                DFS(b);

            }
        }
    }
}
