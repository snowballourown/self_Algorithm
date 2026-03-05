package self_study.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter4_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 데이터의 갯수, 질의 갯수
        int data;
        int question;
        // 구간 합을 구할 대상 배열
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        data = Integer.parseInt(stn.nextToken()) ;
        question = Integer.parseInt(stn.nextToken());
        int[][] num = new int[data+1][data+1];
        int[][] D = new int[data+1][data+1];

        // 본 내용을 입력
        for (int i = 1; i <= data; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= data; j++) {
                num[i][j] = Integer.parseInt(stn.nextToken());
            }
        }


        for (int i = 1; i <= data; i++) { // 행
            for (int j = 1; j <= data; j++) { // 열
                D[i][j] =  D[i][j-1] + D[i-1][j] - D[i-1][j-1] + num[i][j] ;
            }
        }


        int[] location = new int[4];

        for (int i = 0; i < question; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < 4; k++) {
                location[k] = Integer.parseInt(stn.nextToken());

            }

            int x1= location[0];
            int y1= location[1];
            int x2= location[2];
            int y2= location[3];


            sb.append
                    (
                            (D[x2][y2] - D[x1 - 1][y2]
                            - D[x2][y1-1] + D[x1-1][y1-1] ) + "\n");
        }

        System.out.println(sb);



    }
}
