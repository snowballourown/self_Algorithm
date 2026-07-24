package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryRestore {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {

           String s = br.readLine();
           int [] num = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                num[j] = s.charAt(j) - '0';
            }// 입력값 다받음
            // 초기값은 0으로 시작함


            // 일반 1로 나오는 첫인덱스를 발견하면  1+
            int bitstate= 0;
            int count =0;
            for (int j = 0; j < s.length(); j++) {
                if (num[j] == 1) {
                    if (bitstate == 0) {
                        count++;
                        bitstate=1;

                    }
                } else if (num[j] == 0) {
                    if (bitstate == 1) {
                        count++;
                        bitstate=0;

                    }
                }

            }
            sb.append("#" + (i + 1) + " " + count + "\n");




            // 이것도 상태값 기억을 로 할수있을것같은데?
            // status =1로 기억했다가 그다음 숫자도 1이면 패스
            // 그다음숫자가 =0이면 0으로 바꾸고 count








        }
        System.out.println(sb);

    }
}
