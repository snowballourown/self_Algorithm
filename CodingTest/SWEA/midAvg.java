package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class midAvg {
    public static void main(String[] args) throws IOException {

        //D2  정답률이 많이 낫길레 도전~


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++) {
            double sum =0L;

            int num[] = new int[10];
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 10; j++) { // 다 받음
                num[j] = Integer.parseInt(stn.nextToken());
            }

            for (int i1 : num) { // 최대, 최소값 받기
                if (max < i1) {
                    max = i1;
                }
                if (min > i1) {
                    min = i1;
                }
            }
            int[] num_answer = new int[10];
            for (int k = 0; k < 10; k++) { // 최소 최대 값은 패스
                if (num[k] == max || num[k] == min) {
                    continue; //int니까 0으로 자동으로 채워짐
                }
                num_answer[k] = num[k];
            }

            for (int i1 : num_answer) {
                sum += i1;
            }
            sum =  sum / 8.0;

            int a = (int)sum;

            if (sum % a >= 0.5) {
                a++;
            }




            sb.append("#" + (i + 1) + " " + a + "\n");
        }

        System.out.println(sb);



    }
}
