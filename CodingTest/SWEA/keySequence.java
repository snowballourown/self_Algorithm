package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class keySequence {

    static boolean visited[];
    static ArrayList<Integer>[] arrayLists ;
    static ArrayList<Integer>[] reversList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {


            int N = Integer.parseInt(br.readLine()); // 학생들수
            int M = Integer.parseInt(br.readLine());//  학생 숫자 비교
            arrayLists = new ArrayList[N + 1];
            reversList = new ArrayList[N + 1];

            for (int j = 0; j <= N; j++) {
                arrayLists[j] = new ArrayList<>();
                reversList[j] = new ArrayList<>();
            }


            for (int j = 0; j < M; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(stn.nextToken());
                int e = Integer.parseInt(stn.nextToken());

                arrayLists[s].add(e);
                reversList[e].add(s);
            }

            int count= 0;
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N+1]; // 초기화
                int taller  = DFS(j, arrayLists )-1;

                visited = new boolean[N+1]; // 초기화
                int shorter  = DFS(j, reversList )-1;

                if (taller + shorter == N - 1) {
                    count++;
                }
            }

            sb.append("#" + (i+1) +" "+ count + "\n");
        }


        System.out.println(sb);




    }


    static int DFS(int j, ArrayList<Integer>[] arrayLists) {

        visited[j] = true;
        int count = 1;
        for (int a : arrayLists[j]) {

            if (!visited[a]) {
                 count += DFS(a,arrayLists);
            }

        }




        return  count;
    }
}
