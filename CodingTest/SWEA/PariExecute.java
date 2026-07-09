package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PariExecute {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer stn ;
        for (int i = 0; i < TC; i++) {
            stn = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stn.nextToken());
            int M = Integer.parseInt(stn.nextToken());

            int[][] number = new int[N+2][N+2];
            for (int j = 1; j <= N+1; j++) {
                stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= N+1; k++) {
                    number[j][k] = Integer.parseInt(stn.nextToken());
                }
            }

            // 입력 받는건 끝남
            int sum=0;
            int max= 0;
            for (int j = 1; j <= N -M+ 1; j++) {// 아래로 내려갈수있는 횟수
                for (int k = 1; k <= N- M+ 1; k++) {// 오른쪽으로 갈수있는 횟수
                    // 전용 for문을 만들어야겠네
                    for (int l = j; l <= M+j-1; l++) { // y 축으로 내려가는부분
                        for (int m = k; m <= M + k - 1; m++) { // 오른쪽으로 가는부분
                            sum += number[l][m];
                        }
                    }

                    // 이렇게하면 2개 전용이잖아
                    if (sum > max) {
                        max = sum;
                    }
                    sum = 0;
                }
            }


            sb.append("#" + (i + 1) + " " + max + "\n");
        }
        System.out.println(sb);
    }
}
