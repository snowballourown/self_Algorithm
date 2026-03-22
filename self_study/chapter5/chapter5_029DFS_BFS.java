package self_study.chapter5;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class chapter5_029DFS_BFS {
    static boolean visited[];
    static ArrayList<Integer> A[];
    static int N; // node 수
    static int M; //edge 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        int start = Integer.parseInt(stn.nextToken());
        visited = new boolean[N+1];
        A = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            A[s].add(e);// 여기서 초과하는구나
            A[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        DFS(start);
        System.out.println();
        visited = new boolean[N + 1];



    }

    static public void DFS(int i) {
        if (visited[i]) {  return;      }
        visited[i] = true;

        for (int j : A[i])
        {  if (!visited[j]) DFS(j);  }
    }


    static public void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            System.out.println(now_Node + " ");
            for (int i : A[now_Node]) {
                if (!visited[i]) { // 방문을 확인하는겸 꺼내서 짚어넣음
                    visited[i] = true;
                    queue.add(i );
                }
            }
        }
    }
}
