package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P11328 {
    public static void main(String[] args) throws IOException {
        // N의 학생수
        // K 방최대 인원
        // 성별 //  학년 입력 받음
        // 배열을 2차원으로 해서 각 행렬에 더하면됨
        // 학생 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        int[][] num = new int[2][7];

        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());

            num[a][b]++;

        }
        int sum = 0;  // 방개수

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                // 필요한 방의 개수 찾기
                sum += (num[i][j]+ K -1)/ K; // 1명이 남아도 결국 방의 개수를 잡아야하기떄문에
             }
        }


        System.out.println(sum);












    }
}
