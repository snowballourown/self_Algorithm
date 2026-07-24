package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReHamberdiet {

    static int [] score;
    static int [] kal;
    static int L;
    static int N;
    static  int max;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++)
        {
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stn.nextToken());
            L = Integer.parseInt(stn.nextToken()); // 한도 칼로리


            score = new int[N];
            kal = new int[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer stn1 = new StringTokenizer(br.readLine(), " ");
                score[j] = Integer.parseInt(stn1.nextToken());
                kal[j] = Integer.parseInt(stn1.nextToken());
            }
            DFS(0,0,0);
            System.out.println(max);
        }

    }

    static void DFS(int scoreSum, int kalSum, int j) {

        if (kalSum > L) { // 현재 값이랑
            return;
        }

        if (j == N) {
            max = Math.max(scoreSum, max);
            return;
        }


        // 선택하는경우랑
        DFS(scoreSum + score[j], kalSum + kal[j], j + 1);
        // 선택하지않는경우
        DFS(scoreSum, kalSum, j + 1);

    }

}
