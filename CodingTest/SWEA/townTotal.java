package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class townTotal {

    static boolean visited[] ;
    static ArrayList<Integer>[] arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(stn.nextToken()); // vertex갯수
            int M = Integer.parseInt(stn.nextToken()); // edge 갯수

            visited = new boolean[N+1];
            arrayList = new ArrayList[N+1];

            for (int j = 0; j < N+1; j++) {
                arrayList[j] = new ArrayList<>();
            }



            for (int j = 0; j < M; j++) {
               stn = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(stn.nextToken());
                int e = Integer.parseInt(stn.nextToken());
                arrayList[s].add(e);
                arrayList[e].add(s);
            }
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    DFS(j);
                    count++;
                }

            }


            sb.append("#" + (i + 1) + " " + count + "\n");
        }


        System.out.println(sb);

    }


    static void DFS(int i) {

        for (int k : arrayList[i]) {
            if (!visited[k]) {
                visited[k] = true;
                DFS(k);
            }

        }

    }
}
