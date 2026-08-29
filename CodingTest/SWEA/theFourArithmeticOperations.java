package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class theFourArithmeticOperations {

    public  static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 1;
            for (int j = 0; j < N; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                int num2 = Integer.parseInt(stn.nextToken());
                String command = stn.nextToken();
                if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) { // 남은 토큰이 2개여야함
                    if (stn.countTokens() != 2) {
                       answer = 0;
                    }
                    while (stn.hasMoreElements()){
                        stn.nextToken();
                    }

                } else{ // 숫자 일경우  이제 남은 토큰 없음
                    if (stn.countTokens() != 0) {
                        answer = 0;
                    }
                    while (stn.hasMoreElements()){
                        stn.nextToken();
                    }




                }








            }
            sb.append("#").append(i+1).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);

    }



}
