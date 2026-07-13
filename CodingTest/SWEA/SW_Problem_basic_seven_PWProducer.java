package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Problem_basic_seven_PWProducer {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            int j = Integer.parseInt(br.readLine());

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            int[] number = new int[8];

            for (int k = 0; k < 8; k++) {
                number[k] = Integer.parseInt(stn.nextToken());
            }



            // 반복문이 있끝나는 경우  감소하는 해당비번이 0보다 작아지거나 0이되면  0으로 저장되어 비번 종료
            // 사이클주기 5 임
            int cycle = 0;
            while (number[number.length-1] > 0) { //맨뒷자리가 0이하면 종료
                // 초기값
                cycle ++;
                if (cycle == 6) {  // if문으로  사이클 주기가 6번쨰가되버리면 1로 초기화
                    cycle = 1;
                }
                // 앞으로 한칸씩 땡기는 부분 만들고
                int tmp = number[0] - cycle;
                // 맨앞을 뒤로 옮기면서 해당주기 만큼 뺴면될듯

                for (int k = 0; k < number.length - 1; k++) {
                    number[k] = number[k + 1];
                }
                number[number.length - 1] = tmp;



            }

            number[number.length-1] = 0;

            sb.append("#" + (i + 1) + " ");
            for (int i1 : number) {
                sb.append(i1 + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
