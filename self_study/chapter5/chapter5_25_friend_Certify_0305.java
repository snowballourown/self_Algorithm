package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chapter5_25_friend_Certify_0305 {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken()); //node
        int M = Integer.parseInt(stn.nextToken()); //edge
        arrive = false;
        A = new ArrayList[N];
        visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            A[s].add(e);
            A[e].add(s);
        }


        for (int i = 0; i < N; i++) {
            DFS(i, 1);

        }

        if (arrive) {
            System.out.println("1");;
        }
        else {
            System.out.println("0");;
        }

    }


    public static void DFS(int i, int depth) {

        if (depth == 5 || arrive) { // arrive이로 인해서 한번 찾고 다시 안내려갈수있음 그래서 arrive를쓴것
            arrive = true;
            return;
        }

        visited[i] = true;

        for (int j : A[i]) {
            if (!visited[j]) {
                DFS(j, depth + 1);
            }
        }
        visited[i] = false;


    }
}
