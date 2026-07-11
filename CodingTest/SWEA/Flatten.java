package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Flatten {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  TC = 10;
        int[] number = new int[101];
        StringTokenizer stn;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int move = Integer.parseInt(br.readLine());

            // 숫자를 기억해야함 최소값을 가진친구를 기억해서
            // 최소값과 최대값이 결정되면 +1 -1 를 해줘야함

            // 이과정이 다끝나면 최대값 - 최소값 차이를 내보내면됨

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            int max_int=0;
            int min_int=0;
            // 숫자들을 넣어줘야함
            stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 100; j++) {
                number[j] = Integer.parseInt(stn.nextToken()); // 층의 크기를 입력 받는거라고 생각해야지
            }

            for (int k = 0; k < move; k++) { //
                 for (int j = 1; j <= 100; j++) { // 최대 최소 찾고
                        if (max <= number[j]) {
                            max = number[j];
                            max_int = j;
                        }
                        if (min >= number[j]) {
                            min = number[j];
                            min_int = j;

                        }
                 }


                 number[max_int]--;
                number[min_int]++;




                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;

            }


            for (int j = 1; j <= 100; j++) { // 최대 최소 찾고
                if (max <= number[j]) {
                    max = number[j];
                    max_int = j;
                }
                if (min >= number[j]) {
                    min = number[j];
                    min_int = j;
                }
            }



            int answer = number[max_int] - number[min_int];


            sb.append("#"+(i+1) + " " + answer + "\n");
        }
        System.out.println(sb);

    }
}
