package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HambugarDiet {

    static  int max;


    static int [][] num;
    static int L;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            max= 0;
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
             N = Integer.parseInt(stn.nextToken()); // 재료의 개수
            L = Integer.parseInt(stn.nextToken()); // 재료의 한도 칼로리

            // 재료의 한도 칼로리안에서  점수를 가장 높게할수있는 조합을 찾아서 점수를 내보시요

            num = new int[N][2];
            StringTokenizer stn_1;
            for (int j = 0; j < N; j++) { // 0열 = 점수  1열은 칼로리 //일단 점수 받기
                stn_1 = new StringTokenizer(br.readLine(), " ");
                    num[j][0] = Integer.parseInt(stn_1.nextToken()); // 점수
                    num[j][1] = Integer.parseInt(stn_1.nextToken()); // 칼로리
            }

            // 조합 찾는거라 DFS + backTracking 밖에 생각이안남


            BackTracking(0,0,0);
            sb.append("#" + (i+1) + " " + max + "\n");
        }

        System.out.println(sb);


    }

    static public void BackTracking(int j, int currentSum,int scoreSum) { //현재 합할 값


        if ( currentSum > L) {
            return;
        }


        if (j == N) {
            max = Math.max(max, scoreSum);
            return;
        }

        BackTracking(j + 1, currentSum + num[j][1], scoreSum + num[j][0]);
        BackTracking(j + 1, currentSum , scoreSum);





    }
















}
