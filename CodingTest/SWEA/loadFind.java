package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class loadFind {

    static List<Integer>[] lists;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // vertex
        //

        for (int i = 0; i < 10; i++) {
            lists = new ArrayList[101];
            answer =0;
            for (int j = 0; j <= 100; j++) {
                lists[j] = new ArrayList<>();
            }

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            int tc = Integer.parseInt(stn.nextToken());
            int length = Integer.parseInt(stn.nextToken());

            stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                int s = Integer.parseInt(stn.nextToken());
                int e = Integer.parseInt(stn.nextToken());
                lists[s].add(e);
            }


            //0 -> 99 까지 갈수있는지

            DFS(0);

            ;


            sb.append("#" + tc + " " + answer+ "\n");


        }

        System.out.println(sb);


    }

    static void DFS(int i) {


        for (Integer integer : lists[i]) {
            if (integer == 99) {
                answer = 1;
                return;
            }

            DFS(integer);

        }



    }
}
