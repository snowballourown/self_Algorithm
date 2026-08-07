package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tall_samulham {

    static int tall[];
    static int B;


    static int Min ;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            Min = Integer.MAX_VALUE;
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(stn.nextToken());
             B = Integer.parseInt(stn.nextToken());

             tall = new int[N];


            stn = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                tall[j] = Integer.parseInt(stn.nextToken());
            }

            DFS(0,0);
            sb.append("#" + (i + 1) + " " + (Min - B) + "\n");




        }


        System.out.println(sb);

    }

    static void DFS(int index, int sum) {


        if (sum >= B) {
            Min = Integer.min(sum, Min);
        }

        if (index == tall.length) {
            return;
        }





        // 가져간다 안가져간다로 나눠서 하면됨


        DFS(index + 1, sum + tall[index]); // 가져가는경우
        DFS(index + 1,  sum);// 안가져가는경우





    }
}
