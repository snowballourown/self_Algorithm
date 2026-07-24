package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;

public class daegaehol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int TC = 10;


        for (int i = 0; i < TC; i++) {


            // 이것또한 상태코드로하면 쉽게 가겠는데?
            // 4개 모두다 상태가 0이면 모두 딱맞게 간거아니야? 끄치?
            int n = Integer.parseInt(br.readLine());

            String s  = br.readLine();
            char[] arr = s.toCharArray();
            int [] state = new  int[4];
            for (int j = 0; j < n; j++) {
                if (arr[j] == '(') {
                    state[0]++;
                }
                if (arr[j] == '{') {
                    state[1]++;
                }
                if (arr[j] == '[') {
                    state[2]++;
                }
                if (arr[j] == '<') {
                    state[3]++;
                }
                if (arr[j] == ')') {
                    state[0]--;
                }
                if (arr[j] == '}') {
                    state[1]--;
                }
                if (arr[j] == ']') {
                    state[2]--;
                }
                if (arr[j] == '>') {
                    state[3]--;
                }


            }
            int sum = 1;
            for (int j = 0; j < 4; j++) {
                if (state[j] != 0) {
                    sum = 0;
                    break;
                }
            }

                sb.append("#" + (i+1) +" "+ sum+"\n");






        }

        System.out.println(sb);

    }
}
