package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class inOrder {

    static  int N ;
    static ArrayList<Integer>[] arrayLists;
    static StringBuilder sb = new StringBuilder();
    static String[]word;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {


         N = Integer.parseInt(br.readLine());

         arrayLists = new ArrayList[N+1];

        word = new String[N+1]; // N

        for (int j = 0; j < N+1; j++) {
            arrayLists[j] = new ArrayList<>();
        }

        for (int j = 0; j < N; j++) {

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stn.nextToken());
            word[start] = stn.nextToken();

            while (stn.hasMoreTokens()) {
                arrayLists[start].add(Integer.parseInt(stn.nextToken()));
            }
        }

            sb.append("#" + (i + 1) + " ");
            DFS(1);
            sb.append("\n");


        }
        System.out.println(sb);
    }


    static void DFS(int i) {

        if (arrayLists[i].size() >= 1) {
            DFS(arrayLists[i].get(0));
        }
        sb.append(word[i]);

        if (arrayLists[i].size() >= 2) {
            DFS(arrayLists[i].get(1));
        }

    }
}
