package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Re_Contact {
    static  ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static int max;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            int DataLength = Integer.parseInt(stn.nextToken());
            int startVertex = Integer.parseInt(stn.nextToken());

            arrayLists = new ArrayList[101];
            visited = new boolean[101];


            for (int j = 1; j <= 100; j++) {
                arrayLists[j] = new ArrayList<>();
            }

            stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < DataLength / 2; j++) {
                int s = Integer.parseInt(stn.nextToken());
                int e = Integer.parseInt(stn.nextToken());

                arrayLists[s].add(e); //바로 연결 한쪽만 연결

            }

            BFS(startVertex);
            sb.append("#" + (i + 1) + " " + max + "\n");
            

        }


        System.out.println(sb);


    }


    static void BFS(int x) { //
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);

        while (!queue.isEmpty()) {
            int size = queue.size();
             max = Integer.MIN_VALUE;

            for (int j = 0; j < size; j++) { // 현재존재하는 갯수 반복
                int now = queue.poll();
                max = Math.max(max, now);

                for (int i : arrayLists[now]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }

        }


    }
}
