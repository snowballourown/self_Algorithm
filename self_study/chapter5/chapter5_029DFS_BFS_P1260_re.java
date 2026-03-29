package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class chapter5_029DFS_BFS_P1260_re {
    static  ArrayList<Integer>[]  A;
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        int start = Integer.parseInt(stn.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
           Collections.sort(A[i]); }


        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);



    }


    static void DFS(int Node) {

        System.out.print(Node + " ");
        visited[Node] = true;

        for (Integer integer : A[Node]) {
            if (!visited[integer]) {
                DFS(integer);
            }
        }
    }


    static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;
        while (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.print(number + " ");
            for (int a : A[number]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }

}
