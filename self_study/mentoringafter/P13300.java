package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13300 {
    public static void main(String[] args) throws IOException {
        //K은 방당 최대인원수, N은 인원수
        // 각 성별을 체크후 나누고
        // 남자 몇학년 몇명인지 구하고 /k 를 하고 나머지가있으니 + K-1개 하면되지
        // 방체크하고 합하면 끝
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] count = new int[2][7]; // [성별][학년]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 성별
            int Y = Integer.parseInt(st.nextToken()); // 학년

            count[S][Y]++;
        }
        int result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                result += (count[i][j] + K - 1) / K;
            }
        }
        System.out.println(result);
    }
}
